class Solution {

    public String encode(List<String> strs) {
        String result = "";

        if(strs.isEmpty()) return result;
        
        for(String str: strs) {
            result += str.length();
            result += "#";
            result += str;
        }

        return result;
    }

    public List<String> decode(String str) {
       
        List<String> result = new ArrayList<>();

        if(str.isEmpty()) return result;

        int i =0;
        while(i<str.length()) {

            int length = 0;

            while(str.charAt(i) != '#') {
                length = length * 10 + (str.charAt(i) - '0');
                i++;
            }

            i++;

            String s = str.substring(i, i+length);
            result.add(s);

            i = i+length;
        }

        return result;
    }
}
