class Solution {
    public int hammingWeight(int n) {
        int c=0;
        for(int i=0;i<32;i++)
        {
            if(check(n,i))
            {
                c++;
            }

        }
        return c;
    }
    public boolean check(int x,int i)
    {
        return (((x>>i)&1)==1);
    }
}