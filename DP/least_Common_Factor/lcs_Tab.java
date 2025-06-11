package DP.least_Common_Factor;

public class lcs_Tab {
    public static int lstcmn(String str1, String str2) {
        int n = str1.length();
        int m = str2.length();

        int[][] dp = new int[n+1][m+1];

        for(int i=0; i<n+1; i++) {
            for(int j=0; j<m+1; j++) {
                if(i==0 || j == 0 ) {
                    dp[i][j] = 0;
                }
            }
        }

        for(int i=1; i<n+1; i++) {
            for(int j=1; j<m+1; j++) {
                // same condition
                if(str1.charAt(i-1) == str2.charAt(j-1 )) {
                    dp[i][j] = dp[i-1][j-1] + 1;
                }

                // different condition
                else {
                    int up = dp[i-1][j];
                    int left = dp[i][j-1];
                    dp[i][j] = Math.max(up,left);
                }
            }
        }

        return dp[n][m];
    }
    public static void main(String[] args) {
        String str1 = "abcdge";
        String str2 = "abedg";

        int n = str1.length();
        int m = str2.length();

        System.out.println(lstcmn(str1, str2));
    }
}
