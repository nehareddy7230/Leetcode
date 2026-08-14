class Solution {
    public int minimumRounds(int[] tasks) {
        HashMap<Integer,Integer> hm = new HashMap<>();
        for(int i=0;i<tasks.length;i++)
        {
            if(hm.containsKey(tasks[i]))
            {
                hm.put(tasks[i],hm.get(tasks[i])+1);
            }
            else
            {
                hm.put(tasks[i],1);
            }
        }
        int c=0;
        for(int i :hm.keySet())
        {
            if(c==-1)
            {
                return -1;
            }
           int val = hm.get(i);
           while(val>0)
           {
           if(val>=3 && (val%3==0 ||val%2!=0))
            {
              val = val-3;
              c++;
            }
           else if(val>=2)
            {
              val = val - 2;
              c++;
            }
            else
            {
                c=-1;
                break;
            }
           }
        }
        return c;
    }
}