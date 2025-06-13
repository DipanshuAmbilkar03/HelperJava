package DP.least_Common_Factor;

public class stringConversion {
    public static int lcs(String str1,String str2,int n,int m,int[][] dp) {
        if(n==0 || m==0) {
            return 0;
        }

        if(dp[n][m] != -1) {
            return dp[n][m];
        }

        if(str1.charAt(n-1) == str2.charAt(m-1)) {
            return dp[n][m] = lcs(str1, str2, n-1, m-1,dp)  + 1;
        }else {
            int ans1 = lcs(str1, str2, n-1, m,dp);
            int ans2 = lcs(str1, str2, n, m-1,dp);

            int finalLen = Math.max(ans1, ans2);

            return dp[n][m] = finalLen;
        }
    } 
    public static int strConvert(String str1,String str2,int n,int m,int[][] dp) {
        // lcs length  
        int leng1 = lcs(str1, str2, n, m, dp);
        
        // insertion
        int insertion = n - leng1;

        // deletion
        int deletion = m - leng1;

        return insertion+deletion;
    }

    public static void main(String[] args) {
        String str1 = "abcdef";
        String str2 = "aceg";

        int n = str1.length();
        int m = str2.length();

        int[][] dp = new int[n+1][m+1];

        for(int i=0; i<n+1; i++) {
            for(int j=0; j<m+1; j++) {
                dp[i][j] = -1;
            }
        }

        System.out.println("Steps to convert "+str1+" to "+str2+" is : "+strConvert(str1, str2, n, m, dp));
    }
}
