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
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
       Queue<TreeNode> q1 = new LinkedList<>();
       int size=0;   
       TreeNode temp = root;
       q1.add(temp);
       List<List<Integer>> li = new ArrayList<>();
       if(root==null) return li;
       while(!q1.isEmpty())
       {
            size = q1.size();
            List<Integer> l = new ArrayList<>();
            for(int i=0;i<size;i++)
            {
                TreeNode val1 = q1.poll();
                l.add(val1.val);
                if(val1.left!=null) q1.offer(val1.left);
                if(val1.right!=null) q1.offer(val1.right);
            }
            li.add(l);
       }
        Collections.reverse(li);
        return li;
    }
}