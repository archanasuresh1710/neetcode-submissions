
class LinkedList {

    static class Node {
        public int val;
        public Node next;

        public Node(int val) {
            this.val = val;
            this.next = null;
        }
    }

    Node head;

    public LinkedList() {
        this.head = null;
    }

    public int get(int index) {
        Node curr = head;
        int i=0;
        while(curr != null) {
            if(i==index) return curr.val;
            curr = curr.next;
            i++;
        }
        
        return -1;
    }

    public void insertHead(int val) {
        Node newNode = new Node(val);
        newNode.next = head;
        this.head = newNode;
    }

    public void insertTail(int val) {
        if (head == null) {
            insertHead(val);
            return;
        }
        Node curr = head;
        while(curr.next != null) {
            curr = curr.next;
        }
        curr.next = new Node(val);
    }

    public boolean remove(int index) {
        if (head == null) return false;
        if (index == 0) {
            head = head.next;
            return true;
        }

        Node curr = head;
        for(int i=0;i<index-1;i++) {
            if(curr == null || curr.next == null) return false;
            curr = curr.next;
        }

        if(curr == null || curr.next == null) return false;

        curr.next = curr.next.next;
     
        return true;
    }

    public ArrayList<Integer> getValues() {
        ArrayList<Integer> list = new ArrayList<>();
        Node node = head;
        while(node != null) {
            list.add(node.val);
            node = node.next;
        }
        return list;
    }
}


