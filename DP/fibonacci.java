package DP;

public class fibonacci {
    public static int fib(int n,int[] fibo,int c) {
        if(n == 0 || n == 1) {
            System.out.println("c => "+c);
            return n;
        }
        if(fibo[n] != 0) {
            return fibo[n];
        }
        fibo[n] = fib(n-1,fibo,c+1) + fib(n-2,fibo,c+1);
        
        return fibo[n];
    }
    public static int fibo(int n,int c) {
        if(n == 0 || n == 1) {
            System.out.println("c => "+ c);
            return n;
        }
        return fibo(n-1,c+1) + fibo(n-2,c+1);
    }
    public static int tabulation_fibo(int n) {
        int[] dp = new int[n+1];

        dp[0] = 0;
        dp[1] = 1;

        for(int i=2;i<dp.length;i++) {
            dp[i] = dp[i-1] + dp[i-2];
        }

        return dp[n];
    }
    public static void main(String[] args) {
        int n = 5;

        // 1.
        // int fibo[] = new int[n+1];
        // System.out.println(fib(n,fibo,0));

        // 2.
        // System.out.println(fibo(n,0));
        
        // 3.
        System.out.println(tabulation_fibo(n));   
    }
}
