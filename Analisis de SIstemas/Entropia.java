import java.util.HashMap;
import java.util.Map;

public class Entropia {

    public static double calcularEntropia(String secuencia) {
        Map<Character, Integer> frecuencias = new HashMap<>();
        int longitud = secuencia.length();

        for (char base : secuencia.toCharArray()) {
            frecuencias.put(base, frecuencias.getOrDefault(base, 0) + 1);
        }

        double entropia = 0.0;
        for (Map.Entry<Character, Integer> entry : frecuencias.entrySet()) {
            double probabilidad = (double) entry.getValue() / longitud;
            entropia -= probabilidad * (Math.log(probabilidad) / Math.log(2)); 
        }

        return entropia;
    }
}
