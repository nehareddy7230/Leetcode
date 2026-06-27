class Solution {
    public int maximumLength(int[] nums) {
        HashMap<Integer,Integer> hm = new HashMap<>();
        for(int i=0;i<nums.length;i++)
        {
            if(hm.containsKey(nums[i]))
            {
                hm.put(nums[i],hm.get(nums[i])+1);
            }
            else
            {
                hm.put(nums[i],1);
            }
        }
        int cnt= 0;
        int ans = 1;
        if (hm.containsKey(1)) {
            int c = hm.get(1);
            if (c % 2 == 0)
                ans = Math.max(ans, c - 1);
            else
                ans = Math.max(ans, c);
        }
        for(int i : hm.keySet())
        {
            if(i==1) continue;
            int val = i;
            while(true)
            {
                if(!hm.containsKey(val))
                {
                    cnt = cnt -1;
                    break;
                }
               else if(hm.get(val)>=2)
               {
                cnt = cnt + 2;
                val = val*val;
               }
               else if(hm.get(val)==1)
               {
                  cnt = cnt + 1;
                  break;
               }
            }
            ans = Math.max(ans,cnt);
            cnt = 0;
        }
        return ans;
    }
}