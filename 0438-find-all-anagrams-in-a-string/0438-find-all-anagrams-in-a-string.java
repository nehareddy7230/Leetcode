class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        String s1 = "";
        List<Integer> arr = new ArrayList<>();
        if (p.length() > s.length()) {
    return arr;
}
        for(int i=0;i<p.length();i++)
        {
            s1 = s1 + s.charAt(i);
        }
        char[] ch = s1.toCharArray();
        char[] ch1 = p.toCharArray();
        Arrays.sort(ch1);
        Arrays.sort(ch);
        String ss1 = new String(ch);
        String ss2 = new String(ch1);
        if(ss1.equals(ss2))
        {
            arr.add(0);
        }
        for(int i=p.length();i<s.length();i++)
        {
            s1 = s.substring(i-p.length()+1,i+1);
            char[] ch3 = s1.toCharArray();
            Arrays.sort(ch3);
            String ss3 = new String(ch3);
            if(ss2.equals(ss3))
            {
               arr.add(i-p.length()+1);  
            }
        }
        return arr;
    }
}