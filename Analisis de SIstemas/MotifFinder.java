import java.util.HashMap;
import java.util.Map;

public class MotifFinder {

    public static class ResultadoMotif {
        String motif;
        int ocurrencias;

        public ResultadoMotif(String motif, int ocurrencias) {
            this.motif = motif;
            this.ocurrencias = ocurrencias;
        }
    }

    public static ResultadoMotif encontrarMotif(String[] secuencias, int s) {
        Map<String, Integer> motifCount = new HashMap<>();

        for (String secuencia : secuencias) {
            for (int i = 0; i <= secuencia.length() - s; i++) {
                String subcadena = secuencia.substring(i, i + s);
                motifCount.put(subcadena, motifCount.getOrDefault(subcadena, 0) + 1);
            }
        }

        String motifMasFrecuente = null;
        int maxOcurrencias = 0;

        for (Map.Entry<String, Integer> entry : motifCount.entrySet()) {
            String motif = entry.getKey();
            int ocurrencias = entry.getValue();

            if (ocurrencias > maxOcurrencias || (ocurrencias == maxOcurrencias && tieneMasBasesRepetidas(motif))) {
                maxOcurrencias = ocurrencias;
                motifMasFrecuente = motif;
            }
        }

        return new ResultadoMotif(motifMasFrecuente, maxOcurrencias);
    }

    private static boolean tieneMasBasesRepetidas(String motif) {
        int maxRepeticiones = 1;
        int repetidasActuales = 1;

        for (int i = 1; i < motif.length(); i++) {
            if (motif.charAt(i) == motif.charAt(i - 1)) {
                repetidasActuales++;
                if (repetidasActuales > maxRepeticiones) {
                    maxRepeticiones = repetidasActuales;
                }
            } else {
                repetidasActuales = 1;
            }
        }
        return maxRepeticiones > 1;
    }
}


