import java.util.*;

class Solution {
    public List<Integer> findSubstring(String s, String[] words) {

        HashMap<String, Integer> hm = new HashMap<>();

        // Store the frequency of each word
        for (int i = 0; i < words.length; i++) {
            if (!hm.containsKey(words[i])) {
                hm.put(words[i], 1);
            } else {
                hm.put(words[i], hm.get(words[i]) + 1);
            }
        }

        ArrayList<Integer> arr = new ArrayList<>();

        int n = s.length();
        int len = words[0].length();

        // Check each possible alignment
        for (int i = 0; i < len; i++) {

            int left = i;
            int count = 0;

            HashMap<String, Integer> seen = new HashMap<>();

            // Move right pointer word by word
            for (int j = i; j + len <= n; j += len) {

                String sub = s.substring(j, j + len);

                // If the word is not required
                if (!hm.containsKey(sub)) {
                    seen.clear();
                    count = 0;
                    left = j + len;
                    continue;
                }

                // Add the word to the current window
                seen.put(sub, seen.getOrDefault(sub, 0) + 1);
                count++;

                // Remove words from the left if frequency is too high
                while (seen.get(sub) > hm.get(sub)) {

                    String leftWord = s.substring(left, left + len);

                    seen.put(leftWord, seen.get(leftWord) - 1);

                    left += len;
                    count--;
                }

                // If all required words are found
                if (count == words.length) {

                    arr.add(left);

                    // Move left pointer to search for overlapping matches
                    String leftWord = s.substring(left, left + len);

                    seen.put(leftWord, seen.get(leftWord) - 1);

                    left += len;
                    count--;
                }
            }
        }

        return arr;
    }
}