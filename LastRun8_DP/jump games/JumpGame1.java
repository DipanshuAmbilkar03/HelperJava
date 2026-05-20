import java.util.*;

class JumpGame1 {

    Boolean[] dp;

    // Recursion
    private boolean recursion(int i, int[] nums) {

        if (i >= nums.length - 1) {
            return true;
        }

        if (nums[i] == 0) {
            return false;
        }

        for (int steps = 1; steps <= nums[i]; steps++) {

            if (recursion(i + steps, nums)) {
                return true;
            }
        }

        return false;
    }

    // Memoization
    private boolean memoization(int i, int[] nums) {

        if (i >= nums.length - 1) {
            return true;
        }

        if (nums[i] == 0) {
            return false;
        }

        if (dp[i] != null) {
            return dp[i];
        }

        for (int steps = 1; steps <= nums[i]; steps++) {

            if (memoization(i + steps, nums)) {
                return dp[i] = true;
            }
        }

        return dp[i] = false;
    }

    // Greedy / Iteration
    private boolean iteration(int[] nums) {

        int jumps = 0;

        for (int i = 0; i < nums.length; i++) {

            if (i > jumps) {
                return false;
            }

            jumps = Math.max(jumps, i + nums[i]);
        }

        return true;
    }

    public boolean canJump(int[] nums) {

        int start = 0;

        dp = new Boolean[nums.length];

        // Recursive
        // return recursion(start, nums);

        // Memoization
        // return memoization(start, nums);

        // Iteration / Greedy
        return iteration(nums);
    }

    public static void main(String[] args) {

        JumpGame1 obj = new JumpGame1();

        int[] nums = {2, 3, 1, 1, 4};

        boolean result = obj.canJump(nums);

        System.out.println("Can Reach Last Index: " + result);
    }
}