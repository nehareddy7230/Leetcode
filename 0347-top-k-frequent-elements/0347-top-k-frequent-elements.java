class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer,Integer> hm  = new HashMap<>();
        //TreeMap<Integer,List<Integer>> tm = new TreeMap<>(Collections.reverseOrder());
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
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b)->hm.get(b)-hm.get(a));
        for(int key:hm.keySet())
        {
            pq.add(key);
        }
        int[] arr = new int[k];
        //int x=0;
        for(int i=0;i<k;i++)
        {
            arr[i] = pq.poll();
        }
        return arr;
    }
}