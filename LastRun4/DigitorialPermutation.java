package LastRun4;
import java.util.*;

public class DigitorialPermutation {

    // Factorial (recursive)
    private static int permutation(int n) {
        if (n == 0 || n == 1) return 1;
        return permutation(n - 1) * n;
    }

    public static boolean isDigitorialPermutation(int n) {

        int original = n;
        int ans = 0;

        // Sum of factorial of digits
        while (n > 0) {
            ans += permutation(n % 10);
            n = n / 10;
        }

        // Sort digits of factorial sum
        char[] arr1 = Long.toString(ans).toCharArray();
        Arrays.sort(arr1);
        String sorted1 = new String(arr1);

        // Sort digits of original number
        char[] arr2 = Long.toString(original).toCharArray();
        Arrays.sort(arr2);
        String sorted2 = new String(arr2);

        return sorted1.equals(sorted2);
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        boolean result = isDigitorialPermutation(n);

        System.out.println("Is Digitorial Permutation? " + result);

        sc.close();
    }
}