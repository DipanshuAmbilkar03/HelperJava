import java.util.Arrays;
import java.util.Scanner;

public class LeftRightDifference {

    static class Solution {
        public int[] leftRightDifference(int[] nums) {
            int left = 0;
            int right = 0;

            for (int i : nums) {
                right += i;
            }

            for (int i = 0; i < nums.length; i++) {
                int val = nums[i];

                right -= nums[i];
                nums[i] = Math.abs(left - right);
                left += val;
            }

            return nums;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] nums = new int[n];

        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }

        Solution solution = new Solution();
        int[] result = solution.leftRightDifference(nums);

        System.out.println(Arrays.toString(result));

        sc.close();
    }
}