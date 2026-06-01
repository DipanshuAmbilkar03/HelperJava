import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Comparator;

public class MinimumCostOfBuyingCandiesWithDiscount {

    public int minimumCost(int[] cost) {
        int n = cost.length;

        // Choose either solution
        // return sol1(n, cost);
        return sol2(n, cost);
    }

    // Sorting Approach
    private int sol1(int n, int[] cost) {
        Arrays.sort(cost);

        int total = 0;
        int takeCandy = 0;

        for (int i = n - 1; i >= 0; i--) {
            if (takeCandy == 2) {
                takeCandy = 0; // third candy is free
            } else {
                total += cost[i];
                takeCandy++;
            }
        }

        return total;
    }

    // Max Heap Approach
    private int sol2(int n, int[] cost) {
        PriorityQueue<Integer> pq =
                new PriorityQueue<>(Comparator.reverseOrder());

        for (int candy : cost) {
            pq.add(candy);
        }

        int total = 0;

        while (!pq.isEmpty()) {
            int largest = pq.poll();

            int secondLargest = 0;
            if (!pq.isEmpty()) {
                secondLargest = pq.poll();
            }

            // Third candy is free
            if (!pq.isEmpty()) {
                pq.poll();
            }

            total += largest + secondLargest;
        }

        return total;
    }

    public static void main(String[] args) {
        MinimumCostOfBuyingCandiesWithDiscount solution =
                new MinimumCostOfBuyingCandiesWithDiscount();

        int[] cost1 = {1, 2, 3};
        int[] cost2 = {6, 5, 7, 9, 2, 2};
        int[] cost3 = {5, 5};

        System.out.println("Minimum Cost: " + solution.minimumCost(cost1));
        System.out.println("Minimum Cost: " + solution.minimumCost(cost2));
        System.out.println("Minimum Cost: " + solution.minimumCost(cost3));
    }
}