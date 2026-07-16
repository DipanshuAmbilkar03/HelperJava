import java.util.Arrays;

public class GCDSum {

    public static long gcdSum(int[] nums) {

        int max = Integer.MIN_VALUE;
        int index = 0;

        int[] prefix = new int[nums.length];

        for (int num : nums) {
            max = Math.max(max, num);
            prefix[index++] = gcd(max, num);
        }

        int n = nums.length;
        long ans = 0;

        Arrays.sort(prefix);

        for (int i = 0; i < n / 2; i++) {

            int left = prefix[i];
            int right = prefix[n - 1 - i];

            ans += gcd(left, right);
        }

        return ans;
    }

    private static int gcd(int a, int b) {

        if (b == 0) {
            return a;
        }

        return gcd(b, a % b);
    }

    public static void main(String[] args) {

        int[] nums1 = {2, 4, 6, 8};
        int[] nums2 = {5, 10, 15, 20, 25, 30};
        int[] nums3 = {7, 7, 7, 7};
        int[] nums4 = {12, 18, 24, 30};

        System.out.println(gcdSum(nums1));
        System.out.println(gcdSum(nums2));
        System.out.println(gcdSum(nums3));
        System.out.println(gcdSum(nums4));
    }
}