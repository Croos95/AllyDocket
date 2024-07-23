import java.util.ArrayList;
import java.util.List;

public class GeneradorCodigoEnsamblador {

    private List<String> instruccionesEnsamblador = new ArrayList<>();

    public void agregarInstruccion(String instruccion) {
        instruccionesEnsamblador.add(instruccion);
    }

    public String obtenerCodigoEnsamblador() {
        return String.join("\n", instruccionesEnsamblador);
    }

    public List<String> getInstruccionesEnsamblador() {
        return instruccionesEnsamblador;
    }
}
