package src;

import java.nio.file.Files;
import java.nio.file.Path;

public class Validador {
//    public boolean isValidKey(int key, char[] alphabet) {
//        // Key check
//    }
    public static boolean comprobarExistencia(String filePath) {
        // Check if the file exists

        Path rutaDeArchivo = Path.of(filePath);
        return Files.exists(rutaDeArchivo);
    }
}