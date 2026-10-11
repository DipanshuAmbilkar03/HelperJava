public class SumOfSquaresSpecial {
    public static int sumOfSquares(int[] nums) {
        int ans = 0, n = nums.length;
        for (int i = 0; i < n; i++) {
            if (n % (i + 1) == 0) {
                ans += (nums[i] * nums[i]);
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        System.out.println(sumOfSquares(new int[]{1, 2, 3, 4})); // 21
        System.out.println(sumOfSquares(new int[]{2, 7, 1, 19, 18, 3})); // 63
        System.out.println(sumOfSquares(new int[]{5})); // 25
        System.out.println(sumOfSquares(new int[]{1, 1})); // 2
        System.out.println(sumOfSquares(new int[]{-1, -2, -3})); // 10
    }
}
