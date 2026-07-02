class Solution {
    public int maxVowels(String s, int k) {
       int vc = 0;
        for(int i=0;i<k;i++)
        {
            if(s.charAt(i)=='a' || s.charAt(i)=='e' || s.charAt(i)=='i' || s.charAt(i)=='o' || s.charAt(i)=='u')
            {
                vc = vc + 1;
            }
        }
        int max = vc;
        for(int i=k;i<s.length();i++)
        {
            char c = s.charAt(i-k);
            if(c=='a' || c=='e' || c=='i' || c=='o' || c=='u')
            {
                vc = vc - 1;
            }
            char c1 = s.charAt(i);
             if(c1=='a' || c1=='e' || c1=='i' || c1=='o' || c1=='u')
            {
                vc = vc + 1;
            }
            max = Math.max(max,vc);
        }
        return max;
    }
}