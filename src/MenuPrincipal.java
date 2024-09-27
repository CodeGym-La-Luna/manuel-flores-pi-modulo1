package src;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Scanner;

public class MenuPrincipal {
    public static void main(String[] args) throws IOException {// Logic for selecting the operating mode, calling the appropriate methods
        int eleccion = 0;
        String rutaTextoEntrada = "src/resources/textoEntrada.txt";
        String rutaTextoSalida = "src/resources/textoSalida.txt";
        Path rutaTextoEntradaAbsoluta = Path.of(rutaTextoEntrada).toAbsolutePath();
        Path rutaTextoSalidaAbsoluta = Path.of(rutaTextoSalida).toAbsolutePath();

        Scanner sc = new Scanner(System.in);
        if (!Validador.comprobarExistencia(rutaTextoEntrada)) {
            Files.createFile(Path.of(rutaTextoEntrada));
        }
        System.out.println("\n**********CIFRADO CÉSAR**********");
        while (eleccion != 1 && eleccion != 2) {
            System.out.println("***Ingresa el numero de la acción requerida***");
            System.out.println("1 - Cifrar Texto");
            System.out.println("2 - Descifrar Texto");
            eleccion = sc.nextInt();
        }
        if (eleccion == 1){
            System.out.println("\n\n\n***Eligió Cifrar Texto***");
            System.out.println("Ingrese su texto a cifrar si aún no lo ha hecho en el archivo ubicado en:\n" + rutaTextoEntradaAbsoluta); //lakjfwñlekjfñlkwe Agregar ruta absoluta para el usuario
            System.out.println("\n\n\nIngrese la clave para cifrar el texto:");
            int clave = sc.nextInt();
            System.out.println("\n¡Texto cifrado con éxito! Archivo de texto guardado en:\n" + rutaTextoSalidaAbsoluta);
            if (Validador.comprobarExistencia(rutaTextoSalida)){Files.delete(Path.of(rutaTextoSalida));}
            String textoEncriptado = Cifrado.encriptar(AdministradorDeArchivos.leerArchivo(rutaTextoEntrada), clave);
            AdministradorDeArchivos.escribirArchivo(textoEncriptado, rutaTextoSalida); //Escribe el texto encriptado en txtSalida
        } else {
            System.out.println("***Eligió Descifrar Texto***");
            System.out.println("Ingrese su texto a descifrar si aún no lo ha hecho en el archivo ubicado en:\n" + rutaTextoEntradaAbsoluta); //lakjfwñlekjfñlkwe Agregar ruta absoluta para el usuario
            System.out.println("\n\n\nIngrese la clave para descifrar el texto:");
            int clave = sc.nextInt();
            System.out.println("\n¡Texto descifrado con éxito! . Archivo de texto guardado en:\n" + rutaTextoSalidaAbsoluta);
            if (Validador.comprobarExistencia(rutaTextoSalida)){Files.delete(Path.of(rutaTextoSalida));}
            String textoEncriptado = Cifrado.desencriptar(AdministradorDeArchivos.leerArchivo(rutaTextoEntrada), clave);
            AdministradorDeArchivos.escribirArchivo(textoEncriptado, rutaTextoSalida); //Escribe el texto encriptado en txtSalida
        }
    }
}