// Definition for a pair
// class Pair {
//     int key;
//     String value;
//
//     Pair(int key, String value) {
//         this.key = key;
//         this.value = value;
//     }
// }
public class Solution {
    public List<List<Pair>> insertionSort(List<Pair> pairs) {

        if(pairs.isEmpty()) return new ArrayList<>();
        List<List<Pair>> result = new ArrayList<>();
        result.add(new ArrayList<>(pairs));

        for(int i=1;i<pairs.size();i++) {
            int j = i-1;
            Pair curr = pairs.get(i);

            while(j >= 0 && pairs.get(j).key > curr.key) {
                pairs.set(j+1, pairs.get(j));
                j--;
            }
            pairs.set(j+1, curr);
            result.add(new ArrayList<>(pairs));
        }

        return result;
    }
}
