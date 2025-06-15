// package DP.Catalan Number;

import java.util.Arrays;

public class memoization_catalan {
    public static int catalanNum(int n,int[] dp) {
        if(n == 0 || n == 1) {
            return 1;
        }

        if(dp[n] != -1){ 
            return dp[n];
        }

        int ans = 0;

        for(int i=0; i<=n-1 ; i++) {
            ans += catalanNum(i,dp) * catalanNum(n-i-1,dp);
        }
        // System.out.println(ans);

    
    return dp[n] = ans;
    }
    public static void main(String[] args) {
        int n = 30;

        int[] dp = new int[n+1];
        // for(int i=0; i<n; i++) {
        //     dp[i] = -1;
        // }

        // alternate method to fill array -> Arrays.fill
        Arrays.fill(dp, -1);

        System.out.println("Catalan number is : "+catalanNum(n,dp));
    }
}
