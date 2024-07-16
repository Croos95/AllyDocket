import java.util.ArrayList;
import java.util.List;

public class codigoIntermedio {

    public static class Quadruple {

        public String operador;
        public String operador1;
        public String operador2;
        public String resultado;

        public Quadruple(String operador, String operador1, String operador2, String resultado) {
            this.operador = operador;
            this.operador1 = operador1;
            this.operador2 = operador2;
            this.resultado = resultado;
        }

        @Override
        public String toString() {
            if (operador.equals("=")) {
                return operador + " , " + operador1 + " , " + resultado;
            } else {
                return operador + " , " + operador1 + " , " + operador2 + " , " + resultado;
            }
        }
    }

    public static List<Quadruple> codigoIntermedio = new ArrayList<>();
    public static int contadorTemporal = 0;

    public String generarTemporal() {
        return "T" + (contadorTemporal++);
    }

    public void generarCodigoIntermedio(String operacion, String operando1, String operando2, String resultado) {
        String operador = obtenerOperador(operacion);
        codigoIntermedio.add(new Quadruple(operador, operando1, operando2, resultado));
        System.out.println(operando1 + " " + operador + " " + operando2 + " -> " + resultado);
    }

    public String obtenerOperador(String operacion) {
        switch (operacion) {
            case "MULTIPLICACION":
                return "*";
            case "DIVISION":
                return "/";
            case "SUMA":
                return "+";
            case "RESTA":
                return "-";
            case "ASIGNAR":
                return "=";  
            default:
                return "";
        }
    }

    public void imprimirCodigoIntermedio() {
        for (Quadruple quad : codigoIntermedio) {
            // Aquí se manda a un textArea en la GUI del frame Compilador
            Compilador.jTextAreaCodigoIntermedio.append(quad.toString() + "\n");
            Compilador.tablaC.addRow(new Object[]{quad.operador, quad.operador1, quad.operador2, quad.resultado});
        }
    }
}
