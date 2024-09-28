package src;

import java.nio.file.Files;
import java.nio.file.Path;

public class Validador {
    public static boolean claveValida(int clave, String alfabeto) {// Key check

        return (clave > 0 && clave < alfabeto.length());

    }

    public static boolean comprobarExistencia(String filePath) {// Check if the file exists
        Path rutaDeArchivo = Path.of(filePath);
        return Files.exists(rutaDeArchivo);
    }
}