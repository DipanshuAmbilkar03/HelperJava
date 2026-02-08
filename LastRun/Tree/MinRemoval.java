import java.util.*;

public class MinRemoval {

    public static int minRemoval(int[] nums, int k) {
        Arrays.sort(nums);

        int i = 0;
        int maxLen = 0;

        for (int j = 0; j < nums.length; j++) {

            while ((long) nums[j] > (long) nums[i] * k) {
                i++;
            }

            maxLen = Math.max(maxLen, j - i + 1);
        }

        return nums.length - maxLen;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] nums = new int[n];

        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }

        int k = sc.nextInt();

        int result = minRemoval(nums, k);
        System.out.println(result);

        sc.close();
    }
}
