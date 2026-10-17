import java.util.Arrays;

public class MinSwapsSortByDigitSum {
    public static int minSwaps(int[] nums) {
        int n = nums.length;
        int[] digitSum = new int[n];
        for (int i = 0; i < n; i++) {
            int x = nums[i],
                sum = 0;
            while (x > 0) {
                sum += x % 10;
                x /= 10;
            }
            digitSum[i] = sum;
        }

        Integer[] indices = new Integer[n];
        for (int i = 0; i < n; i++) {
            indices[i] = i;
        }
        Arrays.sort(indices, (a, b) -> {
            if (digitSum[a] != digitSum[b]) {
                return Integer.compare(digitSum[a], digitSum[b]);
            }
            return Integer.compare(nums[a], nums[b]);
        });

        int[] targetPos = new int[n];
        for (int pos = 0; pos < n; pos++) {
            targetPos[indices[pos]] = pos;
        }

        boolean[] visited = new boolean[n];
        int cycles = 0;
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                cycles++;
                int j = i;
                while (!visited[j]) {
                    visited[j] = true;
                    j = targetPos[j];
                }
            }
        }

        return n - cycles;
    }

    public static void main(String[] args) {
        System.out.println(minSwaps(new int[]{312, 123, 456})); // 1
        System.out.println(minSwaps(new int[]{12, 34, 56, 78})); // 0
        System.out.println(minSwaps(new int[]{18, 43, 34, 16})); // 2
        System.out.println(minSwaps(new int[]{1})); // 0
        System.out.println(minSwaps(new int[]{99, 9})); // 1
    }
}
