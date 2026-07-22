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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        Stack<TreeNode> s1 = new Stack<>();
        Stack<TreeNode> s2 = new Stack<>();
        TreeNode temp = root;
        s1.add(temp);
        List<List<Integer>> li = new ArrayList<>();
        if(root==null) return li;
        while(!s1.isEmpty() || !s2.isEmpty())
        {
            List<Integer> l = new ArrayList<>();
            while(!s1.isEmpty())
            {
                TreeNode val1 = s1.pop();
                l.add(val1.val);
                if(val1.left!=null) s2.add(val1.left);
                if(val1.right!=null) s2.add(val1.right);
            }
            if(!l.isEmpty())
            li.add(l);
            l = new ArrayList<>();
             while(!s2.isEmpty())
            {
                TreeNode val1 = s2.pop();
                l.add(val1.val);
                if(val1.right!=null) s1.add(val1.right);
                if(val1.left!=null) s1.add(val1.left);
            }
            if(!l.isEmpty())
            li.add(l);
        }
        return li;
   }
}