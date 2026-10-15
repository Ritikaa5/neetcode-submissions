

class Solution {
    public int lengthOfLongestSubstring(String s) {

        HashSet<Character> set = new HashSet<>();

        int maxSub = 0;
        int i = 0;
        int j = 0;

        while (j < s.length()) {

            char c = s.charAt(j);

            // Agar character pehle se hai
            if (set.contains(c)) {

                // Left side se character remove karo
                set.remove(s.charAt(i));
                i++;

            } else {

                // Character ko set mein add karo
                set.add(c);

                // Current substring ki length
                int length = j - i + 1;

                // Maximum length store karo
                maxSub = Math.max(maxSub, length);

                // Right pointer aage
                j++;
            }
        }

        return maxSub;
    }
}