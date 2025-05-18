public class knap_tabulation {
    // tabulation using iteration
    public static int knap(int[] val,int[] wt,int w) {
        int n = val.length;
        int dp[][] = new int[n+1][w+1];

        // initialization of 0th row as every value be 0
        for(int i=0; i<dp.length;i++) {
            dp[i][0] = 0;
        }

        // initialization of 0th coloum as every value be 0
        for(int j=0; j<dp[0].length;j++) {
            dp[0][j] = 0;
        }

        for(int i=1;i<n+1;i++) {
            for(int j=1;j<w+1;j++) {
                int v = val[i-1]; // ith item value
                int W = wt[i-1];  // ith item weight

                if(W <= j) { // valid 
                // include the value
                    int includeProfit = v + dp[i-1][j-W];
                    // exclude the value
                    int excludeProfit = dp[i-1][j];

                    dp[i][j] = Math.max(includeProfit, excludeProfit);
                }else {
                    // invalid 
                    int excludeProfit = dp[i-1][j];
                    dp[i][j] = excludeProfit;
                }
            }
        }
        return dp[n][w];
    }   

    public static void main(String[] args) {
        int[] val = {15,14,10,45,30};
        int[] wt = {2,5,1,3,4};
        int w = 7;
    
        System.out.println("Maximum value obtained from knapSack is (tabulation): "+knap(val, wt, w));
    }
}
