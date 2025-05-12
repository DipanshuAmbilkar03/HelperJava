public class climbingStairs {
    public static int stairs(int n) {
        if(n == 0) {
            return 1;
        }

        if(n < 0) {
            return 0;
        }

        return stairs(n-1) + stairs(n-2);
    }
    public static void main(String[] args) {
        int n = 5;
        System.out.println(stairs(n));
    }
}
