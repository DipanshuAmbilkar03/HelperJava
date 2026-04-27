import java.util.*;

public class lcs {

    private int recu(int i,int j,String text1, String text2) {
        if(i < 0 || j < 0) {
            return 0;
        }

        if(text1.charAt(i) == text2.charAt(j)){
            return 1 + recu(i-1,j-1,text1,text2);
        }

        int str1 = recu(i-1,j,text1,text2);
        int str2 = recu(i,j-1,text1,text2);

        return Math.max(str1,str2);
    }

    private int memo(int i,int j,String text1, String text2,int[][] ans) {
        if(i < 0 || j < 0) {
            return 0;
        }

        if(ans[i][j] != -1) return ans[i][j];

        if(text1.charAt(i) == text2.charAt(j)){
            return ans[i][j] = 1 + memo(i-1,j-1,text1,text2,ans);
        }

        int str1 = memo(i-1,j,text1,text2,ans);
        int str2 = memo(i,j-1,text1,text2,ans);

        return ans[i][j] = Math.max(str1,str2);
    }

    private int memo2(int i,int j,String text1, String text2,int[][] ans2) {
        if(i== 0 || j == 0) {
            return 0;
        }

        if(ans2[i][j] != -1) return ans2[i][j];

        if(text1.charAt(i-1) == text2.charAt(j-1)){
            return ans2[i][j] = 1 + memo2(i-1,j-1,text1,text2,ans2);
        }

        int str1 = memo2(i-1,j,text1,text2,ans2);
        int str2 = memo2(i,j-1,text1,text2,ans2);

        return ans2[i][j] = Math.max(str1,str2);
    }

    private int tablu(int n,int m,String text1,String text2,int[][] dp) {
        for (int i=0; i<=n; i++) dp[i][0] = 0;
        for (int i=0; i<=m; i++) dp[0][i] = 0;

        for(int i=1; i<=n;i++) {
            for(int j=1; j<=m; j++) {
                if(text1.charAt(i-1) == text2.charAt(j-1)){
                    dp[i][j] = 1 + dp[i-1][j-1];
                }
                else {
                    int str1 = dp[i-1][j];
                    int str2 = dp[i][j-1];

                    dp[i][j] = Math.max(str1,str2);
                }
            }
        }

        return dp[n][m];
    }

    private int spaceOptimized(int n,int m,String text1,String text2,int[] prev,int[] curr) {
        for (int i=0; i<=m; i++) prev[i] = 0;

        for(int i=1; i<=n;i++) {
            Arrays.fill(curr, 0);  // IMPORTANT fix

            for(int j=1; j<=m; j++) {
                if(text1.charAt(i-1) == text2.charAt(j-1)){
                    curr[j] = 1 + prev[j-1];
                }
                else {
                    int str1 = prev[j];
                    int str2 = curr[j-1];

                    curr[j] = Math.max(str1,str2);
                }
            }
            System.arraycopy(curr, 0, prev, 0, m + 1);
        }

        return prev[m];
    }

    public int longestCommonSubsequence(String text1, String text2) {
        int n = text1.length();
        int m = text2.length();

        int[] prev = new int[m+1];
        int[] curr = new int[m+1];

        return spaceOptimized(n,m,text1,text2,prev,curr);
    }

    // MAIN FUNCTION
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter first string: ");
        String text1 = sc.nextLine();

        System.out.print("Enter second string: ");
        String text2 = sc.nextLine();

        lcs obj = new lcs();
        int result = obj.longestCommonSubsequence(text1, text2);

        System.out.println("LCS Length: " + result);

        sc.close();
    }
}