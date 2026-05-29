package LastRun7.Matrix_And_Score;

import java.util.*;

public class Minimum_Cost_to_Make_at_Least_One_Valid_Path_in_a_Grid {

    static class Solution {

        class Pair {
            int curr;
            int r;
            int c;

            public Pair(int curr, int r, int c) {
                this.curr = curr;
                this.r = r;
                this.c = c;
            }
        }

        private int[] nr = {0, 0, 1, -1};
        private int[] nc = {1, -1, 0, 0};

        public int minCost(int[][] grid) {
            int m = grid.length;
            int n = grid[0].length;

            int[][] ans = new int[m][n];

            for (int[] i : ans) {
                Arrays.fill(i, Integer.MAX_VALUE);
            }

            ans[0][0] = 0;

            Queue<Pair> q = new LinkedList<>();
            q.offer(new Pair(0, 0, 0));

            while (!q.isEmpty()) {

                Pair p = q.poll();

                int currCost = p.curr;
                int row = p.r;
                int col = p.c;

                for (int i = 0; i < 4; i++) {

                    int newr = row + nr[i];
                    int newc = col + nc[i];

                    if (newr >= 0 && newr < m && newc >= 0 && newc < n) {

                        int updateCost = currCost;

                        if (grid[row][col] != i + 1) {
                            updateCost++;
                        }

                        if (updateCost < ans[newr][newc]) {
                            ans[newr][newc] = updateCost;
                            q.offer(new Pair(updateCost, newr, newc));
                        }
                    }
                }
            }

            return ans[m - 1][n - 1];
        }
    }


    public static void main(String[] args) {

        int[][] grid = {
                {1, 1, 3},
                {3, 2, 2},
                {1, 1, 4}
        };

        Solution obj = new Solution();

        int result = obj.minCost(grid);

        System.out.println("Minimum Cost: " + result);
    }
}