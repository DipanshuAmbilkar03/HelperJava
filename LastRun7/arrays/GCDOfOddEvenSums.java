package LastRun7.arrays;

public class GCDOfOddEvenSums {

    public static int gcdOfOddEvenSums(int n) {
        return n;

        // return method(n);
    }

    private static int method(int n) {

        int sumOdd = n * n;
        int sumEven = n * (n + 1);

        while (sumOdd != 0) {
            int temp = sumEven % sumOdd;
            sumEven = sumOdd;
            sumOdd = temp;
        }

        return sumEven;
    }

    public static void main(String[] args) {

        int[] testCases = {1, 2, 3, 5, 10, 100};

        for (int n : testCases) {
            System.out.println("n = " + n + " -> " + gcdOfOddEvenSums(n));
        }
    }
}