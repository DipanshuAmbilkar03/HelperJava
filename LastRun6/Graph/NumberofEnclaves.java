package LastRun6.Graph;

import java.util.*;

public class NumberofEnclaves {

    static class Solution {
        private int[] rowIt = {-1, 0, 1, 0};
        private int[] colIt = {0, 1, 0, -1};

        public int numEnclaves(int[][] grid) {
            int m = grid.length;
            int n = grid[0].length;
            int count = 0;

            Queue<int[]> q = new LinkedList<>();

            // Step 1: Add all boundary 1's to queue and mark them as 0
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if ((i == 0 || j == 0 || i == m - 1 || j == n - 1) && grid[i][j] == 1) {
                        grid[i][j] = 0;
                        q.offer(new int[]{i, j});
                    }
                }
            }

            // Step 2: BFS to remove all connected land from boundary
            while (!q.isEmpty()) {
                int[] curr = q.poll();
                int r = curr[0];
                int c = curr[1];

                for (int i = 0; i < 4; i++) {
                    int nr = r + rowIt[i];
                    int nc = c + colIt[i];

                    if (nr >= 0 && nr < m && nc >= 0 && nc < n && grid[nr][nc] == 1) {
                        grid[nr][nc] = 0;
                        q.offer(new int[]{nr, nc});
                    }
                }
            }

            // Step 3: Count remaining 1's (enclaves)
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (grid[i][j] == 1) count++;
                }
            }

            return count;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Input: rows and columns
        int m = sc.nextInt();
        int n = sc.nextInt();

        int[][] grid = new int[m][n];

        // Input grid
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                grid[i][j] = sc.nextInt();
            }
        }

        Solution sol = new Solution();
        int result = sol.numEnclaves(grid);

        System.out.println("Number of Enclaves: " + result);

        sc.close();
    }
}