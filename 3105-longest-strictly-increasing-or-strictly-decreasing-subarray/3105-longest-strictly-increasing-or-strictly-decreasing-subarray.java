class Solution {
    public int longestMonotonicSubarray(int[] nums) {
        int len = 0;
        int ptr1 = 0;
        int ptr2=0;
        while(ptr1<nums.length && ptr2<nums.length)
        {
            if(ptr1==ptr2)
            {
                len = Math.max(len,1);
                ptr2++;
            }
            else if(nums[ptr2-1]<nums[ptr2])
            {
                len = Math.max(len,ptr2-ptr1+1);
                ptr2++;
            }
            else
            {
                ptr1++;
            }
        }
        ptr1 = 0;
        ptr2=0;
        while(ptr1<nums.length && ptr2<nums.length)
        {
            if(ptr1==ptr2)
            {
                len = Math.max(len,1);
                ptr2++;
            }
            else if(nums[ptr2-1]>nums[ptr2])
            {
                len = Math.max(len,ptr2-ptr1+1);
                ptr2++;
            }
            else
            {
                ptr1++;
            }
        }
        return len;
    }
}