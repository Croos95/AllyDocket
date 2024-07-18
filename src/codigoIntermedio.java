import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

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
            return imprimirCI();
        }

        public String imprimirCI() {
            switch (operador) {
                case "=":
                    return resultado + " " + operador + " " + operador1;
                case "==":
                case "!=":
                case "<<":
                case ">=":
                case "<=":
                case ">>":
                    return "SI" + operador1 + " " + operador + " " + operador2 + " " + resultado;
                case "Label":
                    return resultado + ":";
                default:
                    return resultado + " = " + operador1 + " " + operador + " " + operador2;
            }
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj) return true;
            if (obj == null || getClass() != obj.getClass()) return false;
            Quadruple quadruple = (Quadruple) obj;
            return operador.equals(quadruple.operador) &&
                   operador1.equals(quadruple.operador1) &&
                   operador2.equals(quadruple.operador2) &&
                   resultado.equals(quadruple.resultado);
        }

        @Override
        public int hashCode() {
            return Objects.hash(operador, operador1, operador2, resultado);
        }
    }

    public static List<Quadruple> codigoIntermedio = new ArrayList<>();
    public static Set<Quadruple> operacionesUnicas = new HashSet<>();
    public static int contadorTemporal = 0;

    public String generarTemporal() {
        return "T" + (contadorTemporal++);
    }

    public void generarCodigoIntermedio(String operacion, String operando1, String operando2, String resultado) {
        String operador = obtenerOperador(operacion);
        Quadruple nuevaOperacion = new Quadruple(operador, operando1, operando2, resultado);

        if (!operacionesUnicas.contains(nuevaOperacion)) {
            codigoIntermedio.add(nuevaOperacion);
            operacionesUnicas.add(nuevaOperacion);
            System.out.println(operando1 + " " + operador + " " + operando2 + " -> " + resultado);
        }
    }

    public void generarCodigoIntermedioVariables(String operacion, String operando1, String operando2, String resultado) {
        generarCodigoIntermedio(operacion, operando1, operando2, resultado);
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
            case "IGUALDAD":
                return "==";
            case "DESIGUALDAD":
                return "!=";
            case "MENORQUE":
                return "<<";
            case "MAYORIGUALQUE":
                return ">=";
            case "MENORIGUALQUE":
                return "<=";
            case "MAYORQUE":
                return ">>";
            case "LABEL":
                return "Label";
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
