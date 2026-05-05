package LastRun_greedy;

import java.util.*;

public class MaximumMatrixSum {

    public static long maxMatrixSum(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;

        int negativeCount = 0;
        int minAbs = Integer.MAX_VALUE;
        long sum = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int val = matrix[i][j];

                if (val < 0) negativeCount++;

                int absVal = Math.abs(val);
                minAbs = Math.min(minAbs, absVal);
                sum += absVal;
            }
        }

        // If odd negatives, subtract twice the smallest absolute value
        if (negativeCount % 2 != 0) {
            sum -= 2L * minAbs;
        }

        return sum;
    }

    // Main method for testing
    public static void main(String[] args) {
        int[][] matrix = {
            {1, -1},
            {-1, 1}
        };

        System.out.println(maxMatrixSum(matrix)); // Output: 4
    }
}