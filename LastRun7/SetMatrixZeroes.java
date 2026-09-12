public class SetMatrixZeroes {

    public static void setZeroes(int[][] matrix) {

        int m = matrix.length;
        int n = matrix[0].length;

        int col0 = 1;

        // Mark rows and columns using first row and first column
        for (int i = 0; i < m; i++) {

            for (int j = 0; j < n; j++) {

                if (matrix[i][j] == 0) {

                    matrix[i][0] = 0;

                    if (j == 0) {
                        col0 = 0;
                    } else {
                        matrix[0][j] = 0;
                    }
                }
            }
        }

        // Set inner matrix to zero
        for (int i = 1; i < m; i++) {

            for (int j = 1; j < n; j++) {

                if (matrix[i][0] == 0 || matrix[0][j] == 0) {
                    matrix[i][j] = 0;
                }
            }
        }

        // Handle first row
        if (matrix[0][0] == 0) {

            for (int j = 0; j < n; j++) {
                matrix[0][j] = 0;
            }
        }

        // Handle first column
        if (col0 == 0) {

            for (int i = 0; i < m; i++) {
                matrix[i][0] = 0;
            }
        }
    }

    private static void printMatrix(int[][] matrix) {

        for (int[] row : matrix) {
            for (int value : row) {
                System.out.print(value + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {

        int[][] matrix1 = {
                {1, 1, 1},
                {1, 0, 1},
                {1, 1, 1}
        };

        int[][] matrix2 = {
                {0, 1, 2, 0},
                {3, 4, 5, 2},
                {1, 3, 1, 5}
        };

        int[][] matrix3 = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };

        int[][] matrix4 = {
                {1, 0, 3},
                {4, 5, 6},
                {7, 8, 9}
        };

        int[][] matrix5 = {
                {1, 2, 3},
                {0, 5, 6},
                {7, 8, 9}
        };

        int[][][] testCases = {
                matrix1,
                matrix2,
                matrix3,
                matrix4,
                matrix5
        };

        for (int[][] matrix : testCases) {

            System.out.println("Before:");
            printMatrix(matrix);

            setZeroes(matrix);

            System.out.println("After:");
            printMatrix(matrix);

            System.out.println();
        }
    }
}