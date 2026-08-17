import java.util.Arrays;

public class StoneGame {

    public static boolean stoneGame(int[] piles) {

        int n = piles.length;

        // Method 1
        // return recursion(0, n - 1, n, piles) >= 0;

        // Method 2
        // int[][] dp = new int[n][n];
        // for (int i = 0; i < n; i++) {
        //     Arrays.fill(dp[i], Integer.MIN_VALUE);
        // }
        // return dp(0, n - 1, n, piles, dp) >= 0;

        // Method 3
        return ultimateOptimalSolutionThatNoMFCanBeat();
    }

    private static int recursion(int left, int right, int n, int[] piles) {

        if (left == right) {
            return piles[left];
        }

        int leftStone = 0;
        int rightStone = 0;

        for (int i = 0; i < n; i++) {
            leftStone = piles[left] - recursion(left + 1, right, n, piles);
            rightStone = piles[right] - recursion(left, right - 1, n, piles);
        }

        return Math.max(leftStone, rightStone);
    }

    private static int dp(int left, int right, int n, int[] piles, int[][] dp) {

        if (left == right) {
            return piles[left];
        }

        if (dp[left][right] != Integer.MIN_VALUE) {
            return dp[left][right];
        }

        int leftStone = 0;
        int rightStone = 0;

        for (int i = 0; i < n; i++) {
            leftStone = piles[left] - dp(left + 1, right, n, piles, dp);
            rightStone = piles[right] - dp(left, right - 1, n, piles, dp);
        }

        return dp[left][right] = Math.max(leftStone, rightStone);
    }

    private static boolean ultimateOptimalSolutionThatNoMFCanBeat() {
        return true;
    }

    public static void main(String[] args) {

        int[] piles1 = {5, 3, 4, 5};
        int[] piles2 = {3, 7, 2, 3};
        int[] piles3 = {1, 100, 2, 99};
        int[] piles4 = {8, 15, 3, 7};

        System.out.println(stoneGame(piles1));
        System.out.println(stoneGame(piles2));
        System.out.println(stoneGame(piles3));
        System.out.println(stoneGame(piles4));
    }
}