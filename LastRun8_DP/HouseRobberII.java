package LastRun8_DP;

import java.util.*;

public class HouseRobberII {

    private static int helper(int[] nums, int idx, int prev) {
        int i = 0, j = 0;

        for (int house = idx; house <= prev; house++) {
            int currHouse = Math.max(j, i + nums[house]);
            i = j;
            j = currHouse;
        }

        return j;
    }

    public static int rob(int[] nums) {
        int n = nums.length;

        // Edge case
        if (n == 1) return nums[0];

        // Case 1: Exclude last house
        int case1 = helper(nums, 0, n - 2);

        // Case 2: Exclude first house
        int case2 = helper(nums, 1, n - 1);

        return Math.max(case1, case2);
    }

    public static void main(String[] args) {
        // Test cases
        int[] nums1 = {2, 3, 2};
        int[] nums2 = {1, 2, 3, 1};
        int[] nums3 = {1, 2, 3};

        System.out.println("Output 1: " + rob(nums1)); // Expected: 3
        System.out.println("Output 2: " + rob(nums2)); // Expected: 4
        System.out.println("Output 3: " + rob(nums3)); // Expected: 3
    }
}