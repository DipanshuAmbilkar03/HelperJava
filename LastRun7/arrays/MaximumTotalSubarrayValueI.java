package LastRun7;
public class MaximumTotalSubarrayValueI {

    static class Solution {
        public long maxTotalValue(int[] nums, int k) {
            long mini = Integer.MAX_VALUE;
            long maxi = Integer.MIN_VALUE;

            for (int i : nums) {
                maxi = Math.max(i, maxi);
                mini = Math.min(i, mini);
            }

            return (maxi - mini) * k;
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        int[] nums = {1, 3, 5, 2, 8};
        int k = 4;

        long result = sol.maxTotalValue(nums, k);

        System.out.println("Maximum Total Value: " + result);
    }
}