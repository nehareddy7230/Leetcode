/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    List<TreeNode> lp = new ArrayList<>();
    List<TreeNode> lq = new ArrayList<>();
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        ancestorbuild(root,p,lp);
        ancestorbuild(root,q,lq);
        int i = 0;
        TreeNode temp = null;
        while(lp.size()> i && lq.size()>i && lp.get(i) == lq.get(i))
        {
            temp = lp.get(i);
            i++;
        }
        return temp;

    }
    public boolean ancestorbuild(TreeNode root,TreeNode node,List<TreeNode> path)
    {
        if(root==null) return false;
        path.add(root);
        if(root == node)
            return true;
        if(ancestorbuild(root.left,node,path) ||
          ancestorbuild(root.right,node,path))
        {
            return true;
        }
        path.remove(path.size()-1);
        return false;
    }
}