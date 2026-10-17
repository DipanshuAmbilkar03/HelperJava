public class MaxSumOfSquares {
    public static String maxSumOfSquares(int num, int sum) {
        if (sum > 9 * num) {
            return "";
        }

        int r = sum % 9;
        StringBuilder ans = new StringBuilder();
        int nines = sum / 9;

        for (int i = 0; i < nines; i++) {
            ans.append('9');
        }

        if (r > 0) {
            ans.append((char) ('0' + r));
        }
        int zeros = num - ans.length();

        for (int i = 0; i < zeros; i++) {
            ans.append('0');
        }

        return ans.toString();
    }

    public static void main(String[] args) {
        System.out.println(maxSumOfSquares(3, 27)); // "999"
        System.out.println(maxSumOfSquares(3, 10)); // "910"
        System.out.println(maxSumOfSquares(2, 0)); // "00"
        System.out.println(maxSumOfSquares(5, 10)); // "91000"
        System.out.println(maxSumOfSquares(1, 10)); // "" (sum > 9*1)
    }
}
