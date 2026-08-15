import java.util.*;

public class MaximumProfitInJobScheduling {

    static class Job {
        int start, end, profit;

        Job(int start, int end, int profit) {
            this.start = start;
            this.end = end;
            this.profit = profit;
        }
    }

    public static int jobScheduling(int[] startTime, int[] endTime, int[] profit) {

        List<Job> list = new ArrayList<>();

        for (int i = 0; i < startTime.length; i++) {
            list.add(new Job(startTime[i], endTime[i], profit[i]));
        }

        Collections.sort(list, (a, b) -> {
            if (a.start == b.start) {
                return a.end - b.end;
            }
            return a.start - b.start;
        });

        PriorityQueue<int[]> pq =
                new PriorityQueue<>((a, b) -> a[0] - b[0]);

        int ans = 0;

        for (Job job : list) {

            while (!pq.isEmpty() && pq.peek()[0] <= job.start) {
                int[] curr = pq.poll();
                ans = Math.max(ans, curr[1]);
            }

            pq.offer(new int[]{job.end, job.profit + ans});
        }

        while (!pq.isEmpty()) {
            ans = Math.max(ans, pq.poll()[1]);
        }

        return ans;
    }

    public static void main(String[] args) {

        int[] startTime1 = {1, 2, 3, 3};
        int[] endTime1 = {3, 4, 5, 6};
        int[] profit1 = {50, 10, 40, 70};

        int[] startTime2 = {1, 2, 3, 4, 6};
        int[] endTime2 = {3, 5, 10, 6, 9};
        int[] profit2 = {20, 20, 100, 70, 60};

        int[] startTime3 = {1, 1, 1};
        int[] endTime3 = {2, 3, 4};
        int[] profit3 = {5, 6, 4};

        System.out.println(jobScheduling(startTime1, endTime1, profit1));
        System.out.println(jobScheduling(startTime2, endTime2, profit2));
        System.out.println(jobScheduling(startTime3, endTime3, profit3));
    }
}