class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
       
       // Anagram ki same frequency ko key banayenge
        // aur us key ke according strings ko group karenge
        HashMap<String, List<String>> map = new HashMap<>();

        // Har string ko ek-ek karke check karo
        for(String str : strs) {

            // 26 lowercase letters ki frequency store karne ke liye
            int count[] = new int[26];

            // Current string ke har character ka count badhao
            for(char c : str.toCharArray()) {
                count[c - 'a']++;
            }

            // Frequency array ko String mein convert karke key banao
            String key = Arrays.toString(count);

            // Agar ye key pehli baar aayi hai,
            // toh iska naya group create karo
            if(!map.containsKey(key)) {
                map.put(key, new ArrayList<>());
            }

            // Current string ko uski corresponding group mein add karo
            map.get(key).add(str);
        }

        // HashMap ki saari values (groups) return karo
        return new ArrayList<>(map.values());
    }
}
