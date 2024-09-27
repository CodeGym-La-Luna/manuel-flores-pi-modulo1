package src;

public class Cifrado {

    private static final String alfabeto = "ABCDEFGHIJKLMNÑOPQRSTUVWXYZabcdefghijklmnñopqrstuvwxyz0123456789ÁÉÍÓÚÜáéíóúü,;.:-_/(){}[]";

    public static String encriptar(String text, int clave) { // Encryption logic
        StringBuilder textoCifrado = new StringBuilder();
        char [] toCipher = text.toCharArray();
        int longitudAlfabeto = alfabeto.length();
        for (char c : toCipher){
            int indice = alfabeto.indexOf(c);
            if (alfabeto.contains(String.valueOf(c))){
                int nuevaPosicion = (indice + clave) % longitudAlfabeto;
                textoCifrado.append(alfabeto.charAt(nuevaPosicion));
            }else{
                textoCifrado.append(c);
            }
        }
        return textoCifrado.toString();
    }
    public String desencriptar(String encryptedText, int shift) { // Decryption logic
        return encriptar(encryptedText, alfabeto.length() - shift);
    }
}