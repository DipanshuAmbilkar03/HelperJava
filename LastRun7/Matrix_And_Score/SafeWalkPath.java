package LastRun7.Matrix_And_Score;
import java.util.*;
public class SafeWalkPath {

    private final int[] row = {0, 0, -1, 1};
    private final int[] col = {-1, 1, 0, 0};

    private boolean bfs(List<List<Integer>> grid, int n, int m, int h) {

        Deque<int[]> dq = new ArrayDeque<>();
        int[][] distance = new int[n][m];

        for (int[] d : distance) {
            Arrays.fill(d, Integer.MAX_VALUE);
        }

        int initialCost = grid.get(0).get(0);

        distance[0][0] = initialCost;
        dq.offerFirst(new int[]{0, 0, initialCost});

        while (!dq.isEmpty()) {

            int[] curr = dq.pollFirst();
            int r = curr[0];
            int c = curr[1];
            int cost = curr[2];

            if (cost > distance[r][c]) continue;

            if (r == n - 1 && c == m - 1) {
                return cost <= h - 1;
            }

            for (int i = 0; i < 4; i++) {

                int nr = r + row[i];
                int nc = c + col[i];

                if (nr >= 0 && nr < n && nc >= 0 && nc < m) {

                    int newCost = cost + grid.get(nr).get(nc);

                    if (newCost < distance[nr][nc]) {

                        distance[nr][nc] = newCost;

                        if (grid.get(nr).get(nc) == 0) {
                            dq.offerFirst(new int[]{nr, nc, newCost});
                        } else {
                            dq.offerLast(new int[]{nr, nc, newCost});
                        }
                    }
                }
            }
        }

        return false;
    }

    public boolean findSafeWalk(List<List<Integer>> grid, int health) {
        int n = grid.size();
        int m = grid.get(0).size();
        return bfs(grid, n, m, health);
    }

    public static void main(String[] args) {

        SafeWalkPath sol = new SafeWalkPath();

        List<List<Integer>> grid1 = Arrays.asList(
                Arrays.asList(0, 1, 0),
                Arrays.asList(0, 1, 0),
                Arrays.asList(0, 0, 0)
        );

        List<List<Integer>> grid2 = Arrays.asList(
                Arrays.asList(0, 1),
                Arrays.asList(1, 0)
        );

        System.out.println(sol.findSafeWalk(grid1, 3));
        System.out.println(sol.findSafeWalk(grid2, 2));
    }
}