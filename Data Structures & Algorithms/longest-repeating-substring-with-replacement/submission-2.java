class Solution {
    public int characterReplacement(String s, int k) {

        // A-Z characters ki frequency store karne ke liye
        int[] freq = new int[26];

        // Sliding window ka left pointer
        int left = 0;

        // Current window me sabse zyada baar aane wale
        // character ki maximum frequency
        int maxFreq = 0;

        // Ab tak ki sabse badi valid window ki length
        int maxLength = 0;

        // Right pointer 0 se start hoga
        // aur har iteration me right++ hoga
        for (int right = 0; right < s.length(); right++) {

            // Right pointer par jo character hai
            // usko current character me store karo
            char c = s.charAt(right);

            // Current character ki frequency badhao
            // Example: A mila -> A ki frequency +1
            freq[c - 'A']++;

            // Current window me sabse zyada baar
            // aane wale character ki frequency find karo
            maxFreq = Math.max(maxFreq, freq[c - 'A']);

            // Current window ki length
            // left se right tak
            int windowLength = right - left + 1;

            // Window ko same character banane ke liye
            // kitne characters replace karne padenge
            int replacements = windowLength - maxFreq;

            // Agar required replacements k se zyada hain
            // to current window valid nahi hai
            if (replacements > k) {

                // Left wale character ko window se remove karo
                // isliye uski frequency 1 kam kar rahe hain
                freq[s.charAt(left) - 'A']--;

                // Window ko left side se chhota karo
                left++;
            }

            // Current valid window aur previous maxLength me
            // jo bada hai usko store karo
            maxLength = Math.max(
                maxLength,
                right - left + 1
            );
        }

        // Sabse badi valid window ki length return karo
        return maxLength;
    }
}