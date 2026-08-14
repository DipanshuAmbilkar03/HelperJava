import java.util.*;

public class MinimumPlatforms {

    static class Train {
        int start, end;

        Train(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }

    public static int minPlatform(int[] arr, int[] dep) {

        List<Train> list = new ArrayList<>();

        for (int i = 0; i < arr.length; i++) {
            list.add(new Train(arr[i], dep[i]));
        }

        Collections.sort(list, (a, b) -> {
            if (a.start == b.start) {
                return a.end - b.end;
            }
            return a.start - b.start;
        });

        int totalPlatforms = 0;

        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (Train train : list) {

            while (!pq.isEmpty() && pq.peek() < train.start) {
                pq.poll();
            }

            pq.offer(train.end);

            totalPlatforms = Math.max(totalPlatforms, pq.size());
        }

        return totalPlatforms;
    }

    public static void main(String[] args) {

        int[] arr1 = {900, 940, 950, 1100, 1500, 1800};
        int[] dep1 = {910, 1200, 1120, 1130, 1900, 2000};

        int[] arr2 = {900, 940};
        int[] dep2 = {910, 1200};

        int[] arr3 = {100, 200, 300};
        int[] dep3 = {400, 500, 600};

        System.out.println(minPlatform(arr1, dep1));
        System.out.println(minPlatform(arr2, dep2));
        System.out.println(minPlatform(arr3, dep3));
    }
}