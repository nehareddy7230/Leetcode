class Solution {
    public int[] getAverages(int[] nums, int k) {
        int[] arr = new int[nums.length];
        Arrays.fill(arr,-1);
        if(2*k+1>nums.length) return arr;
        long sum = 0;
        for(int i=0;i<=k+k;i++)
        {
            sum = sum + nums[i];
        }
            arr[k] = (int)(sum /((2*k)+1));
        for(int i=k+1;i<nums.length-k;i++)
        {
            sum = sum - nums[i-k-1];
            sum = sum + nums[i+k];
            arr[i] = (int)(sum /((2*k)+1));
        }
        return arr;
    }
}