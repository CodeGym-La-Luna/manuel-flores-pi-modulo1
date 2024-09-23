package src;

public class Cifrado {

    static final String alfabeto = "ABCDEFGHIJKLMNÑOPQRSTUVWXYZ" +
            "abcdefghijklmnñopqrstuvwxyz" +
            "0123456789ÁÉÍÓÚÜáéíóúü,;.:-_/(){}[]";

    public Cifrado(char[] alphabet) {
        this.alfabeto = alphabet;
    }

    //    Scanner sc = new Scanner(System.in);        //Se reemplazará por la lectura de archivo
//    String txt = sc.nextLine();
//    String txtCifrado = encriptar(txt, 3);



    //    private char[] alfabeto{
//        char[] caracter;
//        caracter = new char[255];
//        for (int i = 0; i < 255; i++) {
//            caracter[i] = (char) (i);
//        }
//        return caracter;
//    }

    public static String encriptar(String text, int clave) {
        // Encryption logic

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
    public String desencriptar(String encryptedText, int shift) {
        // Decryption logic
    }
}