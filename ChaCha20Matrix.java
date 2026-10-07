public class ChaCha20Matrix {
    private int[][] m = new int[4][4];
    public ChaCha20Matrix(int[] key, int co, int[] nonce){
        // costants
        m[0][0] = 0x61707865;
        m[0][1] = 0x3320646e;
        m[0][2] = 0x79622d32;
        m[0][3] = 0x6b206574;

        //the key
        for (int i = 0; i < 4; i++) m[1][i] = key[i];
        for (int i = 0; i < 4; i++) m[2][i] = key[i + 4];

        //counter and nonce
        m[3][0] = co;
        m[3][1] = nonce[0];
        m[3][2] = nonce[1];
        m[3][3] = nonce[2];
    }

    public int[][] getM() {
    return this.m;
}
    
    public void QRoperations(int[][] x, int rA, int cA, int rB, int cB, int rC, int cC, int rD, int cD){
    x[rA][cA] = BitwiseUtiles.add(x[rA][cA], x[rB][cB]);
    x[rD][cD] = BitwiseUtiles.xor(x[rD][cD], x[rA][cA]);
    x[rD][cD] = BitwiseUtiles.leftRotation(x[rD][cD], 16);

    x[rC][cC] = BitwiseUtiles.add(x[rC][cC], x[rD][cD]);
    x[rB][cB] = BitwiseUtiles.xor(x[rB][cB], x[rC][cC]);
    x[rB][cB] = BitwiseUtiles.leftRotation(x[rB][cB], 12);

    x[rA][cA] = BitwiseUtiles.add(x[rA][cA], x[rB][cB]);
    x[rD][cD] = BitwiseUtiles.xor(x[rD][cD], x[rA][cA]);
    x[rD][cD] = BitwiseUtiles.leftRotation(x[rD][cD], 8);

    x[rC][cC] = BitwiseUtiles.add(x[rC][cC], x[rD][cD]);
    x[rB][cB] = BitwiseUtiles.xor(x[rB][cB], x[rC][cC]);
    x[rB][cB] = BitwiseUtiles.leftRotation(x[rB][cB], 7);
}

    public int[][] QR(int[][] original){
    boolean isColumn = true;

    //creating a dupliacte matrice
    int[][] newM = new int[4][4];
    for(int r = 0; r < 4; r++){
        for(int c = 0; c < 4; c++){
            newM[r][c] = original[r][c];
        }
    }

    for(int i = 0; i < 20 ; i++){
        if(isColumn){
            QRoperations(newM, 0,0,  1,0,  2,0,  3,0);
            QRoperations(newM, 0,1,  1,1,  2,1,  3,1);
            QRoperations(newM, 0,2,  1,2,  2,2,  3,2);
            QRoperations(newM, 0,3,  1,3,  2,3,  3,3);
        }else{
            QRoperations(newM, 0,0,  1,1,  2,2,  3,3);
            QRoperations(newM, 0,1,  1,2,  2,3,  3,0);
            QRoperations(newM, 0,2,  1,3,  2,0,  3,1);
            QRoperations(newM, 0,3,  1,0,  2,1,  3,2);
        }
        isColumn = !isColumn;
    }

    //adding m + newM
    for(int r = 0; r < 4; r++){
        for(int c = 0; c < 4; c++){
            newM[r][c] = BitwiseUtiles.add(newM[r][c], original[r][c]);
        }
    }

    return newM;
}
    public void incrementCounter(){
        this.m[3][0] = BitwiseUtiles.add(this.m[3][0], 1);
    }
}
