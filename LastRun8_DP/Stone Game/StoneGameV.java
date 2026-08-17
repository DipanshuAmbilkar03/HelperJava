import java.util.Arrays;

public class StoneGameV {

    int[] prefixSum;

    private int solve(int l, int r) {
        int score = 0;

        for (int mid = l; mid <= r - 1; mid++) {

            int leftSum = prefixSum[mid + 1] - prefixSum[l];
            int rightSum = prefixSum[r + 1] - prefixSum[mid + 1];

            if (leftSum < rightSum) {
                score = Math.max(score, leftSum + solve(l, mid));
            } else if (leftSum > rightSum) {
                score = Math.max(score, rightSum + solve(mid + 1, r));
            } else {
                score = Math.max(
                        score,
                        Math.max(
                                solve(l, mid) + leftSum,
                                rightSum + solve(mid + 1, r)
                        )
                );
            }
        }

        return score;
    }

    private int optimal(int l, int r, int[][] dp) {

        if (l >= r) {
            return 0;
        }

        if (dp[l][r] != -1) {
            return dp[l][r];
        }

        int score = 0;

        for (int mid = l; mid <= r - 1; mid++) {

            int leftSum = prefixSum[mid + 1] - prefixSum[l];
            int rightSum = prefixSum[r + 1] - prefixSum[mid + 1];

            if (leftSum < rightSum) {
                score = Math.max(
                        score,
                        leftSum + optimal(l, mid, dp)
                );
            } else if (leftSum > rightSum) {
                score = Math.max(
                        score,
                        rightSum + optimal(mid + 1, r, dp)
                );
            } else {
                score = Math.max(
                        score,
                        Math.max(
                                leftSum + optimal(l, mid, dp),
                                rightSum + optimal(mid + 1, r, dp)
                        )
                );
            }
        }

        return dp[l][r] = score;
    }

    public int stoneGameV(int[] stoneValue) {

        int n = stoneValue.length;

        prefixSum = new int[n + 1];

        for (int i = 0; i < n; i++) {
            prefixSum[i + 1] = prefixSum[i] + stoneValue[i];
        }

        int[][] dp = new int[n][n];

        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }

        return optimal(0, n - 1, dp);
    }

    public static void main(String[] args) {

        StoneGameV sol = new StoneGameV();

        int[][] testCases = {
                {6, 2, 3, 4, 5, 5},
                {7, 7, 7, 7, 7, 7, 7},
                {1, 2, 3, 4, 5},
                {1, 1, 1, 1},
                {10, 20, 30, 40}
        };

        for (int[] stoneValue : testCases) {
            System.out.println(sol.stoneGameV(stoneValue));
        }
    }
}