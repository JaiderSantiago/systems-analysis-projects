import java.util.List;

public class Main {

    public static void main(String[] args) {
        
        int n = 10000; 
        int m = 10; 
        double probA = 0.4, probC = 0.2, probG = 0.2, probT = 0.2; 
        int s = 5; 
        String filePath = "base_de_datos_genetica.txt"; 

 
        BaseDeDatosGenetica.generarBaseDatosYGuardarEnArchivo(n, m, probA, probC, probG, probT, filePath);


        String[] baseDeDatos = BaseDeDatosGenetica.generarBaseDatosEnMemoria(n, m, probA, probC, probG, probT);

        
        long startTime = System.currentTimeMillis();

      
        MotifFinder.ResultadoMotif resultadoMotif = MotifFinder.encontrarMotif(baseDeDatos, s);

        long endTime = System.currentTimeMillis();
        long tiempoEjecucion = endTime - startTime;

      
        System.out.println("Motif más frecuente: " + resultadoMotif.motif);
        System.out.println("Ocurrencias del motif: " + resultadoMotif.ocurrencias);
        System.out.println("Tiempo para encontrar el motif: " + tiempoEjecucion + " ms");

        
        double umbralEntropia = 1.5;  
        List<String> secuenciasFiltradas = FiltrarPorEntropia.filtrarSecuenciasPorEntropia(baseDeDatos, umbralEntropia);
        System.out.println("Número de secuencias filtradas: " + secuenciasFiltradas.size());

        
    }
}
