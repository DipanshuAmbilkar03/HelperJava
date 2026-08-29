import java.util.*;

public class MakeLexicographicallySmallestArrayBySwappingElements {

    public static int[] lexicographicallySmallestArray(int[] nums, int limit) {

        int n = nums.length;
        int[][] arr = new int[n][2];

        for (int i = 0; i < n; i++) {
            arr[i][0] = nums[i];
            arr[i][1] = i;
        }

        Arrays.sort(arr, (a, b) -> Integer.compare(a[0], b[0]));

        int start = 0;

        while (start < n) {

            int end = start;

            while (end + 1 < n
                    && arr[end + 1][0] - arr[end][0] <= limit) {
                end++;
            }

            int[] indices = new int[end - start + 1];

            for (int i = start; i <= end; i++) {
                indices[i - start] = arr[i][1];
            }

            Arrays.sort(indices);

            for (int i = start; i <= end; i++) {
                nums[indices[i - start]] = arr[i][0];
            }

            start = end + 1;
        }

        return nums;
    }

    public static void main(String[] args) {

        int[] nums1 = {1, 5, 3, 9, 8};
        int limit1 = 2;

        int[] nums2 = {1, 7, 6, 18, 2, 5};
        int limit2 = 3;

        int[] nums3 = {1, 3, 5, 7};
        int limit3 = 2;

        System.out.println(Arrays.toString(
                lexicographicallySmallestArray(nums1, limit1)
        ));

        System.out.println(Arrays.toString(
                lexicographicallySmallestArray(nums2, limit2)
        ));

        System.out.println(Arrays.toString(
                lexicographicallySmallestArray(nums3, limit3)
        ));
    }
}