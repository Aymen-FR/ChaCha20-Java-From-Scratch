public class ChaCha20Engine {
    
    public byte[] process(byte[] txtBytes, String keyTxt, int[] nonce) {
    // turnning into bytes 
    int[] keyList = BitwiseUtiles.keyFromText(keyTxt);
    byte[] result = new byte[txtBytes.length];

        // intializing the matrix
        int counter = 1;
        ChaCha20Matrix k = new ChaCha20Matrix(keyList, counter, nonce);
        
        //creating the keystream
        int[][] matrix = k.QR(k.getM());
        byte[] keyStream = BitwiseUtiles.unpackLittleEndian(matrix);

        //encryption loop
        for (int index = 0; index < txtBytes.length; index++) {
            
            //after every 64 character ...
            if (index > 0 && index % 64 == 0) {
                k.incrementCounter(); 
                matrix = k.QR(k.getM()); //another 20 round ...
                keyStream = BitwiseUtiles.unpackLittleEndian(matrix); //new key stream
            }

            //XOR operation byte to byte
            result[index] = (byte) BitwiseUtiles.xor(txtBytes[index], keyStream[index % 64]);
        }

        return result; 
    }
}