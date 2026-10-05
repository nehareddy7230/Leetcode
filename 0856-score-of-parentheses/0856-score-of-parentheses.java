class Solution {
    public int scoreOfParentheses(String s) {
        Stack<Integer> st = new Stack<>();
        for(int i=0;i<s.length();i++)
        {
            char ch = s.charAt(i);
            if(ch=='(')
            {
                st.push(-1);
            }   
            else if(ch==')')
            {
                int val=0;
                if(st.peek()==-1)
                {
                    st.pop();
                    st.push(1);
                }
                else
                {
                while(st.peek()!=-1)
                {
                   int val1 = st.pop();
                   val = val + val1;
                }
                   val = val*2;
                st.pop();
                st.push(val);
                }
            }
        }
        int ans = 0;
        while(!st.isEmpty())
        {
            ans = ans + st.pop();
        }
        return ans;
    }
}