import java.util.Arrays;

public class PredictTheWinner {

    private static int dfs(int[] nums, int left, int right, int[][] dp) {

        if (left == right) {
            return nums[left];
        }

        if (dp[left][right] != Integer.MIN_VALUE) {
            return dp[left][right];
        }

        int pickLeft = nums[left] - dfs(nums, left + 1, right, dp);
        int pickRight = nums[right] - dfs(nums, left, right - 1, dp);

        dp[left][right] = Math.max(pickLeft, pickRight);

        return dp[left][right];
    }

    public static boolean predictTheWinner(int[] nums) {

        int n = nums.length;

        int[][] dp = new int[n][n];

        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i], Integer.MIN_VALUE);
        }

        return dfs(nums, 0, n - 1, dp) >= 0;
    }

    public static void main(String[] args) {

        int[] nums1 = {1, 5, 2};
        int[] nums2 = {1, 5, 233, 7};
        int[] nums3 = {2, 4, 55, 6, 8};
        int[] nums4 = {1, 1, 1};

        System.out.println(predictTheWinner(nums1));
        System.out.println(predictTheWinner(nums2));
        System.out.println(predictTheWinner(nums3));
        System.out.println(predictTheWinner(nums4));
    }
}