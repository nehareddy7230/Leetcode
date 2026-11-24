class Solution {
    public int maxLength(int[] nums) {
        int len = 0;
        for(int i=0;i<nums.length;i++)
        {
            for(int j=i;j<nums.length;j++)
            {
                int prod1 = prod(nums,i,j);
                int lcm1 = lcm(nums,i,j);
                int gcd1 = gcd(nums,i,j);
                if(prod1 == lcm1*gcd1 )
                {
                    len = Math.max(len,j-i+1);
                }
            }
        }
        return len;
    }
    public int prod(int nums[],int x,int y)
    {
        int val = 1;
        for(int i=x;i<=y;i++)
        {
            val = val * nums[i];
        }
        return val;
    }
    public int lcm(int[] nums,int x,int y)
    {
        int lcm1 = nums[x];
        for(int i=x+1;i<=y;i++)
        {
            lcm1 = func1(lcm1,nums[i]);
        }
        return lcm1;
    }
    public int gcd(int[] nums,int x,int y)
    {
        int gcd1 = nums[x];
        for(int i=x+1;i<=y;i++)
        {
            gcd1 = func2(gcd1,nums[i]);
        }
        return gcd1;
    }
    public int func1(int a,int b)
    {
        return (a*b)/func2(a,b);
    }
    public int func2(int a,int b)
    {
        return b==0?a:func2(b,a%b);
    }
}