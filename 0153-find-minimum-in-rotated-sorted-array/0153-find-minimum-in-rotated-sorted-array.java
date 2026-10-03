class Solution {
    int ans = Integer.MAX_VALUE;
    public int findMin(int[] nums) {
        bs(nums);
        return ans;
    }
    public void bs(int[] nums)
    {
        int low = 0;
        int high = nums.length-1;
        while(low<=high)
        {
        int mid = low+(high-low)/2;
        if(nums[mid]>nums[high])
        {
            low = mid+1;
        }
        else
        {
            high = mid  - 1;
        }
        ans = Math.min(ans,nums[mid]);
        }
    }
}