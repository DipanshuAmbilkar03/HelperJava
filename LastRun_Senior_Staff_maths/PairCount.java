public class PairCount {

    private static int gcd(int x, int y) {
        while (y != 0) {
            int temp = y;
            y = x % y;
            x = temp;
        }
        return x;
    }

    private static int lcm(int x, int y) {
        return (x / gcd(x, y)) * y;
    }

    private static int solution1(int x, int y) {

        int count = 0;

        for (int i = x; i <= y; i++) {
            for (int j = i; j <= y; j++) {

                if (gcd(i, j) == x && lcm(i, j) == y) {
                    if (i == j) {
                        count++;
                    } else {
                        count += 2;
                    }
                }
            }
        }

        return count;
    }

    private static int solution2(int x, int y) {

        if (y % x != 0) {
            return 0;
        }

        int n = y / x;
        int count = 0;

        for (int i = 1; i * i <= n; i++) {

            if (n % i == 0) {

                int j = n / i;

                if (gcd(i, j) == 1) {
                    if (i == j) {
                        count++;
                    } else {
                        count += 2;
                    }
                }
            }
        }

        return count;
    }

    public static int pairCount(int x, int y) {
        return solution2(x, y);
    }

    public static void main(String[] args) {

        int[][] testCases = {
                {1, 6},
                {2, 12},
                {3, 12},
                {4, 20},
                {5, 5},
                {6, 18},
                {10, 30},
                {7, 21}
        };

        for (int[] test : testCases) {

            int x = test[0];
            int y = test[1];

            System.out.println(
                    "x = " + x +
                    ", y = " + y +
                    " -> " + pairCount(x, y)
            );
        }
    }
}