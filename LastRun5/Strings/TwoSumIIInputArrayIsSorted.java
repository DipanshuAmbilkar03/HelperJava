import java.util.Arrays;

public class TwoSumIIInputArrayIsSorted {

    public static int[] twoSum(int[] numbers, int target) {
        int left = 0;
        int right = numbers.length - 1;

        while (left < right) {
            int sum = numbers[left] + numbers[right];
            if (sum == target) return new int[]{left + 1, right + 1};

            if (sum < target) {
                left++;
            } else {
                right--;
            }
        }

        return new int[]{-1, -1};
    }

    public static void main(String[] args) {
        int[] numbers1 = {2, 7, 11, 15};
        System.out.println("numbers = [2,7,11,15], target = 9 -> "
                + Arrays.toString(twoSum(numbers1, 9)));

        int[] numbers2 = {2, 3, 4};
        System.out.println("numbers = [2,3,4], target = 6 -> "
                + Arrays.toString(twoSum(numbers2, 6)));

        int[] numbers3 = {-1, 0};
        System.out.println("numbers = [-1,0], target = -1 -> "
                + Arrays.toString(twoSum(numbers3, -1)));

        int[] numbers4 = {1, 2, 3, 4, 4, 9, 56, 90};
        System.out.println("numbers = [1,2,3,4,4,9,56,90], target = 8 -> "
                + Arrays.toString(twoSum(numbers4, 8)));

        int[] numbers5 = {5, 25, 75};
        System.out.println("numbers = [5,25,75], target = 100 -> "
                + Arrays.toString(twoSum(numbers5, 100)));

        int[] numbers6 = {-10, -5, 0, 3, 7};
        System.out.println("numbers = [-10,-5,0,3,7], target = 3 -> "
                + Arrays.toString(twoSum(numbers6, 3)));

        int[] numbers7 = {1, 3};
        System.out.println("numbers = [1,3], target = 100 -> "
                + Arrays.toString(twoSum(numbers7, 100)));
    }
}
