package LastRun2;

import java.util.*;

public class assignEdgeWeights_I {

    private static final long MOD = 1_000_000_007L;

    public static int assignEdgeWeights(int[][] edges) {
        List<List<Integer>> adj = new ArrayList<>();

        int n = 0;
        for (int[] e : edges) {
            n = Math.max(n, Math.max(e[0], e[1]));
        }
        n++;

        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        for (int[] e : edges) {
            int u = e[0];
            int v = e[1];

            adj.get(u).add(v);
            adj.get(v).add(u);
        }

        Queue<int[]> q = new LinkedList<>();
        boolean[] vis = new boolean[n];

        int depth = 0;

        q.offer(new int[]{1, 0});
        vis[1] = true;

        while (!q.isEmpty()) {
            int[] curr = q.poll();

            int node = curr[0];
            int d = curr[1];

            depth = Math.max(depth, d);

            for (int next : adj.get(node)) {
                if (!vis[next]) {
                    vis[next] = true;
                    q.offer(new int[]{next, d + 1});
                }
            }
        }

        return modPow(2, depth - 1);
    }

    private static int modPow(long base, long exp) {
        long res = 1;

        while (exp > 0) {
            if ((exp & 1) == 1) {
                res = (res * base) % MOD;
            }

            base = (base * base) % MOD;
            exp >>= 1;
        }

        return (int) res;
    }

    public static void main(String[] args) {
        int[][] edges = {
            {1, 2}
        };

        System.out.println(assignEdgeWeights(edges));
    }
}