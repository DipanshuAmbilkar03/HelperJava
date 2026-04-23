package LastRun8_DP;

class PartitionEqualSubsetsum {
    public static void main(String[] args) {
        int nums[] = {1,1,11,5};
        System.out.print(canPartition(nums));
    }
    public static boolean canPartition(int[] nums) {
        // int[] ans1 = new int[nums.length];
        // int[] ans2 = new int[nums.length];
        int totalsum = 0;

        for(int i: nums) {
            totalsum += i;
        }

        if(totalsum % 2 != 0) return false;
        
        int target = totalsum/2;
        boolean[] dp = new boolean[target+1];
        dp[0] = true;

        for(int num : nums) {
            for(int i=target; i>=num; i--) {
                dp[i] = dp[i] || dp[i-num];
            }
        }

        return dp[target];
    }

    // private boolean helper(int[] nums,int idx,int t,boolean[][] dp) {
    //     if(t == 0) return true;
    //     if(t<0 || idx >= nums.length)return false;

    //     boolean acpt = helper(nums,idx+1,t-nums[idx],dp);
    //     boolean reject = helper(nums,idx+1,t,dp); 

    //     return dp[idx][t] = reject || acpt;
    // }
}