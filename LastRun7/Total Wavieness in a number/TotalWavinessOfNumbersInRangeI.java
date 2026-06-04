public class TotalWavinessOfNumbersInRangeI {

    private int check(int n) {
        char[] arr = String.valueOf(n).toCharArray();
        int count = 0;

        for (int i = 1; i < arr.length - 1; i++) {
            int l = arr[i - 1] - '0';
            int curr = arr[i] - '0';
            int r = arr[i + 1] - '0';

            if ((curr > l && curr > r) ||
                (curr < l && curr < r)) {
                count++;
            }
        }

        return count;
    }

    public int totalWaviness(int num1, int num2) {
        int total = 0;

        for (int i = num1; i <= num2; i++) {
            total += check(i);
        }

        return total;
    }

    public static void main(String[] args) {
        TotalWavinessOfNumbersInRangeI sol =
                new TotalWavinessOfNumbersInRangeI();

        System.out.println(sol.totalWaviness(120, 130));  // 3
        System.out.println(sol.totalWaviness(198, 202));  // 3
        System.out.println(sol.totalWaviness(4848, 4848)); // 2
    }
}