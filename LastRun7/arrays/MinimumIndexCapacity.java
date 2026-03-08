package LastRun7.arrays;

import java.util.*;

public class MinimumIndexCapacity {

    public static int minimumIndex(int[] capacity, int itemSize) {

        int selected = -1;
        int minCapacity = Integer.MAX_VALUE;

        for (int i = 0; i < capacity.length; i++) {

            if (capacity[i] >= itemSize) {

                if (capacity[i] < minCapacity) {
                    minCapacity = capacity[i];
                    selected = i;
                }
            }
        }

        return selected;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] capacity = new int[n];

        for (int i = 0; i < n; i++) {
            capacity[i] = sc.nextInt();
        }

        int itemSize = sc.nextInt();

        int result = minimumIndex(capacity, itemSize);

        System.out.println("Selected Index: " + result);

        sc.close();
    }
}