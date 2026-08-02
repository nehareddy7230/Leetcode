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
    HashMap<TreeNode,TreeNode> parent = new HashMap<>();
    Queue<TreeNode> q = new LinkedList<>();
    HashSet<TreeNode> visited = new HashSet<>();
    int c = -1;
    TreeNode startNode;
    public int amountOfTime(TreeNode root, int start)
    {
        parentnode(root,null,start);
        q.offer(startNode);
        visited.add(startNode);
        while(!q.isEmpty())
        {
            int size = q.size();
            for(int i=0;i<size;i++)
            {
                TreeNode nod = q.poll();
                if(nod.left!=null && !visited.contains(nod.left))
                {
                    q.offer(nod.left);
                    visited.add(nod.left);
                }
                if(nod.right!=null && !visited.contains(nod.right))
                {
                    q.offer(nod.right);
                    visited.add(nod.right);
                }
                TreeNode par = parent.get(nod);
                if(par!=null && !visited.contains(par))
                {
                    q.offer(par);
                    visited.add(par);
                }
            }
            c++;
        }
        return c;
    }
    public void parentnode(TreeNode root,TreeNode p,int start)
    {
        if(root==null) return;
        parent.put(root,p);
        if(root.val==start)
        {
            startNode  = root;
        }
        parentnode(root.left,root,start);
        parentnode(root.right,root,start);
    }
}