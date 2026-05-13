class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer,Integer> map = new HashMap<>();

        for(int num: nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        PriorityQueue<Map.Entry<Integer,Integer>> pq = new PriorityQueue<>(
            (a,b) -> a.getValue() - b.getValue()
        );

        for(Map.Entry<Integer,Integer> entry: map.entrySet()) {
            pq.add(entry);
            while(pq.size() > k) {
                pq.poll();
            }
        }

        int[] result = new int[k];
        int ri = 0;

        while(!pq.isEmpty()) {
            result[ri++] = pq.poll().getKey();
        }

        return result;
    }
}
