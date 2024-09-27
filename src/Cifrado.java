package src;

public class Cifrado {

    private static final String alfabeto = "ABCDEFGHIJKLMNÑOPQRSTUVWXYZabcdefghijklmnñopqrstuvwxyz0123456789ÁÉÍÓÚÜáéíóúü,;.:-_/(){}[]";

    public static String encriptar(String text, int clave) { // Encryption logic
        StringBuilder textoCifrado = new StringBuilder();
        char [] toCipher = text.toCharArray();
        for (char c : toCipher){
            int indice = alfabeto.indexOf(c);
            if (alfabeto.contains(String.valueOf(c))){
                int nuevaPosicion = (indice + clave) % alfabeto.length();
                textoCifrado.append(alfabeto.charAt(nuevaPosicion));
            }else{
                textoCifrado.append(c);
            }
        }
        return textoCifrado.toString();
    }
    public static String desencriptar(String texto, int clave) { // Decryption logic
        clave = clave % alfabeto.length();
        return encriptar(texto, alfabeto.length() - clave);
    }
}