class KthLargest {

    private PriorityQueue<Integer> heap = new PriorityQueue<>();
    private int k;

    public KthLargest(int k, int[] nums) {
        this.k = k;
        heap.add(Integer.MIN_VALUE);
        for(int n: nums) {
            heap.add(n);
            while(heap.size() > k) {
                heap.poll();
            }
        }
    }
    
    public int add(int val) {
        heap.add(val);
        while(heap.size() > k) {
            heap.poll();
        }
        return heap.peek();
    }
}
