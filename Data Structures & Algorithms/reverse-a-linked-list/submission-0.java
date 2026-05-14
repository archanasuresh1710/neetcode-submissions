/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

class Solution {
    public ListNode reverseList(ListNode head) {
        /*
        Input: head = [0,1,2,3]

        Output: [3,2,1,0]
        */

        ListNode curr = head;
        ListNode prev = null;
        ListNode next = null;

        while(curr != null) {
            next = curr.next; // 1,2
            curr.next = prev; // 1-> 0 -> null
            prev = curr; // 0, 1
            curr = next; // 1, 2
        }

        return prev;
    }
}
