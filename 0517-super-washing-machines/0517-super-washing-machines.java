class Solution {
    public int findMinMoves(int[] machines) {
        int balance = 0;
        int diff = 0;
        int avg = 0;
        int ans = 0;
        for(int i=0;i<machines.length;i++)
        {
            avg = avg + machines[i];
        }
        if(avg%machines.length!=0) return -1;
        avg = avg/machines.length;
        for(int i=0;i<machines.length;i++)
        {
            diff = machines[i] - avg;
            balance +=diff;
            ans = Math.max(ans,Math.max(Math.abs(balance),diff));
        }
        return ans;
    }
}