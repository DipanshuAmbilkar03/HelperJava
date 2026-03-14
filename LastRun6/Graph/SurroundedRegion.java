package LastRun6.Graph;

import java.util.*;

public class SurroundedRegion {

    static class Solution {
        private int[] rowIt = {-1, 0, 1, 0};
        private int[] colIt = {0, 1, 0, -1};

        public void solve(char[][] board) {
            int m = board.length;
            int n = board[0].length;

            Queue<int[]> q = new LinkedList<>();

            // Step 1: Mark boundary connected 'O'
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (i == 0 || j == 0 || i == m - 1 || j == n - 1) {
                        if (board[i][j] == 'O') {
                            q.offer(new int[]{i, j});
                            board[i][j] = 'S';
                        }
                    }
                }
            }

            // Step 2: BFS traversal
            while (!q.isEmpty()) {
                int[] val = q.poll();
                int row = val[0];
                int col = val[1];

                for (int i = 0; i < 4; i++) {
                    int r = row + rowIt[i];
                    int c = col + colIt[i];

                    if (r >= 0 && c >= 0 && r < m && c < n && board[r][c] == 'O') {
                        board[r][c] = 'S';
                        q.offer(new int[]{r, c});
                    }
                }
            }

            // Step 3: Convert surrounded regions
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (board[i][j] == 'O')
                        board[i][j] = 'X';
                    if (board[i][j] == 'S')
                        board[i][j] = 'O';
                }
            }
        }
    }

    public static void main(String[] args) {

        char[][] board = {
                {'X','X','X','X'},
                {'X','O','O','X'},
                {'X','X','O','X'},
                {'X','O','X','X'}
        };

        Solution sol = new Solution();
        sol.solve(board);

        // Print result
        for(char[] row : board){
            for(char c : row){
                System.out.print(c + " ");
            }
            System.out.println();
        }
    }
}
