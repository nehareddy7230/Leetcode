/*class Solution {
    int ans = Integer.MAX_VALUE;
    public int calculateMinimumHP(int[][] dungeon) {
        dung(dungeon,0,0,0,0);
        return ans;
    }
    public void dung(int[][] dungeon,int mintotal,int total,int x,int y)
    {
        total = total+ dungeon[x][y];
        mintotal = Math.min(total,mintotal);
        if(x==dungeon.length-1 && y==dungeon[0].length-1)
        {
            int health = Math.max(1,1-mintotal);
            ans = Math.min(ans,health);
            return;
        }
        if(y<dungeon[0].length-1)
        dung(dungeon,mintotal,total,x,y+1);
        if(x<dungeon.length-1)
        dung(dungeon,mintotal,total,x+1,y);
    }
}*/
class Solution {
    public int calculateMinimumHP(int[][] dungeon) {

        int m = dungeon.length;
        int n = dungeon[0].length;

        int[][] dp = new int[m + 1][n + 1];

        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                dp[i][j] = Integer.MAX_VALUE;
            }
        }

        dp[m][n - 1] = 1;
        dp[m - 1][n] = 1;

        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {

                int next = Math.min(dp[i + 1][j], dp[i][j + 1]);

                dp[i][j] = Math.max(1, next - dungeon[i][j]);
            }
        }

        return dp[0][0];
    }
}