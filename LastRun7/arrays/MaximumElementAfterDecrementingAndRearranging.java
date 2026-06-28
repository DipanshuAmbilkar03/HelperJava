import java.util.Arrays;

public class MaximumElementAfterDecrementingAndRearranging {

    private static int method1(int[] arr) {

        Arrays.sort(arr);
        arr[0] = 1;

        int answer = arr[0];

        for (int i = 1; i < arr.length; i++) {

            if (Math.abs(arr[i] - arr[i - 1]) > 1) {
                arr[i] = decrementNumber(arr[i - 1], arr[i]);
            }

            answer = Math.max(answer, arr[i]);
        }

        return answer;
    }

    private static int method2(int[] arr) {

        int count = 0;
        int max = Integer.MIN_VALUE;

        arr[0] = 1;

        int n = arr.length;

        for (int num : arr) {
            if (num == 1) {
                count++;
            }
            max = Math.max(max, num);
        }

        return count >= 2 ? max : n;
    }

    private static int decrementNumber(int prev, int curr) {

        if (curr > prev) {
            curr = prev + 1;
        }

        return curr;
    }

    public static int maximumElementAfterDecrementingAndRearranging(int[] arr) {
        return method1(arr);
        // return method2(arr);
    }

    public static void main(String[] args) {

        int[] arr1 = {2, 2, 1, 2, 1};
        int[] arr2 = {100, 1, 1000};
        int[] arr3 = {1, 2, 3, 4, 5};
        int[] arr4 = {73, 98, 9};

        System.out.println(maximumElementAfterDecrementingAndRearranging(arr1));
        System.out.println(maximumElementAfterDecrementingAndRearranging(arr2));
        System.out.println(maximumElementAfterDecrementingAndRearranging(arr3));
        System.out.println(maximumElementAfterDecrementingAndRearranging(arr4));
    }
}