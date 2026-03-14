package LastRun6.Graph;

import java.util.*;

public class minNumberOfSeconds {

    static class Solution {
        private long h;
        private long[] t;
        private long ans = 0;

        public long minNumberOfSeconds(int mountainHeight, int[] workerTimes) {
            this.h = mountainHeight;

            this.t = new long[workerTimes.length];
            for (int i = 0; i < workerTimes.length; i++) {
                t[i] = workerTimes[i];
            }

            helper();
            return ans;
        }

        private void helper() {

            PriorityQueue<long[]> pq = new PriorityQueue<>(
                    (a, b) -> Long.compare(a[0], b[0])
            );

            // Initial work for each worker
            for (int i = 0; i < t.length; i++) {
                pq.add(new long[]{t[i], i, 1});
            }

            while (h > 0) {
                long[] cur = pq.poll();

                long time = cur[0];
                int worker = (int) cur[1];
                long val = cur[2];

                ans = time;
                h--;

                if (h > 0) {
                    long next = val + 1;
                    long nextTime = t[worker] * (next * (next + 1) / 2);
                    pq.add(new long[]{nextTime, worker, next});
                }
            }
        }
    }

    public static void main(String[] args) {

        int mountainHeight = 4;
        int[] workerTimes = {2, 3};

        Solution sol = new Solution();
        long result = sol.minNumberOfSeconds(mountainHeight, workerTimes);

        System.out.println("Minimum seconds required: " + result);
    }
}
