class Solution {
    public int lengthOfLongestSubstring(String s) 
    {
        HashMap<Character,Integer> hm = new HashMap<>();
        int left = 0;
        int len = 0;
        for(int i=0;i<s.length();i++)
        {
            char ch = s.charAt(i);
            if(hm.containsKey(ch))
            {
                left = Math.max(left,hm.get(ch)+1);
            }
            hm.put(ch,i);
            len = Math.max(len,i-left+1);
        }
        return len;
    }
}