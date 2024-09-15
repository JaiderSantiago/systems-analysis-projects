import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class BaseDeDatosGenetica {

    
    public static String[] generarBaseDatosEnMemoria(int numSecuencias, int tamanoSecuencia, double probA, double probC, double probG, double probT) {
        String[] baseDeDatos = new String[numSecuencias];
        Random random = new Random();

        for (int i = 0; i < numSecuencias; i++) {
            StringBuilder secuencia = new StringBuilder();
            for (int j = 0; j < tamanoSecuencia; j++) {
                secuencia.append(generarNucleotido(random, probA, probC, probG, probT));
            }
            baseDeDatos[i] = secuencia.toString();
        }

        return baseDeDatos;
    }

    
    public static void generarBaseDatosYGuardarEnArchivo(int numSecuencias, int tamanoSecuencia, double probA, double probC, double probG, double probT, String filePath) {
        ExecutorService executor = Executors.newFixedThreadPool(4); 

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            for (int i = 0; i < numSecuencias; i++) {
                final int index = i;
                executor.submit(() -> {
                    try {
                        StringBuilder secuencia = new StringBuilder();
                        Random random = new Random();
                        for (int j = 0; j < tamanoSecuencia; j++) {
                            secuencia.append(generarNucleotido(random, probA, probC, probG, probT));
                        }
                        synchronized (writer) {
                            writer.write(secuencia.toString());
                            writer.newLine();
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                });
            }

            executor.shutdown();
            executor.awaitTermination(1, TimeUnit.HOURS);
            System.out.println("Base de datos guardada en: " + filePath);
        } catch (IOException | InterruptedException e) {
            System.out.println("Error al escribir en el archivo: " + e.getMessage());
        }
    }

    private static char generarNucleotido(Random random, double probA, double probC, double probG, double probT) {
        double r = random.nextDouble();
        if (r < probA) {
            return 'A';
        } else if (r < probA + probC) {
            return 'C';
        } else if (r < probA + probC + probG) {
            return 'G';
        } else {
            return 'T';
        }
    }
}
