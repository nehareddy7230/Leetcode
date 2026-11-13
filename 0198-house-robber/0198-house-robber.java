class Solution {
    int max;
    public int rob(int[] nums) 
    {
        int[] dp = new int[nums.length+1];
        Arrays.fill(dp,-1);
        /*max = Integer.MIN_VALUE;
        func(nums,0,0);
        return max;*/
       return func(nums,dp,0);

    }
    public int func(int[] nums,int[] dp,int idx)
    {
        /*if(idx>=nums.length) return;
        sum = sum + nums[idx];
        max = Math.max(max,sum);
        func(nums,sum,idx+2);
        func(nums,sum,idx+1);*/
        if(idx>=nums.length) return 0;
        if(dp[idx]!=-1)
        {
            return dp[idx];
        }
        int rob = nums[idx] + func(nums,dp,idx+2);
        int skip = func(nums,dp,idx+1);
        dp[idx] = Math.max(rob,skip);
        return dp[idx];
    }
}