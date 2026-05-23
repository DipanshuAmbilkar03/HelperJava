import java.util.*;

public class JumpGame7 {

    static class Solution {

        // Recursive + Memoization
        private boolean rec(String s, int idx, int minJump, int maxJump, int[] dp) {

            // Reached last index
            if (idx == s.length() - 1) {
                return true;
            }

            // Already computed
            if (dp[idx] != -1) {
                return dp[idx] == 1;
            }

            // Try all possible jumps
            for (int jump = minJump; jump <= maxJump; jump++) {

                int next = idx + jump;

                if (next >= s.length()) {
                    break;
                }

                // Only move to '0'
                if (s.charAt(next) == '0') {

                    if (rec(s, next, minJump, maxJump, dp)) {
                        dp[idx] = 1;
                        return true;
                    }
                }
            }

            dp[idx] = 0;
            return false;
        }

        public boolean canReach(String s, int minJump, int maxJump) {

            // Edge case
            if (s.charAt(s.length() - 1) != '0') {
                return false;
            }

            // =========================
            // Recursive + Memoization
            // =========================

            /*
            int[] dp = new int[s.length()];
            Arrays.fill(dp, -1);

            return rec(s, 0, minJump, maxJump, dp);
            */

            // =========================
            // BFS Optimized
            // =========================

            int n = s.length();

            Queue<Integer> q = new LinkedList<>();
            q.offer(0);

            boolean[] vis = new boolean[n];
            vis[0] = true;

            int far = 0;

            while (!q.isEmpty()) {

                int curr = q.poll();

                int start = Math.max(curr + minJump, far + 1);
                int end = Math.min(curr + maxJump, n - 1);

                for (int i = start; i <= end; i++) {

                    if (!vis[i] && s.charAt(i) == '0') {

                        if (i == n - 1) {
                            return true;
                        }

                        vis[i] = true;
                        q.offer(i);
                    }
                }

                far = Math.max(far, curr + maxJump);
            }

            return n == 1;
        }
    }

    public static void main(String[] args) {

        Solution sol = new Solution();

        String s = "011010";
        int minJump = 2;
        int maxJump = 3;

        boolean ans = sol.canReach(s, minJump, maxJump);

        System.out.println("Can Reach: " + ans);
    }
}