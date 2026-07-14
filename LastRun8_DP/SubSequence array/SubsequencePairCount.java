import java.util.*;

public class SubsequencePairCount {

    private static final int MOD = 1_000_000_007;

    public static int subsequencePairCount(int[] nums) {
        // return bruteForce(nums);
        return dp(nums);
    }

    private static int bruteForce(int[] nums) {

        int n = nums.length;
        int totalStates = (int) Math.pow(3, n);
        int ans = 0;

        for (int state = 0; state < totalStates; state++) {

            int curr = state;
            int gcd1 = 0;
            int gcd2 = 0;
            boolean choose1 = false;
            boolean choose2 = false;

            for (int i = 0; i < n; i++) {

                int choice = curr % 3;
                curr /= 3;

                if (choice == 1) {
                    gcd1 = choose1 ? gcd(gcd1, nums[i]) : nums[i];
                    choose1 = true;
                } else if (choice == 2) {
                    gcd2 = choose2 ? gcd(gcd2, nums[i]) : nums[i];
                    choose2 = true;
                }
            }

            if (choose1 && choose2 && gcd1 == gcd2) {
                ans++;
            }
        }

        return ans;
    }

    private static int dp(int[] nums) {

        int max = 0;

        for (int x : nums) {
            max = Math.max(max, x);
        }

        int[][] dp = new int[max + 1][max + 1];
        dp[0][0] = 1;

        for (int x : nums) {

            int[][] next = new int[max + 1][max + 1];

            for (int i = 0; i <= max; i++) {
                for (int j = 0; j <= max; j++) {

                    if (dp[i][j] == 0) continue;

                    // Ignore current element
                    next[i][j] = (next[i][j] + dp[i][j]) % MOD;

                    // Add to first subsequence
                    int g1 = (i == 0) ? x : gcd(i, x);
                    next[g1][j] = (next[g1][j] + dp[i][j]) % MOD;

                    // Add to second subsequence
                    int g2 = (j == 0) ? x : gcd(j, x);
                    next[i][g2] = (next[i][g2] + dp[i][j]) % MOD;
                }
            }

            dp = next;
        }

        int ans = 0;

        for (int i = 1; i <= max; i++) {
            ans = (ans + dp[i][i]) % MOD;
        }

        return ans;
    }

    private static int gcd(int a, int b) {

        while (b != 0) {
            int temp = a % b;
            a = b;
            b = temp;
        }

        return a;
    }

    public static void main(String[] args) {

        int[] nums1 = {1, 2, 3};
        int[] nums2 = {2, 4, 6};
        int[] nums3 = {3, 3, 3};
        int[] nums4 = {1, 1, 2};

        System.out.println(subsequencePairCount(nums1));
        System.out.println(subsequencePairCount(nums2));
        System.out.println(subsequencePairCount(nums3));
        System.out.println(subsequencePairCount(nums4));
    }
}