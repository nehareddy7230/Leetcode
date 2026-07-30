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
class Solution 
{
    int ans =0;
    int l=0;
    public int longestUnivaluePath(TreeNode root) 
    {
        tree(root);
       return ans;
    }
    public int tree(TreeNode root)
    {
        if(root==null) return 0;
        int left = tree(root.left);
        int right = tree(root.right);
        int leftpath = 0;
        int rightpath = 0;
        if(root.left!=null && root.left.val==root.val)
        {
            leftpath = left + 1;
        }
        if(root.right!=null && root.right.val==root.val)
        {
            rightpath = right + 1;
        }
        ans = Math.max(ans,leftpath+rightpath);
        return Math.max(leftpath,rightpath);
    }
}