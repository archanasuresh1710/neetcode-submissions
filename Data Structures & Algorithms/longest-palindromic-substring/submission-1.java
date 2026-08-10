class Solution {
    public String longestPalindrome(String s) {
        /*
         approach 1: finding every possible substring and checking whether each one of them is palindrome
         time: O(n^3) (brute force)

         approach 2: for every ith character, consider it as the center of a string, and expand left and right
            - check whether char at left == char at right
            - not equal => that character is not the center of substring
            - equal => note the length of substring
            this works for an odd length palindrome because we need a center

            for even length  => choose right as left + 1
         */

         int evenLen=0,oddLen=0, evenIndex=0,oddIndex=0;

         for(int i=0;i<s.length();i++) {

            int[] even = evenPalindrome(s, i);
            int[] odd = oddPalindrome(s,i);

            if(even[0] > evenLen) {
                evenIndex = even[1];
                evenLen = even[0];
            }

            if(odd[0] > oddLen) {
                oddIndex = odd[1];
                oddLen = odd[0];
            }
         }

         if(oddLen > evenLen) {
            return s.substring(oddIndex + 1, oddIndex + oddLen);
         } else {
            return s.substring(evenIndex + 1, evenIndex + evenLen + 1);
         }
    }

    private int[] evenPalindrome(String s, int index) {

        int len = 0;
        int left = index, right = index + 1;

        while(right < s.length() && left >=0 && s.charAt(left) == s.charAt(right)) {
            len += 2;
            left--;
            right++;
        }

        return new int[]{len,left};
    }

    private int[] oddPalindrome(String s, int index) {
        int len = 0;

        int left = index, right = index;

        while(right < s.length() && left >=0 && s.charAt(left) == s.charAt(right)) {  
            len += 2;
            left--;
            right++;  
        }
        return new int[]{len,left};
    }
}
