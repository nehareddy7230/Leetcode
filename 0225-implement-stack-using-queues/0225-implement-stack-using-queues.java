class MyStack {
    Queue<Integer> q1;
    
    public MyStack() {
        q1 = new LinkedList<>();
        
    }
    
    public void push(int x) 
    {
        int size = q1.size();
        q1.add(x);
        while(size-->0)
        {
            q1.add(q1.remove());
        }

    }
    
    public int pop() {
        //if(!q1.isEmpty())
        return q1.remove();
        //return null;
    }
    
    public int top() {
        //if(!q1.isEmpty())
        return q1.peek();
        //return null;
    }
    
    public boolean empty() {
        return q1.isEmpty();
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */