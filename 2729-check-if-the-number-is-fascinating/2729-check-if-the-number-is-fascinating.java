class Solution {
    public boolean isFascinating(int n) {
        int val1 = 2*n;
        int val2 = 3*n;
        boolean flag = true;
        HashSet<Integer> hs = new HashSet<>();
        while(n>0){
            int x = n%10;
            n = n/10;
            if (x == 0 || hs.contains(x)) {
                return false;
            }
            hs.add(x);
        }
        while(val1>0){
            int x = val1%10;
            val1 = val1/10;
             if (x == 0 || hs.contains(x)) {
                return false;
            }

            hs.add(x);
        }
        while(val2>0){
            int x = val2%10;
            val2 = val2/10;
            if (x == 0 || hs.contains(x)) {
                return false;
            }

            hs.add(x);
        }
        return hs.size()==9;
    }
}