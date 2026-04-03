package LastRun8_DP.DP;
import java.util.*;

public class MaximumAmountGrid {

    int m, n;
    Integer[][][] dp;

    public int maximumAmount(int[][] coins) {
        this.m = coins.length;
        this.n = coins[0].length;

        dp = new Integer[m][n][3];

        return helper(coins, 0, 0, 2);
    }

    private int helper(int[][] coins, int i, int j, int skips) {

        if (i >= m || j >= n) return Integer.MIN_VALUE;

        if (dp[i][j][skips] != null) return dp[i][j][skips];

        // Destination
        if (i == m - 1 && j == n - 1) {
            if (coins[i][j] < 0 && skips > 0) return 0;
            else return coins[i][j];
        }

        // Move right
        int right = helper(coins, i, j + 1, skips);

        // Move down
        int down = helper(coins, i + 1, j, skips);

        // Skip case
        int maxSkip = Integer.MIN_VALUE;

        if (coins[i][j] < 0 && skips > 0) {
            int downSkip = helper(coins, i + 1, j, skips - 1);
            int rightSkip = helper(coins, i, j + 1, skips - 1);
            maxSkip = Math.max(downSkip, rightSkip);
        }

        int ans = Math.max(Math.max(down, right) + coins[i][j], maxSkip);

        return dp[i][j][skips] = ans;
    }

    // MAIN FUNCTION
    public static void main(String[] args) {
        MaximumAmountGrid obj = new MaximumAmountGrid();

        int[][] coins = {
                {1, -2, 3},
                {2, -5, 10},
                {4, 2, -1}
        };

        int result = obj.maximumAmount(coins);

        System.out.println("Maximum Amount Collected: " + result);
    }
}