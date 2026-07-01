import java.util.*;

public class MaximumSafenessFactor {

    private static final int[] row = {0, 0, -1, 1};
    private static final int[] col = {-1, 1, 0, 0};

    public static int maximumSafenessFactor(List<List<Integer>> grid) {

        int n = grid.size();

        if (grid.get(0).get(0) == 1 || grid.get(n - 1).get(n - 1) == 1) {
            return 0;
        }

        int[][] mat = new int[n][n];
        int[][] score = new int[n][n];

        for (int[] arr : score) {
            Arrays.fill(arr, Integer.MAX_VALUE);
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                mat[i][j] = grid.get(i).get(j);
            }
        }

        bfs(mat, score, n);

        boolean[][] vis = new boolean[n][n];

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> b[0] - a[0]);
        pq.offer(new int[]{score[0][0], 0, 0});

        while (!pq.isEmpty()) {

            int[] curr = pq.poll();

            int safe = curr[0];
            int x = curr[1];
            int y = curr[2];

            if (x == n - 1 && y == n - 1) {
                return safe;
            }

            if (vis[x][y]) continue;

            vis[x][y] = true;

            for (int k = 0; k < 4; k++) {

                int nx = x + row[k];
                int ny = y + col[k];

                if (nx >= 0 && nx < n && ny >= 0 && ny < n && !vis[nx][ny]) {

                    int newSafe = Math.min(safe, score[nx][ny]);
                    pq.offer(new int[]{newSafe, nx, ny});
                }
            }
        }

        return -1;
    }

    private static void bfs(int[][] mat, int[][] score, int n) {

        Queue<int[]> q = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {

                if (mat[i][j] == 1) {
                    score[i][j] = 0;
                    q.offer(new int[]{i, j});
                }
            }
        }

        while (!q.isEmpty()) {

            int[] curr = q.poll();
            int r = curr[0];
            int c = curr[1];
            int s = score[r][c];

            for (int k = 0; k < 4; k++) {

                int nr = r + row[k];
                int nc = c + col[k];

                if (nr >= 0 && nr < n && nc >= 0 && nc < n
                        && score[nr][nc] > s + 1) {

                    score[nr][nc] = s + 1;
                    q.offer(new int[]{nr, nc});
                }
            }
        }
    }

    public static void main(String[] args) {

        List<List<Integer>> grid1 = Arrays.asList(
                Arrays.asList(0, 0, 0),
                Arrays.asList(0, 1, 0),
                Arrays.asList(0, 0, 0)
        );

        List<List<Integer>> grid2 = Arrays.asList(
                Arrays.asList(0, 0),
                Arrays.asList(0, 1)
        );

        System.out.println(maximumSafenessFactor(grid1));
        System.out.println(maximumSafenessFactor(grid2));
    }
}