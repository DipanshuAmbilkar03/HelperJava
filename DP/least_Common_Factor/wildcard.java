package DP.least_Common_Factor;
public class wildcard {
    public static boolean isMatch(String s,String p) {
        int n = s.length();
        int m = p.length();
        boolean dp[][] = new boolean[n+1][m+1];

        // initialization
        dp[0][0] = true;

        // p = " "
        for(int i=1; i<n+1; i++) {
            dp[i][0] = false;
        }

        // s = " "
        for(int j=1; j<m+1; j++) {
            if(p.charAt(j-1) == '*') {
                dp[0][j] = dp[0][j-1];
            }
        }

        // bottoms up 

        for(int i=1; i<n+1; i++) {
            for(int j=1; j<m+1; j++) {
                //case1 => ith char == jth char || ith char == "?"
                if(s.charAt(i-1) == p.charAt(j-1) || s.charAt(i-1) == '?' ){
                    dp[i][j] = dp[i-1][j-1];
                }
                // case 2 => jth char == '*' can replaced by ith char of s -> dp[i][j-1]
                            //  jth char == '*' will be saved to match the i-1th char of s -> dp[i-1][j]
                else if(p.charAt(j-1) == '*') {
                    dp[i][j] = dp[i][j-1] || dp[i-1][j];    
                }
                else {
                    dp[i][j] = false;
                }
            }
        }

        return dp[n][m];
    }
    public static void main(String[] args) {
        String s = "baaabab";
        String p = "???????";

        System.out.println(isMatch(s, p));
    }
}
