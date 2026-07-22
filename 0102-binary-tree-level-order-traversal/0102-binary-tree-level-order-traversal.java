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
    public List<List<Integer>> levelOrder(TreeNode root) {
        Queue<TreeNode> q1 = new LinkedList<>();
        TreeNode temp = root;
        List<List<Integer>> li = new ArrayList<>();
        if(root==null) return li;
        q1.add(temp);
        int size = 0;
        while(!q1.isEmpty())
        {
         size = q1.size();
         List<Integer> l = new ArrayList<>();
         for(int i=0;i<size;i++)
          {
            TreeNode cur = q1.poll();
            l.add(cur.val);
            if(cur.left!=null) q1.offer(cur.left);
            if(cur.right!=null) q1.offer(cur.right);
          }
          li.add(l);
        }
        return li;
    }
}