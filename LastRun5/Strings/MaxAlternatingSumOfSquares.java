import java.util.Arrays;

public class MaxAlternatingSumOfSquares {
    public static long maxAlternatingSum(int[] nums) {
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            nums[i] *= nums[i];
        }

        Arrays.sort(nums);

        long ans = 0;
        for (int i = 0; i < n / 2; i++) {
            ans -= nums[i];
        }
        for (int i = n / 2; i < n; i++) {
            ans += nums[i];
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(maxAlternatingSum(new int[]{1, 2, 3, 4})); // 20
        System.out.println(maxAlternatingSum(new int[]{1, -1, 2, -2, 3})); // 15
        System.out.println(maxAlternatingSum(new int[]{5})); // 25
        System.out.println(maxAlternatingSum(new int[]{2, 2})); // 0
        System.out.println(maxAlternatingSum(new int[]{-3, 4, -1})); // 24
    }
}
