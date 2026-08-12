import java.util.HashMap;
import java.util.Map;

public class MaxSubarrayLength {

    public static int maxSubarrayLength(int[] nums, int k) {

        Map<Integer, Integer> map = new HashMap<>();

        int ans = 0;
        int left = 0;

        for (int i = 0; i < nums.length; i++) {

            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);

            while (map.get(nums[i]) > k) {
                map.put(nums[left], map.get(nums[left]) - 1);
                left++;
            }

            ans = Math.max(ans, i - left + 1);
        }

        return ans;
    }

    public static void main(String[] args) {

        int[] nums1 = {1, 2, 3, 1, 2, 3, 2, 2};
        int k1 = 2;

        int[] nums2 = {1, 1, 1, 1};
        int k2 = 2;

        int[] nums3 = {1, 2, 3, 4};
        int k3 = 1;

        int[] nums4 = {5, 5, 5, 5, 5};
        int k4 = 1;

        System.out.println(maxSubarrayLength(nums1, k1));
        System.out.println(maxSubarrayLength(nums2, k2));
        System.out.println(maxSubarrayLength(nums3, k3));
        System.out.println(maxSubarrayLength(nums4, k4));
    }
}