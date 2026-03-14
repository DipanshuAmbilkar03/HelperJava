package LastRun6.Graph;

import java.util.*;

public class MinCost {

    static class Solution {
        private String s;
        private int encCost;
        private int flatCost;

        public long minCost(String s, int encCost, int flatCost) {
            this.s = s;
            this.encCost = encCost;
            this.flatCost = flatCost;
            int n = s.length();

            return helper(0, n - 1);
        }

        private long helper(int l, int r) {

            int L = r - l + 1;
            int X = 0;

            // Count number of '1's in substring
            for (int i = l; i <= r; i++) {
                if (s.charAt(i) == '1') X++;
            }

            long cost;

            // Cost of encoding the whole substring
            if (X == 0) {
                cost = flatCost;
            } else {
                cost = (long) L * X * encCost;
            }

            // Try partition if length is even
            if (L % 2 == 0) {
                int mid = l + (r - l) / 2;

                long splitCost = helper(l, mid) + helper(mid + 1, r);

                cost = Math.min(cost, splitCost);
            }

            return cost;
        }
    }

    public static void main(String[] args) {

        String s = "1011";
        int encCost = 2;
        int flatCost = 3;

        Solution sol = new Solution();
        long result = sol.minCost(s, encCost, flatCost);

        System.out.println("Minimum Cost: " + result);
    }
}
