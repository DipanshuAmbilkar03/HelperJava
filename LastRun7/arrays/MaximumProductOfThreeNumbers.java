import java.util.Arrays;

public class MaximumProductOfThreeNumbers {

    public static int maximumProduct(int[] nums) {

        int n = nums.length;

        // return bruteForce(nums, n);
        // return sorting(nums, n);
        return findThreeMaxNumbers(nums, n);
    }

    private static int bruteForce(int[] nums, int n) {

        int max = Integer.MIN_VALUE;

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                for (int k = j + 1; k < n; k++) {
                    max = Math.max(max, nums[i] * nums[j] * nums[k]);
                }
            }
        }

        return max;
    }

    private static int sorting(int[] nums, int n) {

        Arrays.sort(nums);

        return Math.max(
                nums[n - 1] * nums[n - 2] * nums[n - 3],
                nums[0] * nums[1] * nums[n - 1]
        );
    }

    private static int findThreeMaxNumbers(int[] nums, int n) {

        int max1 = Integer.MIN_VALUE;
        int max2 = Integer.MIN_VALUE;
        int max3 = Integer.MIN_VALUE;

        int min1 = Integer.MAX_VALUE;
        int min2 = Integer.MAX_VALUE;

        for (int num : nums) {

            if (num >= max1) {
                max3 = max2;
                max2 = max1;
                max1 = num;
            } else if (num >= max2) {
                max3 = max2;
                max2 = num;
            } else if (num >= max3) {
                max3 = num;
            }

            if (num <= min1) {
                min2 = min1;
                min1 = num;
            } else if (num <= min2) {
                min2 = num;
            }
        }

        return Math.max(max1 * max2 * max3, min1 * min2 * max1);
    }

    public static void main(String[] args) {

        int[] nums1 = {1, 2, 3};
        int[] nums2 = {1, 2, 3, 4};
        int[] nums3 = {-1, -2, -3};
        int[] nums4 = {-100, -98, -1, 2, 3, 4};
        int[] nums5 = {-10, -10, 5, 2};

        System.out.println(maximumProduct(nums1));
        System.out.println(maximumProduct(nums2));
        System.out.println(maximumProduct(nums3));
        System.out.println(maximumProduct(nums4));
        System.out.println(maximumProduct(nums5));
    }
}