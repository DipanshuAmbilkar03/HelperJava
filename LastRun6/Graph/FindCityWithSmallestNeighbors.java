package LastRun6.Graph;

import java.util.*;

public class FindCityWithSmallestNeighbors {

    static class pair {
        int node;
        int dis;

        public pair(int node, int dis) {
            this.node = node;
            this.dis = dis;
        }
    }

    public int findTheCity(int n, int[][] edges, int distanceThreshold) {

        List<List<pair>> adj = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        // Build graph
        for (int[] edge : edges) {
            adj.get(edge[0]).add(new pair(edge[1], edge[2]));
            adj.get(edge[1]).add(new pair(edge[0], edge[2]));
        }

        int minReachable = n;
        int resultCity = -1;

        // Run Dijkstra from every node
        for (int i = 0; i < n; i++) {

            int reachableCount = 0;
            int[] dists = new int[n];
            Arrays.fill(dists, Integer.MAX_VALUE);
            dists[i] = 0;

            PriorityQueue<pair> pq = new PriorityQueue<>((a, b) -> a.dis - b.dis);
            pq.offer(new pair(i, 0));

            while (!pq.isEmpty()) {
                pair curr = pq.poll();

                int node = curr.node;
                int cost = curr.dis;

                if (cost > dists[node]) continue;

                for (pair nodal : adj.get(node)) {

                    int newDist = dists[node] + nodal.dis;

                    if (newDist <= distanceThreshold && newDist < dists[nodal.node]) {
                        dists[nodal.node] = newDist;
                        pq.offer(new pair(nodal.node, newDist));
                    }
                }
            }

            // Count reachable cities
            for (int j = 0; j < n; j++) {
                if (i != j && dists[j] <= distanceThreshold) {
                    reachableCount++;
                }
            }

            // Choose city with minimum reachable nodes
            // If tie → take larger index
            if (reachableCount <= minReachable) {
                minReachable = reachableCount;
                resultCity = i;
            }
        }

        return resultCity;
    }

    // MAIN FUNCTION
    public static void main(String[] args) {
        FindCityWithSmallestNeighbors obj = new FindCityWithSmallestNeighbors();

        int n = 4;
        int[][] edges = {
                {0, 1, 3},
                {1, 2, 1},
                {1, 3, 4},
                {2, 3, 1}
        };
        int distanceThreshold = 4;

        int result = obj.findTheCity(n, edges, distanceThreshold);

        System.out.println("City with smallest reachable neighbors: " + result);
    }
}