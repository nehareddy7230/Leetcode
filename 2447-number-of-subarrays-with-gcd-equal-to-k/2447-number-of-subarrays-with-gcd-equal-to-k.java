class Solution {
    public int subarrayGCD(int[] nums, int k) {
        int c=0;
        for(int i=0;i<nums.length;i++)
        {
            int g=0;
            for(int j=i;j<nums.length;j++)
            {
                g = gcd(g,nums[j]);
                if(g==k)
                {
                    c++;
                }
                if(g<k)
                {
                    break;
                }
            }
        }
        return c;
    }
    public int gcd(int x,int y)
    {
        while(y>0)
        {
            int temp = x%y;
            x = y;
            y = temp;
        }
        return x;
    }
}