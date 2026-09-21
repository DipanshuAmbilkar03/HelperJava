import java.util.Arrays;

public class ResultArray {

    private static int[][] memo;

    private static int bruteForce(int i, int j, int[] nums, int k) {

        int product = 1;

        for (int idx = i; idx <= j; idx++) {
            product = (product * nums[idx]) % k;
        }

        return product;
    }

    private static int improvedBruteForce(int i, int j, int[] nums, int k) {

        if (memo[i][j] != -1) {
            return memo[i][j];
        }

        if (i == j) {
            return nums[j] % k;
        }

        int previous = improvedBruteForce(i, j - 1, nums, k);

        return memo[i][j] = (previous * nums[j]) % k;
    }

    public static long[] resultArray(int[] nums, int k) {

        int n = nums.length;

        // Method 1: Brute Force
        /*
        long[] ans = new long[k];

        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {

                int x = bruteForce(i, j, nums, k);
                ans[x]++;
            }
        }

        return ans;
        */

        // Method 2: Memoization
        /*
        long[] ans = new long[k];

        memo = new int[n][n];

        for (int[] row : memo) {
            Arrays.fill(row, -1);
        }

        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {

                int x = improvedBruteForce(i, j, nums, k);
                ans[x]++;
            }
        }

        return ans;
        */

        // Method 3: DP - O(n * k)
        long[] result = new long[k];
        long[] dp = new long[k];

        for (int i = 0; i < n; i++) {

            long[] nextDp = new long[k];

            int current = nums[i] % k;

            // Subarray containing only nums[i]
            nextDp[current]++;

            // Extend every subarray ending at i - 1
            for (int r = 0; r < k; r++) {

                if (dp[r] == 0) {
                    continue;
                }

                int newRemainder =
                        (int) (((long) r * nums[i]) % k);

                nextDp[newRemainder] += dp[r];
            }

            dp = nextDp;

            // Add all subarrays ending at i
            for (int r = 0; r < k; r++) {
                result[r] += dp[r];
            }
        }

        return result;
    }

    public static void main(String[] args) {

        int[] nums1 = {1, 2, 3};
        int k1 = 3;

        int[] nums2 = {2, 4, 6};
        int k2 = 3;

        int[] nums3 = {1, 1, 1};
        int k3 = 2;

        int[] nums4 = {5, 2, 6, 3};
        int k4 = 4;

        System.out.println(Arrays.toString(resultArray(nums1, k1)));
        System.out.println(Arrays.toString(resultArray(nums2, k2)));
        System.out.println(Arrays.toString(resultArray(nums3, k3)));
        System.out.println(Arrays.toString(resultArray(nums4, k4)));
    }
}