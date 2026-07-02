class Solution {
    public int characterReplacement(String s, int k) {
        int left= 0;
        int right = 0;
        int max = 0;
      int ans=0;
        int[] freq = new int[26];
        while(right<s.length())
        {
            freq[s.charAt(right)-'A']++;
            max = Math.max(max,freq[s.charAt(right)-'A']);
            while((right-left+1)-max>k)
            {
                freq[s.charAt(left)-'A']--;
                left++;
            }
            ans = Math.max(ans,right-left+1);
            right++;
        }
        return ans;
    }
}