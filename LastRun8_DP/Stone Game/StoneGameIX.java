import java.util.*;

public class StoneGameIX {

    public static boolean stoneGameIX(int[] stones) {

        int[] count = new int[3];

        for (int x : stones) {
            count[((x % 3) + 3) % 3]++;
        }

        if (count[0] % 2 == 0) {
            return count[1] > 0 && count[2] > 0;
        }

        return Math.abs(count[1] - count[2]) > 2;
    }

    private static boolean solve(int[] arr, boolean[] used, int sum, boolean alice) {

        boolean found = false;

        for (int i = 0; i < arr.length; i++) {

            if (used[i]) continue;

            used[i] = true;
            found = true;

            int nextSum = (sum + arr[i]) % 3;

            if (nextSum < 0) {
                nextSum += 3;
            }

            boolean win;

            if (nextSum == 0) {
                win = !alice;
            } else {
                win = solve(arr, used, nextSum, !alice);
            }

            used[i] = false;

            if (alice && win) {
                return true;
            }

            if (!alice && !win) {
                return false;
            }
        }

        return found ? !alice : false;
    }

    public static void main(String[] args) {

        int[] stones1 = {2, 1};
        int[] stones2 = {2, 1, 3};
        int[] stones3 = {5, 1, 2, 4, 3};
        int[] stones4 = {1, 1, 1, 1};
        int[] stones5 = {1, 2, 3, 4, 5, 6};

        System.out.println(stoneGameIX(stones1));
        System.out.println(stoneGameIX(stones2));
        System.out.println(stoneGameIX(stones3));
        System.out.println(stoneGameIX(stones4));
        System.out.println(stoneGameIX(stones5));
    }
}