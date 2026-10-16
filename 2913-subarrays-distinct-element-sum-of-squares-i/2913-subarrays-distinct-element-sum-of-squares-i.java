class Solution {
    public int sumCounts(List<Integer> nums) 
    {
        HashSet<Integer> hs = new HashSet<>();
        int c=0;
        for(int i=0;i<nums.size();i++)
        {
            for(int j=i;j<nums.size();j++)
            {
                hs.add(nums.get(j));
                c = c + (int)Math.pow(hs.size(),2);
            }
            hs.clear();
        }
        return c;
    }
}