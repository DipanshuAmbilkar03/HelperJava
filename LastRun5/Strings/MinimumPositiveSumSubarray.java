import java.util.Arrays;
import java.util.List;

public class MinimumPositiveSumSubarray {

    public static int minimumSumSubarray(List<Integer> nums, int l, int r) {
        int ans = Integer.MAX_VALUE;
        int n = nums.size();
        for (int i = 0; i < n; i++) {
            int sum = 0;
            int len = 0;
            for (int j = i; j < n; j++) {
                sum += nums.get(j);
                len++;
                if (len >= l && len <= r && sum > 0) {
                    ans = Math.min(ans, sum);
                }
            }
        }

        return ans == Integer.MAX_VALUE ? -1 : ans;
    }

    public static void main(String[] args) {
        List<Integer> nums1 = Arrays.asList(1, 2, 3, 4);
        System.out.println("nums = [1, 2, 3, 4], l = 2, r = 3 -> " + minimumSumSubarray(nums1, 2, 3));

        List<Integer> nums2 = Arrays.asList(-12, 8);
        System.out.println("nums = [-12, 8], l = 1, r = 1 -> " + minimumSumSubarray(nums2, 1, 1));

        List<Integer> nums3 = Arrays.asList(1, 2, 3, 4);
        System.out.println("nums = [1, 2, 3, 4], l = 1, r = 4 -> " + minimumSumSubarray(nums3, 1, 4));

        List<Integer> nums4 = Arrays.asList(-5, -4, -3);
        System.out.println("nums = [-5, -4, -3], l = 1, r = 3 -> " + minimumSumSubarray(nums4, 1, 3));

        List<Integer> nums5 = Arrays.asList(0, 0, 0);
        System.out.println("nums = [0, 0, 0], l = 1, r = 2 -> " + minimumSumSubarray(nums5, 1, 2));

        List<Integer> nums6 = Arrays.asList(5, -1, 2, -3, 4);
        System.out.println("nums = [5, -1, 2, -3, 4], l = 1, r = 2 -> " + minimumSumSubarray(nums6, 1, 2));

        List<Integer> nums7 = Arrays.asList(7);
        System.out.println("nums = [7], l = 1, r = 1 -> " + minimumSumSubarray(nums7, 1, 1));
    }
}
