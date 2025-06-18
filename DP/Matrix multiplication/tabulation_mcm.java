import Heap.priorityQueue;

public class tabulation_mcm {
    public static int mcm(int arr[]) {
        int n = arr.length;
        int dp[][] = new int[n][n];

        // initialization 
        for(int i=0; i<n; i++) {
            dp[i][i] = 0;
        }

        // bottom up filling 
        for(int len=2; len<=n-1; len++) {
            for(int i=1; i<=n-len; i++) {
                int j = i + len - 1;
                for(int k=i; k<=j-1; k++) {
                    dp[i][j] = Integer.MAX_VALUE;
                    int cost1 = dp[i][k];
                    int cost2 = dp[k+1][j-1];
                    int cost3 = arr[i-1] * arr[k] * arr[j];

                    int finalAns = cost1 + cost2 + cost3;

                    dp[i][j] = Math.min(dp[i][j],finalAns);
                }
            }
        }
        printDP(dp);
        return dp[1][n-1];
    }

    public static void printDP(int dp[][]) {
        for(int i=0; i<dp.length; i++) {
            for(int j=0; j<dp[0].length; j++) { 
                System.out.print(dp[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int arr[] = {1,2,3,4,3};
        System.out.println("Minimum cost is : "+mcm(arr));
    }
}