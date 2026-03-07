package LastRun6.Graph;

import java.util.*;

public class RottingOranges {

    static int[] rowIt = {-1, 0, 1, 0};
    static int[] colIt = {0, 1, 0, -1};

    public static int orangesRotting(int[][] grid) {

        int m = grid.length;
        int n = grid[0].length;

        int[][] vis = new int[m][n];
        Queue<int[]> queue = new LinkedList<>();

        int countFresh = 0;

        // Initial traversal
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {

                if (grid[i][j] == 2) {
                    queue.offer(new int[]{i, j, 0});
                    vis[i][j] = 2;
                }

                if (grid[i][j] == 1) {
                    vis[i][j] = 1;
                    countFresh++;
                }
            }
        }

        int maxTime = 0;
        int freshCount = 0;

        while (!queue.isEmpty()) {

            int[] value = queue.poll();

            int row = value[0];
            int col = value[1];
            int time = value[2];

            maxTime = Math.max(maxTime, time);

            for (int i = 0; i < 4; i++) {

                int newRow = row + rowIt[i];
                int newCol = col + colIt[i];

                if (newRow >= 0 && newRow < m &&
                    newCol >= 0 && newCol < n &&
                    vis[newRow][newCol] == 1) {

                    queue.offer(new int[]{newRow, newCol, time + 1});
                    vis[newRow][newCol] = 2;
                    freshCount++;
                }
            }
        }

        if (freshCount != countFresh) return -1;

        return maxTime;
    }

    public static void main(String[] args) {

        int[][] grid = {
                {2,1,1},
                {1,1,0},
                {0,1,1}
        };

        int result = orangesRotting(grid);

        System.out.println("Minimum Time to Rot All Oranges: " + result);
    }
}