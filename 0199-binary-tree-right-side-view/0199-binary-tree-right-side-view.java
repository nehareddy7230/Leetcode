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
    public List<Integer> rightSideView(TreeNode root) 
    {
        Queue<TreeNode> q1 = new LinkedList<>();
        TreeNode temp = root;
        q1.add(temp);
        int size = 0;
        List<Integer> li = new ArrayList<>();
        if(root==null) return li;
        while(!q1.isEmpty())
        {
            size = q1.size();
            TreeNode ans = new TreeNode();
            for(int i=0;i<size;i++)
            {
                TreeNode val1 = q1.poll();
                if(val1.left!=null) q1.offer(val1.left);
                if(val1.right!=null) q1.offer(val1.right);
                ans = val1;
            }
            li.add(ans.val);
        }
        return li;
    }
}