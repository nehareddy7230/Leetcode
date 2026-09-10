class Solution {
    public int numOfSubarrays(int[] arr, int k, int threshold) {
        int sum = 0;
        int c=0;
        for(int i=0;i<k;i++)
        {
            sum = sum + arr[i];
        }
        double avg = sum/k;
        if(avg>=threshold)
        {
            c++;
        }
        for(int i=k;i<arr.length;i++)
        {
            sum = sum - arr[i-k];
            sum = sum + arr[i];
            avg = sum/k;
            if(avg>=threshold)
        {
            c++;
        }
        }
        return c;
    }
}