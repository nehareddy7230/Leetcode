/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
     List<Map<Integer,Integer>> li;
     int ans = 0;
    public int pseudoPalindromicPaths (TreeNode root) {
        li = new ArrayList<>();
        HashMap<Integer,Integer> hm = new HashMap<>();
        paths(root,hm);
        return ans;
    }
    public void paths(TreeNode root,HashMap<Integer,Integer> hm)
    {
        if(root==null) return;
        if(hm.containsKey(root.val))
        {
            hm.put(root.val,hm.get(root.val)+1);
        }
        else
        {
            hm.put(root.val,1);
        }
        if(root.left==null && root.right==null)
        {
            int c=0;
            for(int i : hm.keySet())
            {
                if(hm.get(i)%2!=0)
                {
                    c = c + 1;
                }
            }
            if(c<=1)
            {
                ans = ans + 1;
            }
            
        }
        paths(root.left,hm);
        paths(root.right,hm);
        if(hm.get(root.val) > 1)
    hm.put(root.val, hm.get(root.val) - 1);
else
    hm.remove(root.val);
    }
}