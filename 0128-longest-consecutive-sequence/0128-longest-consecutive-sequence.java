class Solution {
    public int longestConsecutive(int[] nums) {
        int max=0;
        HashSet<Integer> hs = new HashSet<>();
        for(int i=0;i<nums.length;i++)
        {
            hs.add(nums[i]);
        }
        for(int x : hs)
        {
            if(!hs.contains(x-1))
            {
            int val = x;
            int c = 1;
            while(hs.contains(val+1))
            {
                c = c + 1;
                val = val + 1;
            }
            max = Math.max(max,c);
            }
        }
    return max;
    }
}