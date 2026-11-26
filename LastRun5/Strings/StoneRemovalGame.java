public class StoneRemovalGame {

    private static boolean solve(int n, int stones) {
        if (n < stones) return false;

        return !solve(n - stones, stones - 1);
    }

    public static boolean canAliceWin(int n) {
        return solve(n, 10);
    }

    public static void main(String[] args) {
        int[] testCases = {12, 1, 10, 9, 19, 20, 11, 30, 45, 50};

        for (int n : testCases) {
            System.out.println("n = " + n + " -> " + canAliceWin(n));
        }
    }
}
