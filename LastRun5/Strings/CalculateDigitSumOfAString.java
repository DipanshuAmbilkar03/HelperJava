public class CalculateDigitSumOfAString {

    public static String digitSum(String s, int k) {
        int t = s.length();
        if (t <= k) return s;

        StringBuilder ans = new StringBuilder();
        int sum = 0;

        for (int i = 0; i < t; i++) {
            sum += s.charAt(i) - '0';
            if ((i + 1) % k == 0) {
                ans.append(sum);
                sum = 0;
            }
        }

        if (t % k != 0) ans.append(sum);
        return digitSum(String.valueOf(ans), k);
    }

    public static void main(String[] args) {
        System.out.println("s = \"11111222223\", k = 3 -> " + digitSum("11111222223", 3));
        System.out.println("s = \"00000000\", k = 3 -> " + digitSum("00000000", 3));
        System.out.println("s = \"1\", k = 2 -> " + digitSum("1", 2));
        System.out.println("s = \"1234\", k = 2 -> " + digitSum("1234", 2));
        System.out.println("s = \"999999999999\", k = 3 -> " + digitSum("999999999999", 3));
        System.out.println("s = \"0000000\", k = 2 -> " + digitSum("0000000", 2));
        System.out.println("s = \"123\", k = 3 -> " + digitSum("123", 3));
        System.out.println("s = \"123456789\", k = 4 -> " + digitSum("123456789", 4));
    }
}
