// package DP.Catalan Number;

// logic behind CountBST and catalan number is exactly same 

public class CountBST {
    public static int catalanNum(int n) {
        int dp[] = new int[n+1];

        dp[0] = 1;
        dp[1] = 1;

        for(int i=2; i<=n;i++) {
            for(int j=0; j<i; j++) {
                // variable are only changed here left and right added in catalan code 
                int left = dp[j];
                int right = dp[i-j-1];
                dp[i] += left * right;
            }
        }

        return dp[n];
    }
    public static void main(String[] args) {
        int n = 4;

        System.out.println("Catalan number is : "+catalanNum(n));
    }
}
