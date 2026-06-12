import java.util.*;

public class assignEdgeWeights_II {

    static class Solution {
        private final int MOD = 1000000007;
        int[] depth;
        int[][] lift;
        Map<Integer, List<Integer>> hmap = new HashMap<>();

        int power(int base, int exp) {
            long res = 1;
            long b = base % MOD;

            while (exp > 0) {
                if ((exp & 1) == 1) {
                    res = (res * b) % MOD;
                }

                b = (b * b) % MOD;
                exp >>= 1;
            }

            return (int) res;
        }

        int lca(int u, int v) {
            if (depth[u] < depth[v]) {
                return lca(v, u);
            }

            int diff = depth[u] - depth[v];

            for (int j = 0; j < 18; j++) {
                if ((diff & 1) == 1) {
                    u = lift[u][j];
                }
                diff >>= 1;
            }

            if (u == v) {
                return u;
            }

            for (int j = 17; j >= 0; j--) {
                if (lift[u][j] != lift[v][j]) {
                    u = lift[u][j];
                    v = lift[v][j];
                }
            }

            return lift[u][0];
        }

        public int[] assignEdgeWeights(int[][] edges, int[][] queries) {
            int n = edges.length + 1;

            depth = new int[n + 1];
            lift = new int[n + 1][18];

            for (int[] edge : edges) {
                int u = edge[0];
                int v = edge[1];

                hmap.putIfAbsent(u, new ArrayList<>());
                hmap.putIfAbsent(v, new ArrayList<>());

                hmap.get(u).add(v);
                hmap.get(v).add(u);
            }

            Queue<Integer> q = new LinkedList<>();
            boolean[] vis = new boolean[n + 1];

            q.offer(1);
            vis[1] = true;
            lift[1][0] = 1;

            while (!q.isEmpty()) {
                int curr = q.poll();

                List<Integer> children = hmap.get(curr);
                if (children == null) {
                    continue;
                }

                for (int next : children) {
                    if (vis[next]) {
                        continue;
                    }

                    vis[next] = true;
                    depth[next] = depth[curr] + 1;
                    lift[next][0] = curr;

                    q.offer(next);
                }
            }

            for (int i = 1; i <= n; i++) {
                for (int j = 1; j < 18; j++) {
                    lift[i][j] = lift[lift[i][j - 1]][j - 1];
                }
            }

            int[] ans = new int[queries.length];

            for (int i = 0; i < queries.length; i++) {
                int u = queries[i][0];
                int v = queries[i][1];

                int lcaNode = lca(u, v);
                int dist = depth[u] + depth[v] - 2 * depth[lcaNode];

                ans[i] = (dist == 0) ? 0 : power(2, dist - 1);
            }

            return ans;
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        int[][] edges = {
            {1, 2},
            {1, 3},
            {3, 4},
            {3, 5}
        };

        int[][] queries = {
            {2, 4},
            {4, 5},
            {1, 1}
        };

        int[] ans = sol.assignEdgeWeights(edges, queries);

        System.out.println(Arrays.toString(ans));
    }
}