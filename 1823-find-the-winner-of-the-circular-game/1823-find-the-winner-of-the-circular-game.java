class Solution {
    public int findTheWinner(int n, int k) {
        boolean[] arr = new boolean[n];
        return func(0,n,n,k,arr);
    }
    public int func(int idx,int n,int val,int k,boolean[] arr)
    {
        if(val==1) 
        {
           for(int i=0;i<n;i++)
           {
             if(!arr[i])
             {
                return i+1;
             }
           }
        }
       int count=0;
        while(count<k)
        {
            if(!arr[idx])
            {
                count++;
            }
            if(count==k)
            {
                break;
            }
            idx = (idx+1)%n;
        }
        arr[idx] = true;
        return func((idx+1)%n,n,val-1,k,arr);
        }
    }
