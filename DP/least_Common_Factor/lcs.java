package DP.least_Common_Factor;

public class lcs {
    public static int lstcmn(String str1,String str2,int n,int m) {
        if(n==0 || m==0) {
            return 0;
        }

        if(str1.charAt(n-1) == str2.charAt(m-1)) {
            return lstcmn(str1, str2, n-1, m-1)  + 1;
        }else {
            int ans1 = lstcmn(str1, str2, n-1, m);
            int ans2 = lstcmn(str1, str2, n, m-1);

            int finalLen = Math.max(ans1, ans2);

            return finalLen;
        }
    } 
    public static void main(String[] args) {
        String str1 = "abcdge";
        String str2 = "abedg";

        int n = str1.length();
        int m = str2.length();

        System.out.println(lstcmn(str1, str2, n, m));
    }    
}
