class DynamicArray {

    private int[] arr;
    private int size;

    public DynamicArray(int capacity) {
        if(capacity > 0) this.arr = new int[capacity];
        this.size = 0;
    }

    public int get(int i) {
        return arr[i];
    }

    public void set(int i, int n) {
        arr[i] = n;
    }

    public void pushback(int n) {
        if(size == arr.length) resize();
        int pos = getSize();
        arr[pos] = n;
        this.size++;
    }

    public int popback() {
        int pos = getSize();
        int last = arr[pos-1];
        arr[pos-1] = 0;
        this.size--;
        return last;
    }

    private void resize() {
        int[] rearr = new int[arr.length * 2];
        System.arraycopy(arr, 0, rearr, 0, arr.length);
        this.arr = rearr;
    }

    public int getSize() {
        return this.size;
    }

    public int getCapacity() {
        return arr.length;
    }
}
