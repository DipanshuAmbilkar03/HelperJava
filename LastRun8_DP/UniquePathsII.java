package DP;
import java.util.*;

public class UniquePathsII {

    private static int solve(int[][] grid, int i, int j, int m, int n, int[][] dp) {
        // Out of bounds
        if (i >= m || j >= n) return 0;

        // Obstacle cell
        if (grid[i][j] == 1) return 0;

        // Destination reached
        if (i == m - 1 && j == n - 1) return 1;

        // Memoization
        if (dp[i][j] != -1) return dp[i][j];

        int right = solve(grid, i, j + 1, m, n, dp);
        int down = solve(grid, i + 1, j, m, n, dp);

        return dp[i][j] = right + down;
    }

    public static int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;

        int[][] dp = new int[m][n];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }

        return solve(obstacleGrid, 0, 0, m, n, dp);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Input: rows and columns
        int m = sc.nextInt();
        int n = sc.nextInt();

        int[][] grid = new int[m][n];

        // Input grid (0 = free, 1 = obstacle)
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                grid[i][j] = sc.nextInt();
            }
        }

        int result = uniquePathsWithObstacles(grid);
        System.out.println("Unique Paths: " + result);

        sc.close();
    }
}