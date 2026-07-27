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
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> li = new ArrayList<>();
        List<Integer> l = new ArrayList<>();
        target(root,targetSum,li,l,0);
        return li;
    }
    public void target(TreeNode root,int targetSum,List<List<Integer>> li,List<Integer> l,int sum)
    {
        if(root==null) return;
        l.add(root.val);
        sum = sum + root.val;
        if(root.left==null && root.right==null)
        {
            if(sum==targetSum)
            {
                li.add(new ArrayList<>(l));
            }
            else
            {
              l.remove(l.size()-1);
              return;
            }
        }
        target(root.left,targetSum,li,l,sum);
        target(root.right,targetSum,li,l,sum);
        l.remove(l.size()-1);
    }
}