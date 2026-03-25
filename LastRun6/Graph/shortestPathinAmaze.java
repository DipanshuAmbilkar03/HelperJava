package LastRun6.Graph;
import java.util.*;

class shortestPathinAmaze {
    private int[] rowIt = {-1, -1, -1, 0, 0, 1, 1, 1};
    private int[] colIt = {-1, 0, 1, -1, 1, -1, 0, 1};
    private int count;

    public int shortestPathBinaryMatrix(int[][] grid) {
        int n = grid.length;
        count = 1;

        if (grid[0][0] == 1 || grid[n-1][n-1] == 1) {
            return -1;
        }

        Queue<int[]> q = new LinkedList<>();
        boolean[][] vis = new boolean[n][n];

        q.offer(new int[]{0,0});
        vis[0][0] = true;

        while(!q.isEmpty()) {
            int size = q.size();

            for(int s = 0; s < size; s++) {
                int[] curr = q.poll();
                int r = curr[0];
                int c = curr[1];

                if(r == n-1 && c == n-1) return count;

                for(int i = 0; i < 8; i++) {
                    int newr = r + rowIt[i];
                    int newc = c + colIt[i];

                    if(newr >= 0 && newc >= 0 && newr < n && newc < n 
                        && grid[newr][newc] == 0 && !vis[newr][newc]) {

                        vis[newr][newc] = true;
                        q.offer(new int[]{newr, newc});
                    }
                }
            }
            count++;
        }
        return -1;
    }
}

public class Main {
    public static void main(String[] args) {
        Solution sol = new Solution();

        // Test case 1
        int[][] grid1 = {
            {0, 1},
            {1, 0}
        };

        // Test case 2
        int[][] grid2 = {
            {0, 0, 0},
            {1, 1, 0},
            {1, 1, 0}
        };

        System.out.println("Output 1: " + sol.shortestPathBinaryMatrix(grid1)); // Expected: 2
        System.out.println("Output 2: " + sol.shortestPathBinaryMatrix(grid2)); // Expected: 4
    }
}