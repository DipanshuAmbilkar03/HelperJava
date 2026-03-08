package LastRun7.arrays;

import java.util.*;

public class SmallestBalancedIndex {

    public static int smallestBalancedIndex(int[] nums) {

        int len = nums.length;
        long totalProduct = 1;

        long[] rightProduct = new long[len];

        long bound = (long) 1e14;

        // Compute product of elements to the right
        for (int i = len - 1; i >= 0; i--) {

            rightProduct[i] = totalProduct;

            totalProduct *= nums[i];

            if (totalProduct > bound) {
                totalProduct = bound;
            }
        }

        long leftSum = 0;

        for (int i = 0; i < len; i++) {

            if (leftSum == rightProduct[i]) {
                return i;
            }

            leftSum += nums[i];
        }

        return -1;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] nums = new int[n];

        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }

        int result = smallestBalancedIndex(nums);

        System.out.println("Smallest Balanced Index: " + result);

        sc.close();
    }
}