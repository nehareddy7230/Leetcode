class Solution 
{
    int[] dp;
    public int climbStairs(int n, int[] costs) 
    {
        dp = new int[n+1];
        Arrays.fill(dp,-1);
        return climb(n,costs);
    }
    public int climb(int n,int[] costs)
    {
       if(n<=0) return 0;
        if(dp[n]==-1)
        {
        int first = climb(n-1,costs) + costs[n-1] + 1*1;
        int second = climb(n-2,costs) + costs[n-1] + 2*2;
        int third = climb(n-3,costs) + costs[n-1] + 3*3;
        dp[n] = Math.min(first,Math.min(second,third));
        }
        return dp[n];
    }
}