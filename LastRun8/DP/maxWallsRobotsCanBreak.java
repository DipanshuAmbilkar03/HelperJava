package LastRun8.DP;

import java.util.*;

public class maxWallsRobotsCanBreak {

    public int maxWalls(int[] robots, int[] distance, int[] walls) {
        int n = robots.length;
        int r[][] = new int[n + 2][2];

        // Store robots and distances
        for (int i = 0; i < robots.length; i++) {
            r[i][0] = robots[i];
            r[i][1] = distance[i];
        }

        // Sentinel values
        r[n][0] = -1;
        r[n][1] = 0;
        r[n + 1][0] = Integer.MAX_VALUE;
        r[n + 1][1] = 0;

        // Sort robots and walls
        Arrays.sort(r, (a, b) -> Integer.compare(a[0], b[0]));
        Arrays.sort(walls);

        int LL = 0, LR = 1, RL = 2, RR = 3;
        int dp[] = new int[4];

        int leftRobot = 0;
        int rightRobot = 1;

        for (int wall : walls) {

            // Shift robot window
            while (wall > r[rightRobot][0]) {
                leftRobot++;
                rightRobot++;

                int maxL = Math.max(dp[LL], dp[RL]);
                int maxR = Math.max(dp[LR], dp[RR]);

                dp[LL] = maxL;
                dp[LR] = maxL;

                dp[RR] = maxR;
                dp[RL] = maxR;
            }

            int r1 = r[leftRobot][0] + r[leftRobot][1];
            int r2 = r[rightRobot][0] - r[rightRobot][1];

            boolean canr1 = wall <= r1;
            boolean canr2 = wall >= r2;

            boolean isRightcan = wall == r[rightRobot][0];

            if (canr2) dp[LL]++;
            if (isRightcan) dp[LR]++;
            if (canr1 || canr2) dp[RL]++;
            if (canr1 || isRightcan) dp[RR]++;
        }

        int ans = 0;
        for (int i : dp) {
            ans = Math.max(ans, i);
        }

        return ans;
    }

    // MAIN FUNCTION
    public static void main(String[] args) {
        Solution sol = new Solution();

        // Example test case
        int[] robots = {2, 6, 10};
        int[] distance = {2, 3, 1};
        int[] walls = {1, 3, 5, 7, 9, 11};

        int result = sol.maxWalls(robots, distance, walls);

        System.out.println("Maximum walls covered: " + result);
    }
}