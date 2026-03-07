package LastRun6.Graph;

import java.util.*;

public class FloodFill {

    public static int[][] floodFill(int[][] image, int sr, int sc, int color) {

        int initialColor = image[sr][sc];

        if (initialColor == color) return image;

        int m = image.length;
        int n = image[0].length;

        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{sr, sc});

        int[] deltaRow = {-1, 0, 1, 0};
        int[] deltaCol = {0, 1, 0, -1};

        image[sr][sc] = color;

        while (!q.isEmpty()) {

            int[] cell = q.poll();
            int r = cell[0];
            int c = cell[1];

            for (int i = 0; i < 4; i++) {

                int newRow = r + deltaRow[i];
                int newCol = c + deltaCol[i];

                if (newRow >= 0 && newCol >= 0 &&
                    newRow < m && newCol < n &&
                    image[newRow][newCol] == initialColor) {

                    image[newRow][newCol] = color;
                    q.offer(new int[]{newRow, newCol});
                }
            }
        }

        return image;
    }

    public static void main(String[] args) {

        int[][] image = {
                {1,1,1},
                {1,1,0},
                {1,0,1}
        };

        int sr = 1;
        int sc = 1;
        int color = 2;

        int[][] result = floodFill(image, sr, sc, color);

        System.out.println("Flood Filled Image:");

        for (int[] row : result) {
            System.out.println(Arrays.toString(row));
        }
    }
}