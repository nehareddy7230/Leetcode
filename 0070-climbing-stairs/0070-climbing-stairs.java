class Solution {
    int[] dp;
    public int climbStairs(int n) {
        dp = new int[n+1];
        Arrays.fill(dp,-1);
       return dpclimb(n);
    }
    public int dpclimb(int n)
    {
        if(n==0 || n==1) return 1;
        if(dp[n]==-1)
        dp[n] = dpclimb(n-1) + dpclimb(n-2);
        return dp[n];
    }
}