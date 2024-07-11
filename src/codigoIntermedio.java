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
            return resultado + " = " + operador1 + " " + operador + " " + operador2;
        }
    }

    public List<Quadruple> codigoIntermedio = new ArrayList<>();
    private int contadorTemporal = 0;

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
            default:
                return "NO HAY OPERADOR";
        }
    }

    public void imprimirCodigoIntermedio() {
        for (Quadruple quad : codigoIntermedio) {
            System.out.println(quad);
        }
    }
}
