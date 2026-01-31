public class MatrixElementWise {
    public static void main(String[] args) {
        int[][] A = {
            {1, 2, 3},
            {4, 5, 6}
        };

        int[][] B = {
            {7, 8, 9},
            {10, 11, 12}
        };

        int rows = A.length;
        int cols = A[0].length;
        int[][] C = new int[rows][cols];

        // Element-wise addition
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                C[i][j] = A[i][j] + B[i][j];
            }
        }

        // Print summed matrix
        System.out.println("Summed Matrix:");
        for (int[] row : C) {
            for (int value : row) {
                System.out.print(value + " ");
            }
            System.out.println();
        }
    }
}