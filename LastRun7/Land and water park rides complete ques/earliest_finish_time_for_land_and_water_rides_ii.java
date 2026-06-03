package LastRun7.Land and water park rides complete ques;

public class earliest_finish_time_for_land_and_water_rides_ii {

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

    public int earliest_finish_time(int[] landStartTime, int[] landDuration, int[] waterStartTime, int[] waterDuration) {
        int land_water = solve(landStartTime, landDuration, waterStartTime, waterDuration);
        int water_land = solve(waterStartTime, waterDuration, landStartTime, landDuration);
        return Math.min(land_water, water_land);
    }

    // main method to test the code
    public static void main(String[] args) {
        earliest_finish_time_for_land_and_water_rides_ii solution = new earliest_finish_time_for_land_and_water_rides_ii();

        int[] landStart = {2, 4, 6};
        int[] landDuration = {3, 2, 1};
        int[] waterStart = {1, 5};
        int[] waterDuration = {4, 2};

        int result = solution.earliest_finish_time(landStart, landDuration, waterStart, waterDuration);
        System.out.println("Earliest Finish Time: " + result);
    }
}