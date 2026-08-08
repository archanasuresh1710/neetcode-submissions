class Node {
    int key;
    int val;
    Node next;
    Node prev;

    Node(int key, int val) {
        this.key = key;
        this.val = val;
    }
}

class LRUCache {

    private int capacity;
    private Map<Integer, Node> map;
    private Node head;
    private Node tail;

    public LRUCache(int capacity) {
        this.capacity = capacity;

        map = new HashMap<>();

        head = null; 
        tail = null;
    }

    private void addFirst(Node node) {

        if(head == null && tail == null) {
            head = node;
            tail = node;
        } else {
            node.next = head;
            head.prev = node;
            head = node;
        }
        
    }

    private void remove(Node node) {
        Node next = node.next;
        Node prev = node.prev;

        if (prev != null) prev.next = next;
        else head = next;

        if (next != null) next.prev = prev;
        else tail = prev;

        node.next = null;
        node.prev = null;
    }

    public int get(int key) {
        Node node = map.get(key);

        if(node == null) return -1;
        else {
            remove(node);
            addFirst(node);
            return node.val;
        }
    }

    public void put(int key, int value) {

        Node node = map.get(key);
        if(node != null) {
            node.val = value;
            remove(node);
        } else {
            node = new Node(key,value);
            
        }
        map.put(key, node);
        addFirst(node);

        if(map.size() > capacity) {

            map.remove(tail.key);
            remove(tail);
        }
    }

}