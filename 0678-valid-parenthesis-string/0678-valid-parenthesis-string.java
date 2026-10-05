class Solution {
    public boolean checkValidString(String s) {
        int minopenc=0,maxopenc=0;
        for(int i=0;i<s.length();i++)
        {
            if(s.charAt(i)=='(')
            {
                minopenc++;
                maxopenc++;
            }
            else if(s.charAt(i)==')')
            {
                minopenc--;
                maxopenc--;
            }
            else
            {
                minopenc--;
                maxopenc++;
            }
            if(minopenc<0)
            {
                minopenc = 0;
            }
            if(maxopenc<0)
            {
                return false;
            }
        }
            return minopenc==0;
    }
}