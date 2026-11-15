class Solution {
    public int numOfSubarrays(int[] arr) {
        int mod = 1000000007;
        int even=1;
        int odd=0;
        int right = 0;
        int c = 0;
        int sum = 0;
        while(right<arr.length)
        {
            sum = (sum + arr[right])%2;
            if(sum==1)
            {
                c = (c + even)%mod;
                odd++;
            }
            else
            {
                c = (c+odd)%mod;
                even++;
            }
            right++;
        }
        return c;
    }
}