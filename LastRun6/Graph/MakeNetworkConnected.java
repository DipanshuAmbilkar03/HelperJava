package LastRun6.Graph;
import java.util.*;

class DisjointSet {
    List<Integer> parent = new ArrayList<>();
    List<Integer> rank = new ArrayList<>();
    List<Integer> size = new ArrayList<>();

    public DisjointSet(int n) {
        for (int i = 0; i < n; i++) {
            parent.add(i);
            rank.add(0);
            size.add(1);
        }
    }

    public int findUPar(int node) {
        if (node == parent.get(node)) return node;

        int ulp = findUPar(parent.get(node));
        parent.set(node, ulp); // Path compression
        return ulp;
    }

    public void unionByRank(int u, int v) {
        int pu = findUPar(u);
        int pv = findUPar(v);

        if (pu == pv) return;

        if (rank.get(pu) < rank.get(pv)) {
            parent.set(pu, pv);
        } else if (rank.get(pv) < rank.get(pu)) {
            parent.set(pv, pu);
        } else {
            parent.set(pv, pu);
            rank.set(pu, rank.get(pu) + 1);
        }
    }

    public void unionBySize(int u, int v) {
        int pu = findUPar(u);
        int pv = findUPar(v);

        if (pu == pv) return;

        if (size.get(pu) < size.get(pv)) {
            parent.set(pu, pv);
            size.set(pv, size.get(pv) + size.get(pu));
        } else {
            parent.set(pv, pu);
            size.set(pu, size.get(pu) + size.get(pv));
        }
    }
}

public class MakeNetworkConnected {

    public int makeConnected(int n, int[][] connections) {

        // Not enough edges
        if (connections.length < n - 1) return -1;

        DisjointSet d = new DisjointSet(n);

        int countExtra = 0;

        // Process edges
        for (int[] edge : connections) {
            if (d.findUPar(edge[0]) == d.findUPar(edge[1])) {
                countExtra++; // extra cable
            } else {
                d.unionBySize(edge[0], edge[1]);
            }
        }

        // Count components
        int countNode = 0;
        for (int i = 0; i < n; i++) {
            if (d.findUPar(i) == i) countNode++;
        }

        int ans = countNode - 1;

        return (ans <= countExtra) ? ans : -1;
    }

    // MAIN FUNCTION
    public static void main(String[] args) {
        MakeNetworkConnected obj = new MakeNetworkConnected();

        int n = 6;
        int[][] connections = {
                {0, 1},
                {0, 2},
                {0, 3},
                {1, 2},
                {1, 3}
        };

        int result = obj.makeConnected(n, connections);

        System.out.println("Minimum operations to connect network: " + result);
    }
}