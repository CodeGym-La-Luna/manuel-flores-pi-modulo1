package src;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;

public class AdministradorDeArchivos {

    public static String leerArchivo(String filePath) {// File reading logic

        Path rutaTextoEntrada = Path.of(filePath);
        String TextoEntrada = "";
        try(FileChannel canal = FileChannel.open(rutaTextoEntrada, StandardOpenOption.READ)){
            ByteBuffer buffer = ByteBuffer.allocate(10485760);
            int bytesDelTexto;
            while ((bytesDelTexto = canal.read(buffer)) > 0){
                buffer.flip();
                byte[] ArregloDeBytes = new byte[bytesDelTexto];
                buffer.get(ArregloDeBytes);
                TextoEntrada = new String(ArregloDeBytes);
                buffer.clear();
            }
        }catch (IOException e){
            System.out.println(e.getMessage());
        }
        return TextoEntrada;
    }
    public static void escribirArchivo(String entrada, String filePath) {// Logic for writing a file

        Path rutaTextoSalida = Path.of(filePath);
        try {
            Files.createFile(rutaTextoSalida);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

        try(FileChannel canal = FileChannel.open(rutaTextoSalida, StandardOpenOption.WRITE)){
            ByteBuffer buffer = ByteBuffer.wrap(entrada.getBytes());
            canal.write(buffer);
            buffer.clear();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}