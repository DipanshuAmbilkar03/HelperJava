package BinarySearch;
import java.util.*;

public class MinPairSum {

    public static int minPairSum(int[] nums) {
        Arrays.sort(nums);

        int l = 0, r = nums.length - 1;
        int max1 = Integer.MIN_VALUE;

        while (l < r) {
            max1 = Math.max(max1, nums[l] + nums[r]);
            l++;
            r--;
        }

        return max1;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] nums = new int[n];

        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }

        System.out.println(minPairSum(nums));
        sc.close();
    }
}
