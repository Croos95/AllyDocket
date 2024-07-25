
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class codigoObjeto {

    public StringBuilder asm;
    private Set<String> etiquetasUsadas;
    private Set<String> variablesDeclaradas;
    private Set<String> temporalesDeclarados;

    public codigoObjeto() {
        asm = new StringBuilder();
        asm.setLength(0);
        etiquetasUsadas = new HashSet<>();
        variablesDeclaradas = new HashSet<>();
        temporalesDeclarados = new HashSet<>();
        // Inicializar la cabecera del ensamblador
        asm.append(".MODEL SMALL\n");
        asm.append(".STACK 100h\n");
        asm.append(".DATA\n");
    }

    // Método para agregar una variable
    public void agregarVariable(String nombre, String valor) {
        if (!variablesDeclaradas.contains(nombre)) {
            asm.append(nombre.replace("#", "")).append(" DW ").append(valor).append("\n");
            variablesDeclaradas.add(nombre);
        }
    }

    // Método para agregar una etiqueta única
    public void agregarEtiqueta(String etiqueta) {
        if (!etiquetasUsadas.contains(etiqueta)) {
            asm.append(etiqueta).append(":\n");
            etiquetasUsadas.add(etiqueta);
        }
    }

    // Método para agregar un temporal
    public void agregarTemporal(String nombre) {
        if (!temporalesDeclarados.contains(nombre)) {
            asm.append(nombre).append(" DW ?\n");
            temporalesDeclarados.add(nombre);
        }
    }

    // Método para agregar código ensamblador
    public void agregarCodigo(String codigo) {
        asm.append(codigo).append("\n");
    }

    // Método para generar código objeto a partir del código intermedio
    public void generarCodigoObjeto(List<codigoIntermedio.Quadruple> codigoIntermedio) {
    for (codigoIntermedio.Quadruple quad : codigoIntermedio) {
        // Agregar temporales a la sección .DATA si no están declarados
        if (quad.resultado.startsWith("T")) {
            agregarTemporal(quad.resultado);
        }
    }

    asm.append(".CODE\n");
    asm.append("START:\n");
    asm.append("MOV AX, @DATA\n");
    asm.append("MOV DS, AX\n");
    asm.append("MOV ES, AX\n");

    for (codigoIntermedio.Quadruple quad : codigoIntermedio) {
        traducirCuadruplo(quad);
    }

    asm.append("MOV AX, 4C00h\n");
    asm.append("INT 21h\n");
 

    // Añadir la función de impresión al final del código
    asm.append("PRINT_NUM:\n");
    asm.append("PUSH AX\n");
    asm.append("PUSH BX\n");
    asm.append("PUSH CX\n");
    asm.append("PUSH DX\n");
    asm.append("MOV BX, 10\n");
    asm.append("MOV CX, 0\n");
    asm.append("MOV DX, 0\n");
    asm.append("DIVIDE:\n");
    asm.append("XOR DX, DX\n");
    asm.append("DIV BX\n");
    asm.append("PUSH DX\n");
    asm.append("INC CX\n");
    asm.append("OR AX, AX\n");
    asm.append("JNZ DIVIDE\n");
    asm.append("PRINT_LOOP:\n");
    asm.append("POP DX\n");
    asm.append("ADD DL, 30h\n");
    asm.append("MOV AH, 02h\n");
    asm.append("INT 21h\n");
    asm.append("LOOP PRINT_LOOP\n");
    asm.append("POP DX\n");
    asm.append("POP CX\n");
    asm.append("POP BX\n");
    asm.append("POP AX\n");
    asm.append("RET\n");
    asm.append("END START\n");
}


    private void traducirCuadruplo(codigoIntermedio.Quadruple quad) {
    // Lista de registros disponibles
    String[] registros = {"AX", "BX", "CX", "DX"};
    // Variables para almacenar los registros utilizados
    String reg1 = "AX";
    String reg2 = "BX";

    switch (quad.operador) {
        case "=":
            reg1 = registros[0];
            asm.append("MOV ").append(reg1).append(", ").append(quad.operador1.replace("#", "")).append("\n");
            asm.append("MOV ").append(quad.resultado.replace("#", "")).append(", ").append(reg1).append("\n");
            break;
        case "+":
            reg1 = registros[0];
            reg2 = registros[1];
            asm.append("MOV ").append(reg1).append(", ").append(quad.operador1.replace("#", "")).append("\n");
            asm.append("ADD ").append(reg1).append(", ").append(quad.operador2.replace("#", "")).append("\n");
            asm.append("MOV ").append(quad.resultado.replace("#", "")).append(", ").append(reg1).append("\n");
            break;
        case "-":
            reg1 = registros[0];
            reg2 = registros[1];
            asm.append("MOV ").append(reg1).append(", ").append(quad.operador1.replace("#", "")).append("\n");
            asm.append("SUB ").append(reg1).append(", ").append(quad.operador2.replace("#", "")).append("\n");
            asm.append("MOV ").append(quad.resultado.replace("#", "")).append(", ").append(reg1).append("\n");
            break;
        case "*":
            reg1 = registros[0];
            reg2 = registros[1];
            asm.append("MOV ").append(reg1).append(", ").append(quad.operador1.replace("#", "")).append("\n");
            asm.append("MOV ").append(reg2).append(", ").append(quad.operador2.replace("#", "")).append("\n");
            asm.append("MUL ").append(reg2).append("\n");
            asm.append("MOV ").append(quad.resultado.replace("#", "")).append(", ").append(reg1).append("\n");
            break;
        case "/":
            reg1 = registros[0];
            reg2 = registros[1];
            asm.append("MOV ").append(reg1).append(", ").append(quad.operador1.replace("#", "")).append("\n");
            asm.append("MOV ").append(reg2).append(", ").append(quad.operador2.replace("#", "")).append("\n");
            asm.append("DIV ").append(reg2).append("\n");
            asm.append("MOV ").append(quad.resultado.replace("#", "")).append(", ").append(reg1).append("\n");
            break;
        case "LABEL":
            asm.append(quad.resultado).append(":\n");
            break;
        case "GOTO":
            asm.append("JMP ").append(quad.resultado).append("\n");
            break;
        case "==":
        case "!=":
        case "<<":
        case ">>":
        case "<=":
        case ">=":
            reg1 = registros[0];
            reg2 = registros[1];
            asm.append("MOV ").append(reg1).append(", ").append(quad.operador1.replace("#", "")).append("\n");
            asm.append("CMP ").append(reg1).append(", ").append(quad.operador2.replace("#", "")).append("\n");
            traducirSaltoCondicional(quad.operador, quad.resultado);
            break;
        case "IMPRIMIR":
            reg1 = registros[0];
            asm.append("MOV ").append(reg1).append(", ").append(quad.operador1.replace("#", "")).append("\n");
            asm.append("CALL PRINT_NUM\n"); // Llama a la función de impresión que se debe definir en ensamblador
            break;
        default:
            throw new UnsupportedOperationException("Operador no soportado: " + quad.operador);
    }
}

private void traducirSaltoCondicional(String operador, String etiqueta) {
    switch (operador) {
        case "==":
            asm.append("JE ").append(etiqueta).append("\n");
            break;
        case "!=":
            asm.append("JNE ").append(etiqueta).append("\n");
            break;
        case "<<":
            asm.append("JL ").append(etiqueta).append("\n");
            break;
        case ">>":
            asm.append("JG ").append(etiqueta).append("\n");
            break;
        case "<=":
            asm.append("JLE ").append(etiqueta).append("\n");
            break;
        case ">=":
            asm.append("JGE ").append(etiqueta).append("\n");
            break;
    }
}


    // Método para obtener el código ensamblador completo
    public String obtenerCodigoASM() {
        return asm.toString();
    }
}
