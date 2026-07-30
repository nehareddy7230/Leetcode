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
    int sum1=0;
    public int sumRootToLeaf(TreeNode root) {
        tree(root,0);
        return sum1;
    }
    public void tree(TreeNode root,int sum)
    {
        if(root==null) return;
        sum = sum*2 + root.val;
        if(root.left==null && root.right==null)
        {
            sum1 = sum1 + sum;
        }
        tree(root.left,sum);
        tree(root.right,sum);
    }
    
}