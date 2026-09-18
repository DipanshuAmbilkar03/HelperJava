import java.util.HashMap;
import java.util.Map;
import java.util.Arrays;

public class SortColors {

    private static void solution1(int[] nums) {

        Map<Integer, Integer> map = new HashMap<>();

        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        int idx = 0;

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {

            int freq = entry.getValue();

            for (int i = 0; i < freq; i++) {
                nums[idx++] = entry.getKey();
            }
        }
    }

    private static void solution2(int[] nums) {

        int n = nums.length;
        int[] arr = new int[n];

        int i = 0;
        int j = n - 1;

        for (int idx = 0; idx < n; idx++) {

            if (nums[idx] == 0) {
                arr[i++] = 0;
            } else if (nums[idx] == 2) {
                arr[j--] = 2;
            }
        }

        for (int idx = i; idx <= j; idx++) {
            arr[idx] = 1;
        }

        System.arraycopy(arr, 0, nums, 0, n);
    }

    public static void sortColors(int[] nums) {

        int low = 0;
        int mid = 0;
        int high = nums.length - 1;

        while (mid <= high) {

            if (nums[mid] == 0) {

                int temp = nums[low];
                nums[low++] = nums[mid];
                nums[mid++] = temp;

            } else if (nums[mid] == 1) {

                mid++;

            } else {

                int temp = nums[mid];
                nums[mid] = nums[high];
                nums[high--] = temp;
            }
        }
    }

    public static void main(String[] args) {

        int[][] testCases = {
                {2, 0, 2, 1, 1, 0},
                {2, 0, 1},
                {0},
                {1},
                {2},
                {2, 2, 1, 1, 0, 0},
                {1, 2, 0, 1, 2, 0}
        };

        for (int[] nums : testCases) {

            System.out.println("Before: " + Arrays.toString(nums));

            sortColors(nums);

            System.out.println("After : " + Arrays.toString(nums));
            System.out.println();
        }
    }
}