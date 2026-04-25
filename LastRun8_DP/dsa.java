package LastRun8_DP;

import java.util.*;

public class PartitionEqualSubsetSum {

    public static boolean canPartition(int[] nums) {
        int totalSum = 0;

        // Calculate total sum
        for (int num : nums) {
            totalSum += num;
        }

        // If sum is odd, cannot partition
        if (totalSum % 2 != 0) return false;

        int target = totalSum / 2;

        // 1D DP array
        boolean[] dp = new boolean[target + 1];
        dp[0] = true;

        // Fill DP
        for (int num : nums) {
            for (int i = target; i >= num; i--) {
                dp[i] = dp[i] || dp[i - num];
            }
        }

        return dp[target];
    }

    public static void main(String[] args) {
        int[] nums1 = {1, 5, 11, 5};
        int[] nums2 = {1, 2, 3, 5};
        int[] nums3 = {2, 2, 3, 5};

        System.out.println("Test 1: " + canPartition(nums1)); // true
        System.out.println("Test 2: " + canPartition(nums2)); // false
        System.out.println("Test 3: " + canPartition(nums3)); // false
    }
}