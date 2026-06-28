class Solution {
    int[] dp;
    public int fib(int n) {
        dp = new int[n+1];
        Arrays.fill(dp,-1);
       return fibno(n);
    }
    public int fibno(int n)
    {
        if(n==0 || n==1 ) return n;
        if(dp[n]==-1)
        {
            dp[n] = fibno(n-1)+fibno(n-2);
        }
        return dp[n];
    }
}