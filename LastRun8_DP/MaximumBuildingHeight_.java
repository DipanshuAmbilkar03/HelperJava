package LastRun8_DP;
import java.util.Arrays;

class MaximumBuildingHeight_ {

    private int[][] r;

    public int maxBuilding(int n, int[][] restrictions) {

        int m = restrictions.length;

        r = new int[m + 2][2];
        r[0] = new int[]{1, 0};
        r[1] = new int[]{n, n - 1};

        for (int i = 0; i < m; i++) {
            r[i + 2] = restrictions[i];
        }

        Arrays.sort(r, (a, b) -> Integer.compare(a[0], b[0]));

        for (int i = 1; i < r.length; i++) {
            r[i][1] = Math.min(
                r[i][1],
                r[i - 1][1] + (r[i][0] - r[i - 1][0])
            );
        }

        for (int i = r.length - 2; i >= 0; i--) {
            r[i][1] = Math.min(
                r[i][1],
                r[i + 1][1] + (r[i + 1][0] - r[i][0])
            );
        }

        int ans = 0;

        for (int i = 0; i < r.length - 1; i++) {

            int x1 = r[i][0];
            int h1 = r[i][1];

            int x2 = r[i + 1][0];
            int h2 = r[i + 1][1];

            int dist = x2 - x1;

            ans = Math.max(
                ans,
                (h1 + h2 + dist) / 2
            );
        }

        return ans;
    }
}