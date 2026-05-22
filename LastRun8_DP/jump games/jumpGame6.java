import java.util.*;

public class JumpGame6 {

    private int maxAns = Integer.MIN_VALUE;

    // Recursive Solution
    private void solve(int[] nums, int curr, int k, int ans) {

        int n = nums.length;

        if(curr >= n - 1) {
            maxAns = Math.max(maxAns, ans);
            return;
        }

        for(int i = 1; i <= k; i++) {

            int next = curr + i;

            if(next < n) {
                solve(nums, next, k, ans + nums[next]);
            }
        }
    }

    // Memoization
    private Integer[] dp;

    private int memoization(int[] nums, int curr, int k) {

        int n = nums.length;

        if(curr == n - 1) {
            return nums[curr];
        }

        if(dp[curr] != null) {
            return dp[curr];
        }

        int maxAns = Integer.MIN_VALUE;

        for(int i = 1; i <= k; i++) {

            int next = curr + i;

            if(next < n) {

                maxAns = Math.max(
                        maxAns,
                        nums[curr] + memoization(nums, next, k)
                );
            }
        }

        return dp[curr] = maxAns;
    }

    // Memoization using primitive array
    private int solve2(int[] nums, int[] dp, int k, int i) {

        if(dp[i] != Integer.MIN_VALUE) {
            return dp[i];
        }

        if(i == nums.length - 1) {
            return nums[i];
        }

        for(int j = 1; j <= k; j++) {

            if(i + j < nums.length) {

                dp[i] = Math.max(
                        dp[i],
                        nums[i] + solve2(nums, dp, k, i + j)
                );
            }
        }

        return dp[i];
    }

    // Optimized TreeMap Solution
    private int opti(int[] nums, int k) {

        int n = nums.length;

        int[] dp = new int[n];

        dp[0] = nums[0];

        TreeMap<Integer, Integer> map = new TreeMap<>();

        map.put(dp[0], 1);

        for(int i = 1; i < n; i++) {

            if(i > k) {

                int remove = dp[i - k - 1];

                map.put(remove, map.get(remove) - 1);

                if(map.get(remove) == 0) {
                    map.remove(remove);
                }
            }

            dp[i] = map.lastKey() + nums[i];

            map.put(dp[i], map.getOrDefault(dp[i], 0) + 1);
        }

        return dp[n - 1];
    }

    public int maxResult(int[] nums, int k) {

        // ---------------- Recursive ----------------
        // solve(nums, 0, k, nums[0]);
        // return maxAns;

        // ---------------- Memoization ----------------
        // dp = new Integer[nums.length];
        // return memoization(nums, 0, k);

        // ---------------- Memoization 2 ----------------
        // int[] dp2 = new int[nums.length];
        // Arrays.fill(dp2, Integer.MIN_VALUE);
        // return solve2(nums, dp2, k, 0);

        // ---------------- Optimized ----------------
        return opti(nums, k);
    }

    // Main Function
    public static void main(String[] args) {

        JumpGameVI obj = new JumpGameVI();

        int[] nums = {1, -1, -2, 4, -7, 3};

        int k = 2;

        int ans = obj.maxResult(nums, k);

        System.out.println("Maximum Score = " + ans);
    }
}