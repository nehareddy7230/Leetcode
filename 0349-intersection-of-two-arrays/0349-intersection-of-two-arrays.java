class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        //comment
        HashSet<Integer> hs1 = new HashSet<>();
        HashSet<Integer> hs2 = new HashSet<>();
        for(int i=0;i<nums1.length;i++)
        {
            hs1.add(nums1[i]);
        }
        for(int j=0;j<nums2.length;j++)
        {
            hs2.add(nums2[j]);
        }
        hs1.retainAll(hs2);
        int[] arr = new int[hs1.size()];
        int x=0;
        for(int i : hs1)
        {
            arr[x++] = i;
        }
        return arr;
    }
}