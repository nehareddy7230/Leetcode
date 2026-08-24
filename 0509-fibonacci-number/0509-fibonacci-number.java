class Solution {
    int[] dp;
    public int fib(int n) {
        dp = new int[n+1];
        Arrays.fill(dp,-1);
        return fib1(n);
    }
    public int fib1(int n)
    {
        if(n<=1)
        {
            return n;
        }
        if(dp[n]==-1)
        {

        dp[n] = fib1(n-1)+fib1(n-2);
        }
        return dp[n];
    }
}