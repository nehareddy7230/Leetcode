class Solution {
    public int minimumSumSubarray(List<Integer> nums, int l, int r) {
        int sum = Integer.MAX_VALUE;
        int psum = 0;
        int elec = 0;
        for(int i=0;i<nums.size();i++)
        {
            elec = 0;
            psum = 0;
            for(int j=i;j<nums.size();j++)
            {
              if(elec<l)
              {
                psum = psum + nums.get(j);
                elec = elec + 1;
              }
              else
              {
                if(elec >= l && psum > 0)
                sum = Math.min(sum,psum);
                if(elec<r)
                {
                    psum = psum+ nums.get(j);
                    elec = elec + 1;
                }
                else
                {
                    break;
                }
              }
                if(elec >= l && elec <= r && psum > 0)
                 sum = Math.min(sum, psum);
            }
        }
        if(sum==Integer.MAX_VALUE) return -1;
        return sum;
    }
}