import java.util.ArrayList;
import java.util.List;

public class FiltrarPorEntropia {

    public static List<String> filtrarSecuenciasPorEntropia(String[] secuencias, double umbral) {
        List<String> secuenciasFiltradas = new ArrayList<>();

        for (String secuencia : secuencias) {
            double entropia = Entropia.calcularEntropia(secuencia);
            if (entropia >= umbral) {
                secuenciasFiltradas.add(secuencia);
            }
        }

        return secuenciasFiltradas;
    }
}
