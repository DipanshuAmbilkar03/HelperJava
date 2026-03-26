package LastRun6.Graph;

import java.util.*;

public class CheapestFlightsWithinKStops {

    static class pair {
        int cost;
        int path;

        public pair(int cost, int path) {
            this.cost = cost;
            this.path = path;
        }
    }

    static class qpair {
        int first;
        int second;
        int third;

        public qpair(int first, int second, int third) {
            this.first = first;
            this.second = second;
            this.third = third;
        }
    }

    public static int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {

        List<List<pair>> arr = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            arr.add(new ArrayList<>());
        }

        for (int i = 0; i < flights.length; i++) {
            arr.get(flights[i][0]).add(new pair(flights[i][1], flights[i][2]));
        }

        Queue<qpair> q = new LinkedList<>();
        q.offer(new qpair(0, src, 0));

        int[] ans = new int[n];
        Arrays.fill(ans, (int)1e9);

        ans[src] = 0;

        while (!q.isEmpty()) {
            qpair cur = q.poll();
            int stops = cur.first;
            int node = cur.second;
            int cost = cur.third;

            if (stops > k) continue;

            for (pair it : arr.get(node)) {
                int adjNode = it.cost;
                int price = it.path;

                if (cost + price < ans[adjNode]) {
                    ans[adjNode] = cost + price;
                    q.offer(new qpair(stops + 1, adjNode, cost + price));
                }
            }
        }

        return ans[dst] == (int)1e9 ? -1 : ans[dst];
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Input format:
        // n (nodes)
        // m (number of flights)
        // next m lines: u v w
        // src dst k

        int n = sc.nextInt();
        int m = sc.nextInt();

        int[][] flights = new int[m][3];

        for (int i = 0; i < m; i++) {
            flights[i][0] = sc.nextInt();
            flights[i][1] = sc.nextInt();
            flights[i][2] = sc.nextInt();
        }

        int src = sc.nextInt();
        int dst = sc.nextInt();
        int k = sc.nextInt();

        int result = findCheapestPrice(n, flights, src, dst, k);
        System.out.println(result);

        sc.close();
    }
}