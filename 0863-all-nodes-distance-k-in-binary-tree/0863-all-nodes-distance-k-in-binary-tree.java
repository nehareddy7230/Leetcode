/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution 
{
    HashMap<TreeNode,TreeNode> parent = new HashMap<>();
    List<Integer> tr = new ArrayList<>();
    Queue<TreeNode> q = new LinkedList<>();
    List<TreeNode> visited = new ArrayList<>();
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k)
    {
        parentnode(root,root.left);
        q.add(target);
        visited.add(target);
        int distance = 0;
        while(!q.isEmpty() && distance<k)
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
            distance++;
        }
        while(!q.isEmpty())
        {
            tr.add(q.poll().val);
        }
        return tr;
    }
  
    public void parentnode(TreeNode root,TreeNode p)
    {
        if(root==null) return;
        parent.put(root,p);
        parentnode(root.left,root);
        parentnode(root.right,root);
    }
}