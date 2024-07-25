import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class codigoObjeto {
    private StringBuilder asm;
    private Set<String> etiquetasUsadas;
    private Set<String> variablesDeclaradas;
    private Set<String> temporalesDeclarados;

    public codigoObjeto() {
        asm = new StringBuilder();
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
        asm.append("END START\n");
    }

    private void traducirCuadruplo(codigoIntermedio.Quadruple quad) {
        switch (quad.operador) {
            case "=":
                asm.append("MOV AX, ").append(quad.operador1.replace("#", "")).append("\n");
                asm.append("MOV ").append(quad.resultado.replace("#", "")).append(", AX\n");
                break;
            case "+":
                asm.append("MOV AX, ").append(quad.operador1.replace("#", "")).append("\n");
                asm.append("ADD AX, ").append(quad.operador2.replace("#", "")).append("\n");
                asm.append("MOV ").append(quad.resultado).append(", AX\n");
                break;
            case "-":
                asm.append("MOV AX, ").append(quad.operador1.replace("#", "")).append("\n");
                asm.append("SUB AX, ").append(quad.operador2.replace("#", "")).append("\n");
                asm.append("MOV ").append(quad.resultado).append(", AX\n");
                break;
            case "*":
                asm.append("MOV AX, ").append(quad.operador1.replace("#", "")).append("\n");
                asm.append("MUL ").append(quad.operador2.replace("#", "")).append("\n");
                asm.append("MOV ").append(quad.resultado).append(", AX\n");
                break;
            case "/":
                asm.append("MOV AX, ").append(quad.operador1.replace("#", "")).append("\n");
                asm.append("DIV ").append(quad.operador2.replace("#", "")).append("\n");
                asm.append("MOV ").append(quad.resultado).append(", AX\n");
                break;
            case "LABEL":
                agregarEtiqueta(quad.resultado);
                break;
            case "GOTO":
                asm.append("JMP ").append(quad.resultado).append("\n");
                break;
            case "==":
                asm.append("MOV AX, ").append(quad.operador1.replace("#", "")).append("\n");
                asm.append("CMP AX, ").append(quad.operador2.replace("#", "")).append("\n");
                asm.append("JE ").append(quad.resultado).append("\n");
                break;
            case "!=":
                asm.append("MOV AX, ").append(quad.operador1.replace("#", "")).append("\n");
                asm.append("CMP AX, ").append(quad.operador2.replace("#", "")).append("\n");
                asm.append("JNE ").append(quad.resultado).append("\n");
                break;
            case "<<":
                asm.append("MOV AX, ").append(quad.operador1.replace("#", "")).append("\n");
                asm.append("CMP AX, ").append(quad.operador2.replace("#", "")).append("\n");
                asm.append("JL ").append(quad.resultado).append("\n");
                break;
            case ">>":
                asm.append("MOV AX, ").append(quad.operador1.replace("#", "")).append("\n");
                asm.append("CMP AX, ").append(quad.operador2.replace("#", "")).append("\n");
                asm.append("JG ").append(quad.resultado).append("\n");
                break;
            case "<=":
                asm.append("MOV AX, ").append(quad.operador1.replace("#", "")).append("\n");
                asm.append("CMP AX, ").append(quad.operador2.replace("#", "")).append("\n");
                asm.append("JLE ").append(quad.resultado).append("\n");
                break;
            case ">=":
                asm.append("MOV AX, ").append(quad.operador1.replace("#", "")).append("\n");
                asm.append("CMP AX, ").append(quad.operador2.replace("#", "")).append("\n");
                asm.append("JGE ").append(quad.resultado).append("\n");
                break;
            default:
                throw new UnsupportedOperationException("Operador no soportado: " + quad.operador);
        }
    }

    // Método para obtener el código ensamblador completo
    public String obtenerCodigoASM() {
        return asm.toString();
    }
}
