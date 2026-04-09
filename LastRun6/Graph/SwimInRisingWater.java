package LastRun.Graph;
import java.util.*;

public class SwimInRisingWater {

    private static boolean isValid(int row, int col, boolean[][] vis, int[][] grid) {
        int n = grid.length;
        return (row >= 0 && row < n && col >= 0 && col < n && !vis[row][col]);
    }

    public static int swimInWater(int[][] grid) {
        int n = grid.length;

        // Min-heap based on time (height)
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[2] - b[2]);

        boolean[][] vis = new boolean[n][n];

        // {row, col, maxHeightTillNow}
        pq.offer(new int[]{0, 0, grid[0][0]});

        int[] dr = {-1, 0, 1, 0};
        int[] dc = {0, 1, 0, -1};

        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            int x = curr[0];
            int y = curr[1];
            int time = curr[2];

            if (vis[x][y]) continue;
            vis[x][y] = true;

            // Reached destination
            if (x == n - 1 && y == n - 1) {
                return time;
            }

            for (int i = 0; i < 4; i++) {
                int newr = x + dr[i];
                int newc = y + dc[i];

                if (isValid(newr, newc, vis, grid)) {
                    pq.offer(new int[]{
                        newr,
                        newc,
                        Math.max(time, grid[newr][newc])
                    });
                }
            }
        }

        return -1; // Should never happen
    }

    // 🔹 Main Method for Testing
    public static void main(String[] args) {
        int[][] grid = {
            {0, 2},
            {1, 3}
        };

        int result = swimInWater(grid);
        System.out.println("Minimum time to reach end: " + result);
    }
}