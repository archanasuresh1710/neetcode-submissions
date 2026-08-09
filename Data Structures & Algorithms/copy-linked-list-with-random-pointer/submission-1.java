/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {

    private Map<Node, Node> map = new HashMap<>();

    public Node copyRandomList(Node head) {
        
        Node dummy = new Node(0);
        Node newHead = dummy;
        Node curr = head;
        
        while(curr != null) {

            Node node = createCopy(curr);

            newHead.next = node;
            newHead = newHead.next;
            curr = curr.next;
        }

        return dummy.next;
    }

    private Node createCopy(Node node) {

        if(node == null) return null;

        if(map.containsKey(node)) return map.get(node);

        Node n = new Node(node.val);
        map.put(node, n);
        
        n.next = createCopy(node.next);
        n.random = createCopy(node.random);

        
        return n;
    }
}
