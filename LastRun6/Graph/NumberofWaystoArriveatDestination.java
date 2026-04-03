package LastRun6.Graph;

import java.util.*;

public class NumberofWaystoArriveatDestination {

    class pair {
        int node;
        long dist;

        pair(int node, long dist) {
            this.node = node;
            this.dist = dist;
        }
    }

    public int countPaths(int n, int[][] roads) {

        List<List<pair>> adj = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        // Build graph
        for (int[] val : roads) {
            adj.get(val[0]).add(new pair(val[1], val[2]));
            adj.get(val[1]).add(new pair(val[0], val[2]));
        }

        long[] dist = new long[n];
        Arrays.fill(dist, Long.MAX_VALUE);

        int[] ways = new int[n];

        PriorityQueue<pair> q = new PriorityQueue<>((a, b) -> Long.compare(a.dist, b.dist));

        q.offer(new pair(0, 0));
        dist[0] = 0;
        ways[0] = 1;

        int mod = (int) (1e9 + 7);

        while (!q.isEmpty()) {
            pair curr = q.poll();

            for (pair t : adj.get(curr.node)) {

                long newDist = curr.dist + t.dist;

                if (newDist < dist[t.node]) {
                    dist[t.node] = newDist;
                    ways[t.node] = ways[curr.node];
                    q.offer(new pair(t.node, newDist));
                } 
                else if (newDist == dist[t.node]) {
                    ways[t.node] = (ways[t.node] + ways[curr.node]) % mod;
                }
            }
        }

        return ways[n - 1] % mod;
    }

    // MAIN FUNCTION
    public static void main(String[] args) {
        NumberofWaystoArriveatDestination sol = new NumberofWaystoArriveatDestination();

        int n = 7;
        int[][] roads = {
                {0, 6, 7},
                {0, 1, 2},
                {1, 2, 3},
                {1, 3, 3},
                {6, 3, 3},
                {3, 5, 1},
                {6, 5, 1},
                {2, 5, 1},
                {0, 4, 5},
                {4, 6, 2}
        };

        int result = sol.countPaths(n, roads);

        System.out.println("Number of shortest paths: " + result);
    }
}