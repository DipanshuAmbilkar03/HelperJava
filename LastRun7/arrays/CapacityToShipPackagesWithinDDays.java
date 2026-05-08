public class CapacityToShipPackagesWithinDDays {

    // Function to calculate required days for a given capacity
    private static int load(int[] weights, int cap) {
        int currentLoad = 0;
        int days = 1;

        for (int i = 0; i < weights.length; i++) {

            // If adding current package exceeds capacity
            if (weights[i] + currentLoad > cap) {
                days++;
                currentLoad = weights[i];
            } else {
                currentLoad += weights[i];
            }
        }

        return days;
    }

    // Main function to find minimum ship capacity
    public static int shipWithinDays(int[] weights, int days) {

        int low = 0;
        int high = 0;

        // Find search space
        for (int w : weights) {
            high += w;              // maximum possible capacity
            low = Math.max(low, w); // minimum possible capacity
        }

        // Binary Search
        while (low <= high) {

            int mid = low + (high - low) / 2;

            int requiredDays = load(weights, mid);

            // If possible within given days
            if (requiredDays <= days) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return low;
    }

    // Main Method
    public static void main(String[] args) {

        int[] weights = {1,2,3,4,5,6,7,8,9,10};
        int days = 5;

        int result = shipWithinDays(weights, days);

        System.out.println("Minimum Capacity Required: " + result);
    }
}