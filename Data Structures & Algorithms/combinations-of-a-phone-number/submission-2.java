class Solution {
    public List<String> letterCombinations(String digits) {

        if(digits.isEmpty()) return new ArrayList<>();

        Map<Integer, String> map = new HashMap<>();
        map.put(2, "abc");
        map.put(3, "def");
        map.put(4, "ghi");
        map.put(5, "jkl");
        map.put(6, "mno");
        map.put(7, "pqrs");
        map.put(8, "tuv");
        map.put(9, "wxyz");

        List<String> result = new ArrayList<>();
        backtrack(digits, 0, "", result, map);
    
        return result;
    }

    private void backtrack(
        String digits,
        int index,
        String current,
        List<String> result,
        Map<Integer, String> map
    ) {

        if(index == digits.length()) {
            result.add(current);
            return;
        }

        String keys = map.get(digits.charAt(index)-'0');

        for(char c: keys.toCharArray()) {
            backtrack(digits, index+1, current + c, result, map);
        }
    }
}
