import java.util.*;

public class jumpGame9 {

    static class Solution {

        private int rec(int idx, int[] nums, boolean[] vis) {
            int high = nums[idx];

            vis[idx] = true;

            for (int j = idx + 1; j < nums.length; j++) {
                if (!vis[j] && nums[j] < nums[idx]) {
                    int plus = rec(j, nums, vis);
                    high = Math.max(high, plus);
                }
            }

            for (int j = idx - 1; j >= 0; j--) {
                if (!vis[j] && nums[j] > nums[idx]) {
                    int plus = rec(j, nums, vis);
                    high = Math.max(high, plus);
                }
            }

            vis[idx] = false;
            return high;
        }

        private int memoization(int idx, int[] nums, int mask, HashMap<String, Integer> memo) {

            String state = idx + "," + mask;

            if (memo.containsKey(state)) {
                return memo.get(state);
            }

            int high = nums[idx];

            for (int j = idx + 1; j < nums.length; j++) {
                if (((mask & (1 << j)) == 0) && nums[j] < nums[idx]) {

                    int plus = memoization(j, nums, mask | (1 << j), memo);

                    high = Math.max(high, plus);
                }
            }

            for (int j = idx - 1; j >= 0; j--) {
                if (((mask & (1 << j)) == 0) && nums[j] > nums[idx]) {

                    int plus = memoization(j, nums, mask | (1 << j), memo);

                    high = Math.max(high, plus);
                }
            }

            memo.put(state, high);

            return high;
        }

        private int opti(int idx, int[] nums, boolean[] vis, int[][] memo, int direction) {

            if (memo[idx][direction] != -1) {
                return memo[idx][direction];
            }

            int high = nums[idx];

            vis[idx] = true;

            for (int j = idx + 1; j < nums.length; j++) {

                if (!vis[j] && nums[j] < nums[idx]) {

                    int plus = opti(j, nums, vis, memo, 0);

                    high = Math.max(high, plus);
                }
            }

            for (int j = idx - 1; j >= 0; j--) {

                if (!vis[j] && nums[j] > nums[idx]) {

                    int plus = opti(j, nums, vis, memo, 1);

                    high = Math.max(high, plus);
                }
            }

            vis[idx] = false;

            return memo[idx][direction] = high;
        }

        private Integer[] dp;

        public int[] maxValue(int[] nums) {

            int n = nums.length;

            int[] maxprefix = new int[n];
            int[] minsuffix = new int[n];

            maxprefix[0] = nums[0];
            minsuffix[n - 1] = nums[n - 1];

            for (int i = 1; i < n; i++) {
                maxprefix[i] = Math.max(nums[i], maxprefix[i - 1]);
            }

            for (int i = n - 2; i >= 0; i--) {
                minsuffix[i] = Math.min(nums[i], minsuffix[i + 1]);
            }

            int[] ans = new int[n];

            ans[n - 1] = maxprefix[n - 1];

            for (int i = n - 2; i >= 0; i--) {

                if (maxprefix[i] > minsuffix[i + 1]) {
                    ans[i] = ans[i + 1];
                } else {
                    ans[i] = maxprefix[i];
                }
            }

            return ans;
        }
    }

    public static void main(String[] args) {

        Solution sol = new Solution();

        int[] nums = {3, 1, 5, 2, 4};

        int[] ans = sol.maxValue(nums);

        System.out.println("Output:");

        for (int x : ans) {
            System.out.print(x + " ");
        }
    }
}