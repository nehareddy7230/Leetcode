class Solution {
    public int[] sortedSquares(int[] nums) {
        int ptr1 = 0;
        int ptr2 = nums.length-1;
        int[] arr = new int[nums.length];
        int idx = nums.length-1;
        while(ptr1<=ptr2)
        {
            if(nums[ptr1]*nums[ptr1]<nums[ptr2]*nums[ptr2])
            {
                arr[idx] =  nums[ptr2]*nums[ptr2];
                ptr2--;
            }
            else
            {
                arr[idx] = nums[ptr1]*nums[ptr1];
                ptr1++;
            }
            idx--;
        }
        return arr;
    }
}