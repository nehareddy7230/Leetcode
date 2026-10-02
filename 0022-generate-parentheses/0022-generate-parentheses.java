class Solution {
    List<String> li;
    public List<String> generateParenthesis(int n) {
        li = new ArrayList<>();
        gen("",n,0,0,0);
        return li;
    }
    public void gen(String s,int n,int open,int close,int c)
    {
        if(c==2*n)
        {
            li.add(s);
            return;
        }
        if(open<n)
        {
            gen(s+'(',n,open+1,close,c+1);
        }
        if(open>close)
        {
            gen(s+')',n,open,close+1,c+1);
        }
    }
}