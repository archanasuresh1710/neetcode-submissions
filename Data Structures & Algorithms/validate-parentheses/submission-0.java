class Solution {
    public boolean isValid(String s) {
        Map<Character,Character> map = new HashMap<>();
        map.put(')','(');
        map.put(']','[');
        map.put('}','{');

        Stack<Character> stack = new Stack<>();

        for(char c: s.toCharArray()) {
            if(map.containsKey(c)) {
                char ob = map.get(c);
                if(stack.isEmpty() || stack.pop() != ob) return false;
            } else {
                stack.add(c); 
            }
        }

        return stack.isEmpty();
    }
}
