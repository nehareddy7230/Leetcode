class Solution {
    public int largestOverlap(int[][] img1, int[][] img2) {
        List<int[]> li1 = new ArrayList<>();
        List<int[]> li2 = new ArrayList<>();
        for(int i=0;i<img1.length;i++)
        {
            for(int j=0;j<img1[0].length;j++)
            {
                if(img1[i][j]==1)
                {
                    li1.add(new int[]{i,j});
                }
            }
        }
        for(int i=0;i<img2.length;i++)
        {
            for(int j=0;j<img2[0].length;j++)
            {
                if(img2[i][j]==1)
                {
                    li2.add(new int[]{i,j});
                }
            }
        }
        HashMap<String,Integer> hm = new HashMap<>();
        int ans = 0;
        for(int[] i : li1)
        {
            for(int[] j : li2)
            {
                int dr = j[0]-i[0];
                int dc = j[1]-i[1];
                String key = dr+","+dc;
                if(!hm.containsKey(key))
                {
                    hm.put(key,1);
                }
                else
                {
                    hm.put(key,hm.get(key)+1);
                }
                ans = Math.max(ans,hm.get(key));
            }
        }
          return ans;
    }
}