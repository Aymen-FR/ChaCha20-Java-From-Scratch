import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ChaCha20Engine engine = new ChaCha20Engine();

        
        String key = "0123456789abcdef0123456789abcdef"; //the key 32 bits
        int[] nonce = {0x01020304, 0x0a0b0c0d, 0x11223344};

        // entering the text from user
        System.out.print("Enter text to encrypt: ");
        String text = scanner.nextLine();

        //encruption and decryption
        byte[] plainBytes = text.getBytes(StandardCharsets.UTF_8);
        byte[] cipherBytes = engine.process(plainBytes, key, nonce);
        byte[] decryptedBytes = engine.process(cipherBytes, key, nonce);

        //printing the results
        System.out.println("Encrypted (Hex): " + toHex(cipherBytes));
        System.out.println("Decrypted Text : " + new String(decryptedBytes, StandardCharsets.UTF_8));

        scanner.close();
    }

    //turning the byte array into hex string for better visualization
    private static String toHex(byte[] bytes) {
        StringBuilder sb = new StringBuilder();
        for (byte b : bytes) {
            sb.append(String.format("%02x", b));
        }
        return sb.toString();
    }
}