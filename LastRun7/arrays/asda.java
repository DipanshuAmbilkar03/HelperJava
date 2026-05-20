package LastRun7.arrays;

import java.util.*;

class FindThePrefixCommonArrayOfTwoArrays {

    private int count = 0;

    private int[] check(int[] a, int[] b) {

        Set<Integer> map = new HashSet<>();

        int[] ans = new int[a.length];

        for (int i = 0; i < a.length; i++) {

            if (!map.contains(a[i])) {
                map.add(a[i]);
            } else {
                count++;
            }

            if (!map.contains(b[i])) {
                map.add(b[i]);
            } else {
                count++;
            }

            ans[i] = count;
        }

        return ans;
    }

    public int[] findThePrefixCommonArray(int[] A, int[] B) {

        return check(A, B);
    }

    public static void main(String[] args) {

        FindThePrefixCommonArrayOfTwoArrays obj =
                new FindThePrefixCommonArrayOfTwoArrays();

        int[] A = {1, 3, 2, 4};
        int[] B = {3, 1, 2, 4};

        int[] result = obj.findThePrefixCommonArray(A, B);

        System.out.println("Prefix Common Array:");

        for (int num : result) {
            System.out.print(num + " ");
        }
    }
}