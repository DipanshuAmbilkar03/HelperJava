package LastRun_Senior_Staff_maths;
import java.util.*;

public class SequentialDigits {

    public static List<Integer> sequentialDigits(int low, int high) {
        return method2(low, high);
        // return method1(low, high);
    }

    private static List<Integer> method2(int low, int high) {

        List<Integer> ans = new ArrayList<>();

        for (int i = 1; i <= 9; i++) {

            int num = i;
            int nextDigit = i + 1;

            while (num <= high && nextDigit <= 9) {

                num = num * 10 + nextDigit;

                if (num >= low && num <= high) {
                    ans.add(num);
                }

                nextDigit++;
            }
        }

        Collections.sort(ans);
        return ans;
    }

    private static List<Integer> method1(int low, int high) {

        String digits = "123456789";
        List<Integer> ans = new ArrayList<>();

        int minLength = String.valueOf(low).length();
        int maxLength = String.valueOf(high).length();

        for (int len = minLength; len <= maxLength; len++) {

            for (int start = 0; start + len <= 9; start++) {

                int num = Integer.parseInt(digits.substring(start, start + len));

                if (num >= low && num <= high) {
                    ans.add(num);
                }
            }
        }

        return ans;
    }

    public static void main(String[] args) {

        System.out.println(sequentialDigits(100, 300));
        System.out.println(sequentialDigits(1000, 13000));
        System.out.println(sequentialDigits(10, 1000000));
    }
}