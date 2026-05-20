import java.util.*;

class JumpGame2 {

    // Recursion
    private int rec(int i, int[] nums) {

        if (i >= nums.length - 1) {
            return 0;
        }

        int ans = Integer.MAX_VALUE;

        for (int j = 1; j <= nums[i]; j++) {

            int step = rec(i + j, nums);

            if (step != Integer.MAX_VALUE) {
                ans = Math.min(ans, step + 1);
            }
        }

        return ans;
    }

    // Memoization
    private int memo(int i, int[] nums, int[] dp) {

        if (i >= nums.length - 1) {
            return 0;
        }

        if (dp[i] != -1) {
            return dp[i];
        }

        int ans = Integer.MAX_VALUE;

        for (int j = 1; j <= nums[i]; j++) {

            int step = memo(i + j, nums, dp);

            if (step != Integer.MAX_VALUE) {

                ans = Math.min(ans, step + 1);

                dp[i] = ans;
            }
        }

        return dp[i] = ans;
    }

    public int jump(int[] nums) {

        int[] dp = new int[nums.length];

        Arrays.fill(dp, -1);

        // Recursion
        // return rec(0, nums);

        // Memoization
        return memo(0, nums, dp);
    }

    public static void main(String[] args) {

        JumpGame2 obj = new JumpGame2();

        int[] nums = {2, 3, 1, 1, 4};

        int result = obj.jump(nums);

        System.out.println("Minimum Jumps Required: " + result);
    }
}