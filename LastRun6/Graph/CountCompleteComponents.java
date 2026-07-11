package LastRun6.Graph;

import java.util.*;

public class CountCompleteComponents {

    private static boolean[] vis;
    private static Map<Integer, List<Integer>> hmap;

    public static int countCompleteComponents(int n, int[][] edges) {

        vis = new boolean[n];
        hmap = new HashMap<>();

        for (int[] edge : edges) {

            int u = edge[0];
            int v = edge[1];

            hmap.putIfAbsent(u, new ArrayList<>());
            hmap.putIfAbsent(v, new ArrayList<>());

            hmap.get(u).add(v);
            hmap.get(v).add(u);
        }

        int count = 0;

        for (int i = 0; i < n; i++) {

            if (vis[i]) continue;

            int[] res = dfs(i);

            int nodes = res[0];
            int edgeCount = res[1];

            if ((nodes * (nodes - 1)) == edgeCount || nodes == 1) {
                count++;
            }
        }

        return count;
    }

    private static int[] dfs(int node) {

        int[] ret = new int[2];

        vis[node] = true;
        ret[0] = 1;

        List<Integer> list = hmap.get(node);

        if (list == null) return ret;

        ret[1] = list.size();

        for (int next : list) {

            if (vis[next]) continue;

            int[] temp = dfs(next);

            ret[0] += temp[0];
            ret[1] += temp[1];
        }

        return ret;
    }

    public static void main(String[] args) {

        int n1 = 6;
        int[][] edges1 = {
                {0, 1},
                {0, 2},
                {1, 2},
                {3, 4}
        };

        int n2 = 6;
        int[][] edges2 = {
                {0, 1},
                {0, 2},
                {1, 2},
                {3, 4},
                {4, 5},
                {3, 5}
        };

        int n3 = 5;
        int[][] edges3 = {};

        System.out.println(countCompleteComponents(n1, edges1));
        System.out.println(countCompleteComponents(n2, edges2));
        System.out.println(countCompleteComponents(n3, edges3));
    }
}