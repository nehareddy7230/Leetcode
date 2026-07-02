class Solution {
    public int totalFruit(int[] fruits) {
        int left = 0;
        int ans = 0;
        HashMap<Integer,Integer> hm = new HashMap<>();
        for(int right = 0;right<fruits.length;right++)
        {
            if(!hm.containsKey(fruits[right]))
            hm.put(fruits[right],1);
            else
            {
                hm.put(fruits[right],hm.get(fruits[right])+1);
            }
            while(hm.size()>2)
            {
                int val = hm.get(fruits[left]);
                if(val==1)
                {
                    hm.remove(fruits[left]);
                }
                else
                {
                    hm.put(fruits[left],hm.get(fruits[left])-1);
                }
                left++;
            }
            ans = Math.max(ans,right-left+1);
        }
     return ans;
    }
}