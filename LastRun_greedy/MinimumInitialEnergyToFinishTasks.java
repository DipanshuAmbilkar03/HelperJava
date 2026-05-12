package LastRun_greedy;

import java.util.Arrays;

public class MinimumInitialEnergyToFinishTasks {

    static class Solution {
        public int minimumEffort(int[][] tasks) {

            Arrays.sort(tasks, (a, b) ->
                (b[1] - b[0]) - (a[1] - a[0])
            );

            int eng = 0;
            int ans = 0;

            for (int[] task : tasks) {

                int actual = task[0];
                int minimum = task[1];

                // Increase energy if current energy is less than required
                if (eng < minimum) {
                    ans += (minimum - eng);
                    eng = minimum;
                }

                // Perform the task
                eng -= actual;
            }

            return ans;
        }
    }

    public static void main(String[] args) {

        Solution sol = new Solution();

        int[][] tasks1 = {
            {1, 2},
            {2, 4},
            {4, 8}
        };

        int[][] tasks2 = {
            {1, 3},
            {2, 4},
            {10, 11},
            {10, 12},
            {8, 9}
        };

        System.out.println("Minimum Initial Energy for tasks1: "
                + sol.minimumEffort(tasks1));

        System.out.println("Minimum Initial Energy for tasks2: "
                + sol.minimumEffort(tasks2));
    }
}