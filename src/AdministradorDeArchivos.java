package src;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;

public class AdministradorDeArchivos {

    public static String leerArchivo(String filePath) {
        // File reading logic

        Path rutaTextoNoCifrado = Path.of(filePath);
        String TextoNoCifrado = "";
        try(FileChannel canal = FileChannel.open(rutaTextoNoCifrado, StandardOpenOption.READ)){
            ByteBuffer buffer = ByteBuffer.allocate(1024);
            int bytesDelTexto;
            while ((bytesDelTexto = canal.read(buffer)) > 0){
                buffer.flip();
                byte[] ArregloDeBytes = new byte[bytesDelTexto];
                buffer.get(ArregloDeBytes);
                TextoNoCifrado = new String(ArregloDeBytes);
                buffer.clear();
            }
        }catch (IOException e){
            System.out.println(e.getMessage());
        }
        return TextoNoCifrado;
    }
    public static void escribirArchivo(String content, String filePath) {
        // Logic for writing a file


        Path rutaTextoCifrado = Path.of(filePath);
        try {
            Files.createFile(rutaTextoCifrado);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

        try(FileChannel canal = FileChannel.open(rutaTextoCifrado, StandardOpenOption.WRITE)){
            String textoCifrado = content;
            ByteBuffer buffer = ByteBuffer.wrap(textoCifrado.getBytes());
            canal.write(buffer);
            buffer.clear();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}