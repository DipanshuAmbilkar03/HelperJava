import java.util.Arrays;

class PartitionArrayAccordingtoGivenPivot {
    public int[] pivotArray(int[] nums, int pivot) {
        int n = nums.length;
        int[] ans = new int[n];
        int left = 0;
        int right = n - 1;

        // Place elements < pivot on left and > pivot on right
        for (int i = 0, j = n - 1; i < n; i++, j--) {
            if (nums[i] < pivot) ans[left++] = nums[i];
            if (nums[j] > pivot) ans[right--] = nums[j];
        }

        // Fill remaining positions with pivot
        while (left <= right) {
            ans[left++] = pivot;
        }

        return ans;
    }

    public static void main(String[] args) {
        Nam solution = new Nam();

        int[] nums = {9, 12, 5, 10, 14, 3, 10};
        int pivot = 10;

        int[] result = solution.pivotArray(nums, pivot);

        System.out.println("Original array: " + Arrays.toString(nums));
        System.out.println("Pivoted array:  " + Arrays.toString(result));
    }
}