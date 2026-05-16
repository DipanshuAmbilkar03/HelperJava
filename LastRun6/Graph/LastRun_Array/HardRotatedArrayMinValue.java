package LastRun6.Graph.LastRun_Array;

public class HardRotatedArrayMinValue {

    public int findMin(int[] nums) {

        int i = 0;
        int j = nums.length - 1;

        while (i < j) {

            int mid = i + (j - i) / 2;

            // Minimum is in right half
            if (nums[mid] > nums[j]) {

                i = mid + 1;

            }
            // Minimum is in left half including mid
            else if (nums[mid] < nums[j]) {

                j = mid;

            }
            // Duplicate case
            else {

                j--;
            }
        }

        return nums[i];
    }

    public static void main(String[] args) {

        HardRotatedArrayMinValue obj = new HardRotatedArrayMinValue();

        int[] nums = {4, 5, 6, 7, 0, 1, 2};

        int ans = obj.findMin(nums);

        System.out.println("Minimum Element: " + ans);
    }
}