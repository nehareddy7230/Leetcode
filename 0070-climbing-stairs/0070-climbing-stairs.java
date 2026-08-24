class Solution {
    int[] dp;
    public int climbStairs(int n) 
    {
        dp = new int[n+1];
        Arrays.fill(dp,-1);
        return climb(n);
    }
    public int climb(int n)
    {
        if(n<=1) return 1;
        if(dp[n]==-1)
        dp[n]= climb(n-1)+climb(n-2);
        return dp[n];
    }
}