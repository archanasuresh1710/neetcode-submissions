class Solution {
    public boolean isPalindrome(String s) {
        s = s.replaceAll("[^0-9A-Za-z]","");
        int left = 0, right = s.length()-1;
        
        while (left < right) {

            if(Character.toLowerCase(s.charAt(left)) != Character.toLowerCase(s.charAt(right))) 
                return false;
            left++;
            right--;
        }

        return true;
    }
}
