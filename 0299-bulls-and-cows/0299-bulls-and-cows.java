class Solution {
    public String getHint(String secret, String guess) {
        int cc=0,bc=0;
        HashMap<Character,Integer> hm1 = new HashMap<>();
        HashMap<Character,Integer> hm2 = new HashMap<>();
        for(int i=0;i<secret.length();i++)
        {
            if(secret.charAt(i)==guess.charAt(i))
            {
                bc++;
            }
            else
            {
                hm1.put(secret.charAt(i),hm1.getOrDefault(secret.charAt(i),0)+1);
                hm2.put(guess.charAt(i),hm2.getOrDefault(guess.charAt(i),0)+1);
            }
        }
        for(char i : hm1.keySet())
        {
            if(hm2.containsKey(i))
            {
                cc = cc + Math.min(hm1.get(i),hm2.get(i));
            }
        }
        String s = "";
        s = s + bc;
        s = s + "A";
        s = s + cc;
        s = s + "B";
        return s;
    }
}