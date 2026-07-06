package LastRun7.arrays;

import java.util.Arrays;

public class RemoveCoveredIntervals {

    public static int removeCoveredIntervals(int[][] intervals) {

        Arrays.sort(intervals, (a, b) -> {
            if (a[0] == b[0]) return b[1] - a[1];
            return a[0] - b[0];
        });

        int covered = 0;
        int prev = 0;
        int n = intervals.length;

        for (int i = 1; i < n; i++) {

            if (intervals[i][0] >= intervals[prev][0]
                    && intervals[i][1] <= intervals[prev][1]) {
                covered++;
            } else {
                prev = i;
            }
        }

        return n - covered;
    }

    public static void main(String[] args) {

        int[][] intervals1 = {
                {1, 4},
                {3, 6},
                {2, 8}
        };

        int[][] intervals2 = {
                {1, 4},
                {2, 3}
        };

        int[][] intervals3 = {
                {0, 10},
                {5, 12}
        };

        System.out.println(removeCoveredIntervals(intervals1));
        System.out.println(removeCoveredIntervals(intervals2));
        System.out.println(removeCoveredIntervals(intervals3));
    }
}