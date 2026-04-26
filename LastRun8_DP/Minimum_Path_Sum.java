import java.util.*;

public class Minimum_Path_Sum {

    private int solve(int[][] grid, int i, int j, int m, int n, int[][] dp) {
        if (i >= m || j >= n) {
            return Integer.MAX_VALUE;
        }
        if (i == m - 1 && j == n - 1) {
            return grid[i][j];
        }

        if (dp[i][j] != -1) return dp[i][j];

        int right = solve(grid, i, j + 1, m, n, dp);
        int down = solve(grid, i + 1, j, m, n, dp);

        return dp[i][j] = grid[i][j] + Math.min(right, down);
    }

    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        int[][] dp = new int[m][n];

        // Bottom-up DP
        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                if (i == m - 1 && j == n - 1) {
                    dp[i][j] = grid[i][j];
                } else {
                    int right = (j < n - 1) ? dp[i][j + 1] : Integer.MAX_VALUE;
                    int down = (i < m - 1) ? dp[i + 1][j] : Integer.MAX_VALUE;

                    dp[i][j] = grid[i][j] + Math.min(right, down);
                }
            }
        }

        return dp[0][0];
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Input: rows and columns
        int m = sc.nextInt();
        int n = sc.nextInt();

        int[][] grid = new int[m][n];

        // Input grid
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                grid[i][j] = sc.nextInt();
            }
        }

        Minimum_Path_Sum obj = new Minimum_Path_Sum();
        int result = obj.minPathSum(grid);

        System.out.println(result);

        sc.close();
    }
}