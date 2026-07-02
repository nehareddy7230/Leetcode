class Solution {
    public int longestSubarray(int[] nums) {
        int left =0;
        int right = 0;
        int ans = 0;
        int zc = 0;
        while(right<nums.length)
        {
            if(nums[right]==1)
            {
                ans = Math.max(ans,right-left+1);
            }
            else
            {
                zc++;
                while(zc>1)
                {
                    if(nums[left]==0)
                    {
                        zc--;
                    }
                    left++;
                }
            ans = Math.max(ans,right-left+1);
            }
            right++;
        }
        return ans-1;
    }
}