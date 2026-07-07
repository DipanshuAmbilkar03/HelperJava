package LastRun_Senior_Staff_maths;

public class SumAndMultiply {

    public static long sumAndMultiply(int n) {
        // return brute(n);
        return optimal(n);
    }

    private static long brute(int n) {

        if (n == 0) return 0;

        String num = String.valueOf(n);
        int sum = 0;
        StringBuilder newNum = new StringBuilder();

        for (char ch : num.toCharArray()) {
            int digit = ch - '0';

            if (digit > 0) {
                sum += digit;
                newNum.append(ch);
            }
        }

        return (long) sum * Long.parseLong(newNum.toString());
    }

    private static long optimal(int n) {

        int sum = 0;
        int num = 0;
        int place = 1;

        while (n > 0) {

            int digit = n % 10;
            n /= 10;

            if (digit == 0) continue;

            sum += digit;
            num += digit * place;
            place *= 10;
        }

        return (long) sum * num;
    }

    public static void main(String[] args) {

        int[] testCases = {
                0,
                105,
                1234,
                1002,
                908070,
                9999
        };

        for (int n : testCases) {
            System.out.println("n = " + n + " -> " + sumAndMultiply(n));
        }
    }
}