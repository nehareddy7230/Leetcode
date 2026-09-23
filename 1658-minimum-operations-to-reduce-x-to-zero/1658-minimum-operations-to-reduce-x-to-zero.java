class Solution {
    public int minOperations(int[] nums, int x) {
        int sum=0;
        for(int i=0;i<nums.length;i++)
        {
            sum = sum + nums[i];
        }
        int target = sum-x;
        if(target==0) return nums.length;
        if(target<0) return -1;
        int avsum = 0;
        int left = 0;
        int len = -1;
        for(int right=0;right<nums.length;right++)
        {
            avsum = avsum + nums[right];
            while(avsum>target)
            {
                avsum = avsum - nums[left];
                left++;
            }
            if(avsum==target)
            {
                len = Math.max(len,right-left+1);
            }
        }
        if(len==-1) return -1;
        return nums.length-len;
    }
}