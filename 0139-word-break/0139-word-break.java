class Solution 
{
    public boolean wordBreak(String s, List<String> wordDict) 
    {
        Boolean[] dp = new Boolean[s.length()+1];
        return func(s,wordDict,0,dp);
    }
    public boolean func(String s,List<String> wordDict,int idx,Boolean[] dp)
    {
       if(idx==s.length())
       {
         return true;
       } 
       if(dp[idx]!=null)
       {
         return dp[idx];
       }
       for(int i=idx;i<s.length();i++)
       {
          String sub = s.substring(idx,i+1);
          if(wordDict.contains(sub))
          {
             if(func(s,wordDict,i+1,dp))
             {
               return dp[idx] = true;
             }
          }
       }
       return dp[idx] = false;
    }
}