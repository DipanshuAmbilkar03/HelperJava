package LastRun7.Land and water park rides complete ques;

public class earliest_finish_time_for_land_and_water_rides_i {

    private int solve(int[] start1, int[] duration1, int[] start2, int[] duration2) {
        int finish1 = Integer.MAX_VALUE;
        for (int i = 0; i < start1.length; i++) {
            finish1 = Math.min(finish1, start1[i] + duration1[i]);
        }

        int finish2 = Integer.MAX_VALUE;
        for (int i = 0; i < start2.length; i++) {
            finish2 = Math.min(
                finish2,
                Math.max(start2[i], finish1) + duration2[i]
            );
        }

        return finish2;
    }

    public int earliest_finish_time(int[] landStartTime, int[] landDuration,
                                    int[] waterStartTime, int[] waterDuration) {

        // TreeMap<Integer,Integer> map = new TreeMap<>();
        // PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(a[0], b[0]));

        // --------------------------------------
        // int ltime = Integer.MAX_VALUE;
        // int time = Integer.MAX_VALUE;
        // int wtime = Integer.MAX_VALUE;

        // for(int i=0; i<landStartTime.length; i++) {
        //     ltime = Math.min(ltime,landStartTime[i]+landDuration[i]);
        // }

        // for(int i=0; i<waterStartTime.length; i++) {
        //     int curr = Math.max(ltime,waterStartTime[i])+waterDuration[i];
        //     time = Math.min(time,curr);
        // }

        // for(int i=0; i<waterStartTime.length; i++) {
        //     wtime = Math.min(wtime,waterStartTime[i]+waterDuration[i]);
        // }

        // for(int i=0; i<landStartTime.length; i++) {
        //     int curr = Math.max(wtime,landStartTime[i])+landDuration[i];
        //     time = Math.min(time,curr);
        // }

        // return time;
        // ---------------------------------------------

        int land_water = solve(
            landStartTime,
            landDuration,
            waterStartTime,
            waterDuration
        );

        int water_land = solve(
            waterStartTime,
            waterDuration,
            landStartTime,
            landDuration
        );

        return Math.min(land_water, water_land);
    }
}