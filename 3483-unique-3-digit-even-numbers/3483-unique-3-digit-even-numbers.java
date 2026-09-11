class Solution {
    public int totalNumbers(int[] digits) {
        
        int x =0 ;
        HashSet<Integer> hs = new HashSet<>();
        for(int i=0;i<digits.length;i++)
        {
            for(int j=0;j<digits.length;j++)
            {
                  for(int k=0;k<digits.length;k++)
                  {
                    if(i!=j && j!=k && k!=i && digits[i]!=0 && digits[k]%2==0)
                    {
                     x = x*10 + digits[k];
                     x = x*10 + digits[j];
                     x = x*10 + digits[i];
                     hs.add(x);
                     x=0;
                    }
                  }
             }
        }
        return hs.size();
    }
}