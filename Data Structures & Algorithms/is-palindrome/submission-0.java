class Solution {
    public boolean isPalindrome(String s) {
      
        int left = 0;
        int right = s.length() - 1;

        while(left < right) {

            // non-alphanumeric skip karo
            while(left < right && !Character.isLetterOrDigit(s.charAt(left))) {
                left++;
            }

            // non-alphanumeric skip karo
            while(left < right && !Character.isLetterOrDigit(s.charAt(right))) {
                right--;
            }

            // lowercase me compare
            if(Character.toLowerCase(s.charAt(left)) !=
               Character.toLowerCase(s.charAt(right))) {

                return false;
            }

            left++;
            right--;
        }

        return true;
    }
} 