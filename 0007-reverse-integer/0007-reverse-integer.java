class Solution 
{
    public int reverse(int x)
    {
        if(x <= 0-Math.pow(2,31) || x >= Math.pow(2,31)-1) return 0;
        long ans = 0;
        int i=0;
        int val = x;
        if(x<0)
        {
            x = Math.abs(x);
        }
        while(x>0)
        {
            int y = x%10;
            ans = (ans*10) + (y);
            x = x/10;
        }
        if(val<0) 
        ans = 0 - ans;
        if(ans <= 0-Math.pow(2,31) || ans >= Math.pow(2,31)-1) return 0;
        return (int)ans;
    }
}