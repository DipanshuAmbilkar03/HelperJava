// package DP.Catalan.Number.Recursive_catalan;

public class Recursive_catalan {
    public static int catalanNum(int n) {
        if(n == 0 || n == 1) {
            return 1;
        }
        int ans = 0;

        for(int i=0; i<=n-1 ; i++) {
            ans += catalanNum(i) * catalanNum(n-i-1);
        }
        System.out.println(ans);

    
    return ans;
    }
    public static void main(String[] args) {
        int n = 3;

        System.out.println("Catalan number is : "+catalanNum(n));
    }
}
