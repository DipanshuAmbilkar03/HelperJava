import java.util.*;

public class JumpGame5 {

    private int[] dp;

    // Recursive Solution
    private int rec(int[] arr, int d, int idx) {

        int ans = 1;

        // Move Right
        for(int i = 1; i <= d; i++) {

            int next = idx + i;

            // Out of bounds
            if(next >= arr.length) {
                break;
            }

            // Cannot jump over greater/equal height
            if(arr[next] >= arr[idx]) {
                break;
            }

            ans = Math.max(ans, 1 + rec(arr, d, next));
        }

        // Move Left
        for(int i = 1; i <= d; i++) {

            int next = idx - i;

            // Out of bounds
            if(next < 0) {
                break;
            }

            // Cannot jump over greater/equal height
            if(arr[next] >= arr[idx]) {
                break;
            }

            ans = Math.max(ans, 1 + rec(arr, d, next));
        }

        return ans;
    }

    // Memoization Solution
    private int directMemo(int[] arr, int d, int idx) {

        // Already computed
        if(dp[idx] != -1) {
            return dp[idx];
        }

        int ans = 1;

        // Move Right
        for(int i = 1; i <= d; i++) {

            int next = idx + i;

            if(next >= arr.length) {
                break;
            }

            if(arr[next] >= arr[idx]) {
                break;
            }

            ans = Math.max(ans,
                    1 + directMemo(arr, d, next));
        }

        // Move Left
        for(int i = 1; i <= d; i++) {

            int next = idx - i;

            if(next < 0) {
                break;
            }

            if(arr[next] >= arr[idx]) {
                break;
            }

            ans = Math.max(ans,
                    1 + directMemo(arr, d, next));
        }

        return dp[idx] = ans;
    }

    public int maxJumps(int[] arr, int d) {

        int n = arr.length;

        dp = new int[n];

        Arrays.fill(dp, -1);

        int ans = 1;

        for(int i = 0; i < n; i++) {

            // Recursive
            // ans = Math.max(ans, rec(arr, d, i));

            // Memoization
            ans = Math.max(ans,
                    directMemo(arr, d, i));
        }

        return ans;
    }

    // Main Function
    public static void main(String[] args) {

        JumpGame5 obj = new JumpGame5();

        int[] arr = {6, 4, 14, 6, 8, 13, 9, 7, 10, 6, 12};

        int d = 2;

        int result = obj.maxJumps(arr, d);

        System.out.println("Maximum Jumps = " + result);
    }
}