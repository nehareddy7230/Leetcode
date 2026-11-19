class Solution {
    public int minimizeSum(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        int val1 = nums[n-1] - nums[2];
        int val2 = nums[n-2] - nums[1];
        int val3 = nums[n-3] - nums[0];
        return Math.min(val1,Math.min(val2,val3));
    }
}