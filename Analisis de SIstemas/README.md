# Taller 1

This Java project generates genetic sequences, calculates the entropy of those sequences, and finds the most frequent motif within a set of sequences. It also allows saving the generated genetic database to a text file using concurrent processing.

## Main Features

1. **Genetic sequence generation:**
   - Sequences are generated based on defined probabilities for each nucleotide (`A`, `C`, `G`, `T`).
   - You can generate sequences in memory or save them to a text file.

2. **Entropy calculation:**
   - Calculates the **Shannon entropy** of a sequence to measure its level of uncertainty or disorder.

3. **Motif search:**
   - Finds the most frequent motif within the sequences.
   - Breaks ties between motifs with the same frequency based on the number of consecutively repeated bases.

4. **Filtering by entropy:**
   - Filters sequences with entropy greater than or equal to a given threshold.

## Requirements

- **Java 8 or higher** 
- **Maven or Gradle** (optional if you want to manage dependencies)

## How to Use

### Generate the genetic database

You can generate a genetic sequence database using the `generarBaseDatosEnMemoria` or `generarBaseDatosYGuardarEnArchivo` methods. Example:

```java
int numSecuencias = 10000; // Number of sequences
int tamanoSecuencia = 10;   // Length of each sequence
double probA = 0.4, probC = 0.2, probG = 0.2, probT = 0.2; // Probabilities for nucleotides
String filePath = "base_de_datos_genetica.txt"; // File path

// Generate and save the database to a file
BaseDeDatosGenetica.generarBaseDatosYGuardarEnArchivo(numSecuencias, tamanoSecuencia, probA, probC, probG, probT, filePath);
