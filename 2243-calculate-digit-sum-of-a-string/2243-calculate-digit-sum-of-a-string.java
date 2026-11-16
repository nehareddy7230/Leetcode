
class Solution {
    public String digitSum(String s, int k) 
    {
        while(s.length() > k)
        {
            String result = "";

            for(int i = 0; i < s.length(); i += k)
            {
                int val = 0;

                for(int j = i; j < Math.min(i+k, s.length()); j++)
                {
                    val += s.charAt(j) - '0';
                }

                result += val;
            }

            s = result;
        }

        return s;
    }
}
