class Solution {
    int[] dp ;
    public int minCostClimbingStairs(int[] cost) {
        dp = new int[cost.length+1];
        Arrays.fill(dp,-1);
        return min(cost.length,cost);
    }
    public int min(int n,int[] cost)
    {
       if(n<=1) return 0;
       if(dp[n]==-1)
       {
         dp[n] = Math.min(min(n-1,cost)+cost[n-1],min(n-2,cost)+cost[n-2]);
       }
       return dp[n];
    }

}