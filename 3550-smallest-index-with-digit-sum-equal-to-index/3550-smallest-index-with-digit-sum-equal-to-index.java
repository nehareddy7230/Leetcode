class Solution {
    public int smallestIndex(int[] nums) {
        int ans = -1;
        for(int i=0;i<nums.length;i++)
        {
            int sum = func(nums[i]);
            if(sum==i)
            {
                ans = i;
                break;
            }
        }
        return ans;
    }
    public int func(int x)
    {
        int sum=0;
        while(x>0)
        {
            int y = x%10;
            sum = sum+ y;
            x = x/10;
        }
        return sum;
    }
}