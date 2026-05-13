class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        List<List<String>> result = new ArrayList<>();

        for(String s: strs) {
            char[] c = s.toCharArray();
            Arrays.sort(c);
            String cs = new String(c);
            List<String> list = map.get(cs);
            if(list == null) list = new ArrayList<>();
            list.add(s);
            map.put(cs,list);
        }

        for(Map.Entry<String, List<String>> entry: map.entrySet()) {
            result.add(entry.getValue());
        }

        return result;
    }
}
