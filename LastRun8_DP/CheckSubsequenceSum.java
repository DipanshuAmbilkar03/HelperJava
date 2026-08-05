public class CheckSubsequenceSum {

    public static boolean checkSubsequenceSum(int[] arr, int k) {

        int n = arr.length;

        // return solve(arr, k, n - 1);

        // int[][] dp = new int[k + 1][n];
        // return solve(arr, k, n - 1, dp);

        int[] prev = new int[k + 1];
        prev[0] = 1;

        for (int t = 1; t <= k; t++) {
            if (t == arr[0]) {
                prev[t] = 1;
            } else {
                prev[t] = 2;
            }
        }

        for (int i = 1; i < n; i++) {

            int[] cur = new int[k + 1];
            cur[0] = 1;

            for (int j = 1; j <= k; j++) {

                int pick = 2;

                if (arr[i] <= j) {
                    pick = prev[j - arr[i]];

                    if (pick == 1) {
                        cur[j] = 1;
                        continue;
                    }
                }

                int notPick = prev[j];
                cur[j] = notPick;
            }

            prev = cur;
        }

        return prev[k] == 1;
    }

    private static boolean solve(int[] arr, int k, int idx, int[][] dp) {

        if (k == 0) {
            dp[k][idx] = 1;
            return true;
        }

        if (idx == 0) {
            if (k == arr[0]) {
                dp[k][0] = 1;
                return true;
            }

            dp[k][0] = 2;
            return false;
        }

        if (dp[k][idx] != 0) {
            return dp[k][idx] == 1;
        }

        boolean pick = false;

        if (arr[idx] <= k) {
            pick = solve(arr, k - arr[idx], idx - 1, dp);

            if (pick) {
                dp[k][idx] = 1;
                return true;
            }
        }

        boolean notPick = solve(arr, k, idx - 1, dp);

        dp[k][idx] = notPick ? 1 : 2;

        return notPick;
    }

    public static void main(String[] args) {

        int[] arr1 = {3, 34, 4, 12, 5, 2};
        int k1 = 9;

        int[] arr2 = {1, 2, 3, 7};
        int k2 = 6;

        int[] arr3 = {2, 4, 6};
        int k3 = 5;

        int[] arr4 = {5, 1, 2, 7, 6, 1, 5};
        int k4 = 8;

        System.out.println(checkSubsequenceSum(arr1, k1));
        System.out.println(checkSubsequenceSum(arr2, k2));
        System.out.println(checkSubsequenceSum(arr3, k3));
        System.out.println(checkSubsequenceSum(arr4, k4));
    }
}