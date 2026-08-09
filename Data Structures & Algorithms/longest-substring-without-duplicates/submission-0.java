class Solution {
    public int lengthOfLongestSubstring(String s) {
        /*
        Brute force: finding all combinations of substrings and then checking for duplicity in them
        Time: Generating all substrings = O(n^2). Checking duplicate for each would take O(n) => O(n^3)
        Space: O(n) for holding a set for each substring

        Approach 2:
        Fix two pointers: left at start and right at left+1
        Check whether char at right == chat at left
            - if no, increment right
            - if yes, calculate right - left. increment left
        Problem: if start element doesn't repeat, left doesn't move => check for each letter

        Approach 3: suppose i use a set to hold visited letters
        left at start, right at left +1 -> check if s[right] is in the set. if not, add it and move right
        if in the set, remove s[left] and left++ until set does not contain duplicate => right - left
        */   

        Set<Character> set = new HashSet<>();
        int len = 0, left = 0, right = 0;

        while(right < s.length()) {

            while(left < right && set.contains(s.charAt(right))) {
                set.remove(s.charAt(left));
                left++;
            }

            set.add(s.charAt(right));
            len = Math.max(len, right - left + 1);
            right++;
        } 

        return len;
    }
}
