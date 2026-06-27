class Solution {
    public boolean isValidSudoku(char[][] board) {
        HashMap<Character,Integer> hm;
        for(int i=0;i<board.length;i++)
        {
            hm = new HashMap<>();
            for(int j=0;j<board[0].length;j++)
            {
                if(board[i][j]=='.')
                {
                    continue;
                }
                if(hm.containsKey(board[i][j]))
                {
                    return false;
                }
                else
                {
                    hm.put(board[i][j],1);
                }
            }
            hm.clear();
        }
        for(int i=0;i<board.length;i++)
        {
            hm = new HashMap<>();
            for(int j=0;j<board[0].length;j++)
            {
                if(board[j][i]=='.')
                {
                    continue;
                }
                if(hm.containsKey(board[j][i]))
                {
                    return false;
                }
                else
                {
                    hm.put(board[j][i],1);
                }
            }
            hm.clear();
        }
        int row = 0;
        int col = 0;
        int cnt=9;
        while(cnt>0)
        {
        hm = new HashMap<>();
        for(int i=0;i<3;i++)
        {
            for(int j=0;j<3;j++)
            {
                if(board[row+i][col+j]=='.')
                {
                    continue;
                }
                if(hm.containsKey(board[row+i][col+j]))
                {
                    return false;
                }
                else{
                    hm.put(board[row+i][col+j],1);
                }
            }
        }
        cnt--;
        if(cnt%3==0)
        {
        row= row + 3;
        col = 0;
        }
        else
        {
            col = col + 3;
        }
        hm.clear();
        }
        return true;
    }
}