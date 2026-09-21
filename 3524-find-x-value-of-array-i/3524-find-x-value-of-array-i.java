class Solution {
    public long[] resultArray(int[] nums, int k) {

        long[] dp = new long[k];
        long[] ans = new long[k];

        for (int num : nums) {

            long[] newDp = new long[k];

            // Start a new subarray
            int val = num % k;
            newDp[val]++;

            // Extend previous subarrays
            for (int r = 0; r < k; r++) {
                int newRemainder = (r * val) % k;
                newDp[newRemainder] += dp[r];
            }
            for (int r = 0; r < k; r++) {
                ans[r] += newDp[r];
            }

            dp = newDp;
        }

        return ans;
    }
}