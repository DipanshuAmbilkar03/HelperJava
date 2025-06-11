package DP.least_Common_Factor;
import java.util.*;

public class editDistance {
    public static int editDis(String str1,String str2) {
        int n = str1.length();
        int m = str2.length();
        int[][] dp = new int[n+1][m+1];

        // initialization of DP 
        for(int i=0;i<n+1;i++) {
            for(int j=0;j<m+1;j++) {
                // case 1 :  i = 0
                if(i == 0) {
                    dp[i][j] = j;
                }if( j == 0 ){
                    dp[i][j] = i;
                }
            }
        }

        for(int i=1; i<n+1; i++) {
            for(int j=1; j<m+1; j++) {
                // accept case 
                if(str1.charAt(i-1) == str2.charAt(j-1)) {
                    dp[i][j] = dp[i-1][j-1];
                }

                // reject case
                else {
                    int add = dp[i][j-1] + 1;
                    int del = dp[i][j-1] + 1;
                    int rep = dp[i-1][j-1] + 1;
                
                    dp[i][j] = Math.min(add,Math.min(del, rep));
                }
            }
        }
        return dp[n][m];
    }
    public static void main(String[] args) {
        String str1 = "intention";
        String str2 = "execution";
    
        System.out.println(editDis(str1, str2));
    }
}
