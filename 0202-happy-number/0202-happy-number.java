class Solution {
    public boolean isHappy(int n) {
        HashSet<Integer> hs = new HashSet<>();
       while(n!=1)
       {
        int sum = 0;
        if(hs.contains(n))
        {
            return false;
        }
        hs.add(n);
        while(n!=0)
        {
            int val = n % 10;
            sum = sum + (int)Math.pow(val,2);
            n = n/10;
        }
        n = sum;
       }
       return true;
    }
}