import java.util.*;

public class MakingALargeIsland {

    static class DisjointSet {
        List<Integer> parent = new ArrayList<>();
        List<Integer> size = new ArrayList<>();

        public DisjointSet(int n) {
            for (int i = 0; i < n; i++) {
                parent.add(i);
                size.add(1);
            }
        }

        public int findUPar(int node) {
            if (node == parent.get(node)) return node;
            int ulp = findUPar(parent.get(node));
            parent.set(node, ulp); // Path compression
            return ulp;
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

    public static int largestIsland(int[][] grid) {
        int n = grid.length;
        DisjointSet ds = new DisjointSet(n * n);

        int[] dr = {-1, 0, 1, 0};
        int[] dc = {0, 1, 0, -1};

        // Step 1: Connect all 1s
        for (int row = 0; row < n; row++) {
            for (int col = 0; col < n; col++) {
                if (grid[row][col] == 0) continue;

                for (int i = 0; i < 4; i++) {
                    int newr = row + dr[i];
                    int newc = col + dc[i];

                    if (newr >= 0 && newr < n && newc >= 0 && newc < n && grid[newr][newc] == 1) {
                        int node = row * n + col;
                        int adj = newr * n + newc;
                        ds.unionBySize(node, adj);
                    }
                }
            }
        }

        int maxCount = 0;

        // Step 2: Try converting each 0 → 1
        for (int row = 0; row < n; row++) {
            for (int col = 0; col < n; col++) {
                if (grid[row][col] == 1) continue;

                HashSet<Integer> components = new HashSet<>();

                for (int i = 0; i < 4; i++) {
                    int newr = row + dr[i];
                    int newc = col + dc[i];

                    if (newr >= 0 && newr < n && newc >= 0 && newc < n && grid[newr][newc] == 1) {
                        components.add(ds.findUPar(newr * n + newc));
                    }
                }

                int sizeTotal = 0;
                for (int parent : components) {
                    sizeTotal += ds.size.get(parent);
                }

                maxCount = Math.max(maxCount, sizeTotal + 1);
            }
        }

        // Step 3: Edge case (all 1s)
        for (int i = 0; i < n * n; i++) {
            maxCount = Math.max(maxCount, ds.size.get(ds.findUPar(i)));
        }

        return maxCount;
    }

    // 🔹 Main Function
    public static void main(String[] args) {
        int[][] grid = {
            {1, 0},
            {0, 1}
        };

        int result = largestIsland(grid);
        System.out.println("Largest Island Size: " + result);
    }
}