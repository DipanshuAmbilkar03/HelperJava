package LastRun8_DP;

import java.util.*;

public class Triangle {

    private int solve(List<List<Integer>> t, int i, int j, int[][] dp) {
        if (i == t.size() - 1) {
            return t.get(i).get(j);
        }

        if (dp[i][j] != -1) return dp[i][j];

        int bottom = solve(t, i + 1, j, dp);
        int side = solve(t, i + 1, j + 1, dp);

        return dp[i][j] = t.get(i).get(j) + Math.min(bottom, side);
    }

    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        int[][] dp = new int[n][n];

        // Copy triangle into dp
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= i; j++) {
                dp[i][j] = triangle.get(i).get(j);
            }
        }

        // Bottom-up DP
        for (int i = n - 2; i >= 0; i--) {
            for (int j = 0; j <= i; j++) {
                dp[i][j] += Math.min(dp[i + 1][j], dp[i + 1][j + 1]);
            }
        }

        return dp[0][0];
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Input: number of rows
        int n = sc.nextInt();

        List<List<Integer>> triangle = new ArrayList<>();

        // Input triangle
        for (int i = 0; i < n; i++) {
            List<Integer> row = new ArrayList<>();
            for (int j = 0; j <= i; j++) {
                row.add(sc.nextInt());
            }
            triangle.add(row);
        }

        Triangle obj = new Triangle();
        int result = obj.minimumTotal(triangle);

        System.out.println(result);

        sc.close();
    }
}