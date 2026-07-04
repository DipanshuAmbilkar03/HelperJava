package LastRun6.Graph;
import java.util.*;

public class MinScorePath {

    public static int minScore(int n, int[][] roads) {

        List<List<int[]>> adj = new ArrayList<>();

        for (int i = 0; i <= n; i++) {
            adj.add(new ArrayList<>());
        }

        for (int[] r : roads) {

            int u = r[0];
            int v = r[1];
            int w = r[2];

            adj.get(u).add(new int[]{v, w});
            adj.get(v).add(new int[]{u, w});
        }

        Queue<Integer> q = new LinkedList<>();
        boolean[] vis = new boolean[n + 1];

        q.offer(1);
        vis[1] = true;

        int ans = Integer.MAX_VALUE;

        while (!q.isEmpty()) {

            int node = q.poll();

            for (int[] edge : adj.get(node)) {

                int next = edge[0];
                int cost = edge[1];

                ans = Math.min(ans, cost);

                if (!vis[next]) {
                    vis[next] = true;
                    q.offer(next);
                }
            }
        }

        return ans;
    }

    public static void main(String[] args) {

        int[][] roads1 = {
                {1, 2, 9},
                {2, 3, 6},
                {1, 3, 5}
        };

        int[][] roads2 = {
                {1, 2, 2},
                {1, 3, 4},
                {3, 4, 7}
        };

        System.out.println(minScore(3, roads1));
        System.out.println(minScore(4, roads2));
    }
}