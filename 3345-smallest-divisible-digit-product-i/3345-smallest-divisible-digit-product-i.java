class Solution {
    public int smallestNumber(int n, int t) {
        int x = prod(n);
        while(x%t!=0)
        {
            n = n + 1;
             x = prod(n);
        }
        return n;
    }
    public int prod(int x)
    {
        int prod = 1;
        while(x>0)
        {
            prod = prod*(x%10);
            x = x/10;
        }
        return prod;
    }
}