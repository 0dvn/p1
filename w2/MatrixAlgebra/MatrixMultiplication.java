public class MatrixMultiplication {
    public static void main(String[] args) {
        int[][] A = {
            {1, 2, 3}, // 2x3
            {4, 5, 6}
        };

        int[][] B = {
            {7, 8},     // 3x2
            {9, 10},
            {11, 12}
        };

        // Result matrix
        int rowsA = A.length;      // 2
        int colsA = A[0].length;   // 3
        int colsB = B[0].length;   // 2
        int[][] C = new int[rowsA][colsB]; // { { 0, 0 }, { 0, 0 } } 2x2

        // Matrix multiplication
        for (int i = 0; i < rowsA; i++) {
            for (int j = 0; j < colsB; j++) {
                for (int k = 0; k < 3; k++) {
                    C[i][j] = A[i][k] * B[k][j];
                }
            }
        }

        // Print result matrix
        System.out.println("Result Matrix:");
        for (int[] row : C) {
            for (int value : row) {
                System.out.print(value + " ");
            }
            System.out.println();
        }
    }
}