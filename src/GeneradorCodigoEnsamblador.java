import compilerTools.Production;
import compilerTools.Token;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GeneradorCodigoEnsamblador {
    
    private List<String> instrucciones = new ArrayList<>();
    private int contadorTemporal = 0;
    public String inicioASM = ".MODEL SMALL\n"
            + ".STACK\n"
            + ".DATA\n";
    List<String> operandos = new ArrayList<>();
    public Compilador cmp = new Compilador();


    public GeneradorCodigoEnsamblador() {
    
    }
    public void agregarInstruccion(String instruccion) {
        instrucciones.add(instruccion);
    }

    public String obtenerCodigoEnsamblador() {
        StringBuilder codigo = new StringBuilder();
        for (String instruccion : instrucciones) {
            codigo.append(instruccion).append("\n");
        }
        return codigo.toString();
    }

    public void limpiarInstrucciones() {
        instrucciones.clear();
    }
     //CODIGO OBJETO
    public void generarCodigoASM() {
        limpiarInstrucciones();
        int etiqueta = 0;
        if (!cmp.siProd.isEmpty()) {
            for (Production prod : cmp.siProd) {
                String operando1 = prod.lexemeRank(2);
                String operador = prod.lexemeRank(3);
                String operando2 = prod.lexemeRank(4);
                etiqueta++;
                String etiquetaFin = "Label" + etiqueta;
                switch (operador) {
                    case "==":
                        agregarInstruccion("CMP " + operando1 + ", " + operando2);
                        agregarInstruccion("JE " + etiquetaFin);
                        break;
                    case "!=":
                        agregarInstruccion("CMP " + operando1 + ", " + operando2);
                        agregarInstruccion("JNE " + etiquetaFin);
                        break;
                    case "<<":
                        agregarInstruccion("CMP " + operando1 + ", " + operando2);
                        agregarInstruccion("JL " + etiquetaFin);
                        break;
                    case ">>":
                        agregarInstruccion("CMP " + operando1 + ", " + operando2);
                        agregarInstruccion("JG " + etiquetaFin);
                        break;
                    case "<=":
                        agregarInstruccion("CMP " + operando1 + ", " + operando2);
                        agregarInstruccion("JLE " + etiquetaFin);
                        break;
                    case ">=":
                        agregarInstruccion("CMP " + operando1 + ", " + operando2);
                        agregarInstruccion("JGE " + etiquetaFin);
                        break;
                }
                cmp.verificacionSemanticaEnBloque(prod);
                generacionCodigoEnsambladorEnBloque(prod);
                agregarInstruccion(etiquetaFin + ":");
            }
        }
        if (!cmp.mientrasProd.isEmpty()) {
            for (Production prod : cmp.mientrasProd) {
                String operando1 = prod.lexemeRank(2);
                String operador = prod.lexemeRank(3);
                String operando2 = prod.lexemeRank(4);
                int etiquetaInicio = etiqueta;
                int etiquetaFin = etiqueta + 1;
                etiqueta += 2;

                agregarInstruccion("Label" + etiquetaInicio + ":");
                switch (operador) {
                    case "==":
                        agregarInstruccion("CMP " + operando1 + ", " + operando2);
                        agregarInstruccion("JE Label" + etiquetaFin);
                        break;
                    case "!=":
                        agregarInstruccion("CMP " + operando1 + ", " + operando2);
                        agregarInstruccion("JNE Label" + etiquetaFin);
                        break;
                    case "<<":
                        agregarInstruccion("CMP " + operando1 + ", " + operando2);
                        agregarInstruccion("JL Label" + etiquetaFin);
                        break;
                    case ">>":
                        agregarInstruccion("CMP " + operando1 + ", " + operando2);
                        agregarInstruccion("JG Label" + etiquetaFin);
                        break;
                    case "<=":
                        agregarInstruccion("CMP " + operando1 + ", " + operando2);
                        agregarInstruccion("JLE Label" + etiquetaFin);
                        break;
                    case ">=":
                        agregarInstruccion("CMP " + operando1 + ", " + operando2);
                        agregarInstruccion("JGE Label" + etiquetaFin);
                        break;
                }
                cmp.verificacionSemanticaEnBloque(prod);
                generacionCodigoEnsambladorEnBloque(prod);
                agregarInstruccion("JMP Label" + etiquetaInicio);
                agregarInstruccion("Label" + etiquetaFin + ":");
            }
        }
        for (Production prod : cmp.mainProd) {
            cmp.verificacionSemantica(prod);
            generacionCodigoEnsamblador(prod);
        }

        // Mostrar código ensamblador en jTextASMpreview
        String codigoEnsamblador = obtenerCodigoEnsamblador();
        Compilador.jTextASMpreview.setText(codigoEnsamblador);
    }

    private void generacionCodigoEnsamblador(Production prod) {
        for (Token token : prod.getTokens()) {
            switch (token.getLexeme()) {
                case "DIVISION":
                case "MULTIPLICACION":
                case "SUMA":
                case "RESTA":
                    generarOperacionASM(prod, token);
                    break;
                case "ASIGNAR":
                    generarAsignacionASM(prod, token);
                    break;
                case "IMPRIMIR":
                    generarImprimirASM(prod, token);
                    break;
                default:
                    break;
            }
        }
    }

    private void generacionCodigoEnsambladorEnBloque(Production bloque) {
        for (Token token : bloque.getTokens()) {
            switch (token.getLexeme()) {
                case "DIVISION":
                case "MULTIPLICACION":
                case "SUMA":
                case "RESTA":
                    generarOperacionASM(bloque, token);
                    break;
                case "ASIGNAR":
                    generarAsignacionASM(bloque, token);
                    break;
                case "IMPRIMIR":
                    generarImprimirASM(bloque, token);
                    break;
                default:
                    break;
            }
        }
    }

    private void generarOperacionASM(Production currentOp, Token token) {
        List<String> valoresValidos = Arrays.asList("IDENTIFICADOR", "NUMERO", "NDECIMAL");
        int j = currentOp.getTokens().indexOf(token) + 2;
        String operacion = token.getLexeme();
        String operando1 = currentOp.lexemeRank(j);
        String operando2 = currentOp.lexemeRank(j + 2);
        String temporal = generarTemporal();

        switch (operacion) {
            case "MULTIPLICACION":
                agregarInstruccion("MOV AX, " + operando1);
                agregarInstruccion("MUL " + operando2);
                agregarInstruccion("MOV " + temporal + ", AX");
//                for (int i = 1; i < operandos.size(); i++) {
//                    String operando = operandos.get(i);
//                    String nuevoTemp = GCI.generarTemporal();
//                    String operacionString = operacion + temporal + operando;
//                    if (!operacionesGeneradas.contains(operacionString)) {
//                         agregarInstruccion("MOV AX, " + operando1);
//                         agregarInstruccion("MUL " + operando2);
//                        temporal = nuevoTemp;
//                        operacionesGeneradas.add(operacionString);
//                    } else {
//                        opRealizada = true;
//                    }
//                }
                if (!cmp.opRealizada) {
                    agregarInstruccion("MOV " + temporal + ", AX");
                    operandos.clear();
                }
                operandos.clear();
                break;
            case "DIVISION":
                agregarInstruccion("MOV AX, " + operando1);
                agregarInstruccion("DIV " + operando2);
                agregarInstruccion("MOV " + temporal + ", AX");
                break;
            case "SUMA":
                agregarInstruccion("MOV AX, " + operando1);
                agregarInstruccion("ADD AX, " + operando2);
                agregarInstruccion("MOV " + temporal + ", AX");
                break;
            case "RESTA":
                agregarInstruccion("MOV AX, " + operando1);
                agregarInstruccion("SUB AX, " + operando2);
                agregarInstruccion("MOV " + temporal + ", AX");
                break;
        }
        agregarInstruccion("MOV " + currentOp.lexemeRank(j + 4) + ", " + temporal);
    }

    private void generarAsignacionASM(Production currentOp, Token token) {
        int j = currentOp.getTokens().indexOf(token);
        String variableDestino = currentOp.lexemeRank(j + 2);
        String variableOrigen = currentOp.lexemeRank(j + 5);
        agregarInstruccion("MOV " + variableDestino + ", " + variableOrigen);
    }

    private void generarImprimirASM(Production currentOp, Token token) {
        // Implementar lógica para la operación IMPRIMIR si es necesario
    }

    private String generarTemporal() {
        return "T" + (contadorTemporal++);
    }

    //CODIGO OBJETO
}