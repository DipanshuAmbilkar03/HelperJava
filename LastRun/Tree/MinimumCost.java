package LastRun.Tree;
import java.util.*;

public class MinimumCost {

    public static int minimumCost(int[] nums) {

        int f = nums[0];
        int a = Integer.MAX_VALUE;
        int b = Integer.MAX_VALUE;

        for (int i = 1; i < nums.length; i++) {

            if (nums[i] < a) {
                b = a;
                a = nums[i];
            } else if (nums[i] < b) {
                b = nums[i];
            }
        }

        return f + a + b;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] nums = new int[n];

        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }

        int result = minimumCost(nums);
        System.out.println(result);

        sc.close();
    }
}

