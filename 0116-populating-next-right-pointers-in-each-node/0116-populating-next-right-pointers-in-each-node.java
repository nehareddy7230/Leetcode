/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/

class Solution {
    public Node connect(Node root) {
         if (root == null) {
        return null;
    }
        Node head = root;
        method(root,head);
        return root;
    }
    public void method(Node root,Node head)
    {
        Queue<Node> q1 = new LinkedList<>();
        Queue<Node> q2 = new LinkedList<>();
        q1.add(root);
        //Node dummy = new dummy(root.val);
        //dummy.next = null;
        while(!q1.isEmpty() || !q2.isEmpty())
        {
            while(!q1.isEmpty())
            {
                Node q = q1.poll();
                if(q.left!=null)
                q2.add(q.left);
                if(q.right!=null)
                q2.add(q.right);
                if(q1.isEmpty())
                {
                    q.next = null;
                }
                else
                {
                    q.next = q1.peek();
                    //dummy.next = q.peek();
                }
            }
            while(!q2.isEmpty())
            {
                Node p = q2.remove();
                if(p.left!=null)
                q1.add(p.left);
                if(p.right!=null)
                q1.add(p.right);
                if(q2.isEmpty())
                {
                    p.next = null;
                }
                else
                {
                    p.next = q2.peek();
                }
            }
        }
    }
}