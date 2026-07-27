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
    boolean flag = false;
    public boolean hasPathSum(TreeNode root, int targetSum) {
        return target(root,targetSum,0);
    }
    public boolean target(TreeNode root,int targetSum,int sum)
    {
        if(root==null) return false;
        if(root.left==null && root.right==null)
        {
            if(sum+root.val==targetSum)
            {
                return true;
            }
        }
        return target(root.left,targetSum,sum+root.val) || target(root.right,targetSum,sum+root.val);
    }
}