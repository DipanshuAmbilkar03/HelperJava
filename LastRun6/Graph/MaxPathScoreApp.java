import java.util.*;

public class MaxPathScoreApp {

    static class Solution {
        private List<int[]>[] g;
        private long[] memo;
        private int n;

        public int findMaxPathScore(int[][] edges, boolean[] online, long k) {
            n = online.length;
            g = new ArrayList[n];

            for (int i = 0; i < n; i++) {
                g[i] = new ArrayList<>();
            }

            int l = Integer.MAX_VALUE;
            int r = 0;

            for (int[] edge : edges) {
                int u = edge[0];
                int v = edge[1];
                int w = edge[2];

                if (!online[u] || !online[v]) continue;

                g[u].add(new int[]{v, w});

                l = Math.min(l, w);
                r = Math.max(r, w);
            }

            if (!check(l, k)) return -1;

            while (l <= r) {
                int mid = (l + r) >> 1;

                if (check(mid, k)) {
                    l = mid + 1;
                } else {
                    r = mid - 1;
                }
            }

            return r;
        }

        private boolean check(int mid, long k) {
            memo = new long[n];
            Arrays.fill(memo, -1);
            return dfs(0, mid) <= k;
        }

        private long dfs(int u, int mid) {
            if (u == n - 1) return 0;

            if (memo[u] != -1) return memo[u];

            long res = Long.MAX_VALUE / 2;

            for (int[] edge : g[u]) {
                int v = edge[0];
                int w = edge[1];

                if (w >= mid) {
                    res = Math.min(res, dfs(v, mid) + w);
                }
            }

            return memo[u] = res;
        }
    }

    public static void main(String[] args) {

        Solution sol = new Solution();

        int[][] edges = {
            {0, 1, 5},
            {1, 2, 6},
            {0, 2, 3}
        };

        boolean[] online = {true, true, true};

        long k = 10;

        int ans = sol.findMaxPathScore(edges, online, k);

        System.out.println(ans);
    }
}