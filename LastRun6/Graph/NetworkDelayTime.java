package LastRun6.Graph;

import java.util.*;

public class NetworkDelayTime {

    static class Pair {
        int node;
        int time;

        public Pair(int node, int time) {
            this.node = node;
            this.time = time;
        }
    }

    public static int networkDelayTime(int[][] times, int n, int k) {
        List<List<Pair>> adj = new ArrayList<>();

        for (int i = 0; i <= n; i++) {
            adj.add(new ArrayList<>());
        }

        // Build graph
        for (int[] t : times) {
            int u = t[0];
            int v = t[1];
            int w = t[2];
            adj.get(u).add(new Pair(v, w));
        }

        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> a.time - b.time);
        pq.add(new Pair(k, 0));

        boolean[] visited = new boolean[n + 1];
        int maxTime = 0;

        while (!pq.isEmpty()) {
            Pair curr = pq.poll();
            int node = curr.node;
            int time = curr.time;

            if (visited[node]) continue;

            visited[node] = true;
            maxTime = Math.max(maxTime, time);

            for (Pair nei : adj.get(node)) {
                if (!visited[nei.node]) {
                    pq.add(new Pair(nei.node, time + nei.time));
                }
            }
        }

        // Check if all nodes are reached
        for (int i = 1; i <= n; i++) {
            if (!visited[i]) return -1;
        }

        return maxTime;
    }

    // ✅ Main method for local testing
    public static void main(String[] args) {

        int[][] times = {
            {2, 1, 1},
            {2, 3, 1},
            {3, 4, 1}
        };

        int n = 4;
        int k = 2;

        int result = networkDelayTime(times, n, k);
        System.out.println("Network Delay Time: " + result);
    }
}