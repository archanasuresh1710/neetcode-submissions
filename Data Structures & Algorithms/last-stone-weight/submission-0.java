class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> heap = new PriorityQueue<>(Collections.reverseOrder());

        for(int s: stones)
            heap.add(s);
        
        while(!heap.isEmpty() && heap.size() != 1) {
            int s1 = heap.poll();
            int s2 = heap.poll();

            if(s1 != s2) heap.add(Math.abs(s1-s2));
        }

        return heap.isEmpty() ? 0 : heap.peek();
    }
}
