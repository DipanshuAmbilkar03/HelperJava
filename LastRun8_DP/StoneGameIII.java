import java.util.Arrays;

public class StoneGameIII {

    public static String stoneGameIII(int[] stoneValue) {

        int n = stoneValue.length;

        int[] dp = new int[n];

        Arrays.fill(dp, Integer.MIN_VALUE);

        int result = optimal(stoneValue, 0, n, dp);

        if (result > 0) {
            return "Alice";
        } else if (result == 0) {
            return "Tie";
        } else {
            return "Bob";
        }
    }

    private static int solve(int[] stoneValue, int i, int n) {

        if (i == n) {
            return 0;
        }

        int res = Integer.MIN_VALUE;

        res = Math.max(res,
                stoneValue[i] - solve(stoneValue, i + 1, n));

        if (i + 1 < n) {
            res = Math.max(res,
                    stoneValue[i] + stoneValue[i + 1]
                            - solve(stoneValue, i + 2, n));
        }

        if (i + 2 < n) {
            res = Math.max(res,
                    stoneValue[i] + stoneValue[i + 1] + stoneValue[i + 2]
                            - solve(stoneValue, i + 3, n));
        }

        return res;
    }

    private static int optimal(int[] stoneValue, int i, int n, int[] dp) {

        if (i == n) {
            return 0;
        }

        if (dp[i] != Integer.MIN_VALUE) {
            return dp[i];
        }

        int res = Integer.MIN_VALUE;

        res = Math.max(res,
                stoneValue[i] - optimal(stoneValue, i + 1, n, dp));

        if (i + 1 < n) {
            res = Math.max(res,
                    stoneValue[i] + stoneValue[i + 1]
                            - optimal(stoneValue, i + 2, n, dp));
        }

        if (i + 2 < n) {
            res = Math.max(res,
                    stoneValue[i] + stoneValue[i + 1] + stoneValue[i + 2]
                            - optimal(stoneValue, i + 3, n, dp));
        }

        return dp[i] = res;
    }

    public static void main(String[] args) {

        int[] stones1 = {1, 2, 3, 7};
        int[] stones2 = {1, 2, 3, -9};
        int[] stones3 = {1, 2, 3, 6};
        int[] stones4 = {-1, -2, -3};

        System.out.println(stoneGameIII(stones1));
        System.out.println(stoneGameIII(stones2));
        System.out.println(stoneGameIII(stones3));
        System.out.println(stoneGameIII(stones4));
    }
}