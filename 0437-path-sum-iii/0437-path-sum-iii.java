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
    int c=0;
    public int pathSum(TreeNode root, int targetSum) {
        if(root==null) return 0;
        path(root,targetSum,0);
        pathSum(root.left,targetSum);
        pathSum(root.right,targetSum);
        return c;
    }
    public void path(TreeNode root,int targetSum,long sum)
    {
        if(root==null) return;
        sum = sum + root.val;
        if(sum==targetSum)
        {
            c++;
        }
       path(root.left,targetSum,sum);
       path(root.right,targetSum,sum);
    }
}