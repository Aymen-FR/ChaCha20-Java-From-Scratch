import java.nio.charset.StandardCharsets;

public class BitwiseUtiles {
    public static int[] keyFromText(String textKey) {
        byte[] keyBytes = textKey.getBytes(StandardCharsets.UTF_8);
        return littleEndian(keyBytes);
    }
    public static int[] littleEndian(byte[] key){
        if(key.length != 32){
            System.out.println("Error , the key text must have 32 character exactly");
            return null;
        }else{
            int[] keyList = new int[8];
            for(int i = 0; i < 8 ; i++){
                int step = i * 4;
                keyList[i] = (key[step] & 0xFF) | ((key[step+1] & 0xFF) << 8) | ((key[step+2] & 0xFF) << 16) | ((key[step+3] & 0xFF) << 24);
            }
            return keyList;
        }
    }
    public static int xor(int a, int b){
        return a ^ b ;
    }
    public static int add(int a, int b){
        return a + b;
    }
    public static int leftRotation(int a, int shift){
        return (a << shift) | (a >>> (32 - shift));
    }

    public static byte[] unpackLittleEndian(int[][] matrix){
        byte[] keyStream = new byte[64];
        int i = 0;
        for(int c = 0 ; c < 4; c++){
            for(int r = 0; r < 4 ; r++){
                int v = matrix[c][r];
                keyStream[i] = (byte) (v & 0xFF);
                i+=1;
                keyStream[i] = (byte) ((v >>> 8) & 0xFF);
                i += 1;
                keyStream[i] = (byte) ((v >>> 16) & 0xFF);
                i += 1;
                keyStream[i] = (byte) ((v >>> 24) & 0xFF);
                i+=1;
            }
        }
        return keyStream;
    }
}
