import java.util.ArrayList;
import java.util.List;

public class codigoIntermedio {

    public static class Quadruple {
        public String operacion;
        public String operador1;
        public String operador2;
        public String resultado;

        public Quadruple(String operacion, String operador1, String operador2, String resultado) {
            this.operacion = operacion;
            this.operador1 = operador1;
            this.operador2 = operador2;
            this.resultado = resultado;
        }

        @Override
        public String toString() {
            return resultado + " = " + operador1 + " " + operacion + " " + operador2;
        }
    }

    public List<Quadruple> codigoIntermedio = new ArrayList<>();
    private int contadorTemporal = 0;

    public String generarTemporal() {
        return "T" + (contadorTemporal++);
    }

    public void generarCodigoIntermedio(String operacion, String operando1, String operando2) {
        String operador = obtenerOperador(operacion);
        String temporal = generarTemporal();
        codigoIntermedio.add(new Quadruple(operador, operando1, operando2, temporal));
        System.out.println(operando1 + " " + operador + " " + operando2 + " -> " + temporal);
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
