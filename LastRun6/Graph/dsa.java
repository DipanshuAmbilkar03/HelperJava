package LastRun6.Graph;

import java.util.*;

public class Main {

    static class Solution {

        private int[] rowIt = {-1, 0, 1, 0};
        private int[] colIt = {0, 1, 0, -1};

        public int[][] highestPeak(int[][] isWater) {

            int m = isWater.length;
            int n = isWater[0].length;

            Queue<int[]> q = new LinkedList<>();

            // Step 1: Initialize queue with all water cells
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {

                    if (isWater[i][j] == 1) {
                        q.offer(new int[]{i, j});
                        isWater[i][j] = 0;   // water height = 0
                    } else {
                        isWater[i][j] = -1;  // land not visited
                    }

                }
            }

            // Step 2: Multi-source BFS
            while (!q.isEmpty()) {

                int[] val = q.poll();
                int row = val[0];
                int col = val[1];

                for (int i = 0; i < 4; i++) {

                    int r = row + rowIt[i];
                    int c = col + colIt[i];

                    if (r >= 0 && c >= 0 && r < m && c < n && isWater[r][c] == -1) {

                        isWater[r][c] = isWater[row][col] + 1;
                        q.offer(new int[]{r, c});

                    }
                }
            }

            return isWater;
        }
    }

    public static void main(String[] args) {

        int[][] isWater = {
                {0, 1},
                {0, 0}
        };

        Solution sol = new Solution();
        int[][] result = sol.highestPeak(isWater);

        System.out.println("Height Map:");

        for (int[] row : result) {
            for (int val : row) {
                System.out.print(val + " ");
            }
            System.out.println();
        }
    }
}
