class Solution {
    public List<Integer> majorityElement(int[] nums) {
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
        int val = nums.length/3;
        List<Integer> li = new ArrayList<>();
        for(int i : hm.keySet())
        {
            if(hm.get(i)>val)
            {
                li.add(i);
            }
        }
        return li;
    }
}