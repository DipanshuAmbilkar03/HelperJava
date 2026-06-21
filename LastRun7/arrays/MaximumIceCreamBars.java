import java.util.Arrays;

public class MaximumIceCreamBars {

    public static int maxIceCream(int[] costs, int coins) {
        Arrays.sort(costs);

        int iceCreams = 0;
        int sum = 0;

        for (int cost : costs) {
            sum += cost;

            if (sum > coins) {
                return iceCreams;
            }

            iceCreams++;
        }

        return iceCreams;
    }

    public static void main(String[] args) {

        int[] costs1 = {1, 3, 2, 4, 1};
        int coins1 = 7;

        int[] costs2 = {10, 6, 8, 7, 7, 8};
        int coins2 = 5;

        int[] costs3 = {1, 6, 3, 1, 2, 5};
        int coins3 = 20;

        System.out.println(maxIceCream(costs1, coins1)); // 4
        System.out.println(maxIceCream(costs2, coins2)); // 0
        System.out.println(maxIceCream(costs3, coins3)); // 6
    }
}