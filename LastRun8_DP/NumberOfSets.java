public class NumberOfSets {

    private static final int MOD = 1_000_000_007;
    private static int[][] dp;

    private static int solve(int n, int k, int i) {

        if (k == 0) {
            return 1;
        }

        if (i >= n - 1) {
            return 0;
        }

        if (dp[k][i] != -1) {
            return dp[k][i];
        }

        int take = 0;

        for (int j = i + 1; j < n; j++) {
            take = (take + solve(n, k - 1, j)) % MOD;
        }

        int skip = solve(n, k, i + 1);

        return dp[k][i] = (take + skip) % MOD;
    }

    public static int numberOfSets(int n, int k) {

        dp = new int[k + 1][n + 1];

        // Method 1: Memoization
        // for (int[] row : dp) {
        //     Arrays.fill(row, -1);
        // }
        // return solve(n, k, 0);

        // Method 2: Bottom-up DP
        for (int i = 1; i <= n; i++) {
            dp[0][i] = 1;
        }

        for (int j = 1; j <= k; j++) {

            int[] prev = new int[n + 1];

            for (int x = n - 1; x >= 0; x--) {
                prev[x] = (prev[x + 1] + dp[j - 1][x]) % MOD;
            }

            for (int i = n - 1; i >= 0; i--) {

                int take = prev[i + 1];

                int skip = dp[j][i + 1];

                dp[j][i] = (take + skip) % MOD;
            }
        }

        return dp[k][0];
    }

    public static void main(String[] args) {

        int[][] testCases = {
                {3, 1},
                {4, 1},
                {4, 2},
                {5, 2},
                {10, 3},
                {100, 10}
        };

        for (int[] test : testCases) {

            int n = test[0];
            int k = test[1];

            System.out.println(
                    "n = " + n +
                    ", k = " + k +
                    " -> " + numberOfSets(n, k)
            );
        }
    }
}