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
    public void reorderList(ListNode head) {
        /*
            [0, 1, 2, 3, 4, 5, 6]
            ---> 0, 1, 2, 3, 6, 5, 4
            [0, 6, 1, 5, 2, 4, 3]
            [0, n-1, 1, n-2, 2, n-3, ...]

            from middle, reverse the linked list
            go till i = len/3 
            then start reversing.
            i=3, curr = 4
            4 -> 5 -> 6
            store 5 in next. prev = null
            4 -> null curr = 5
            5 -> prev (4)
            6 -> 5 -> 4 -> null | 3 <- 2 <- 1

            
        */

        ListNode curr = head;
        ListNode slow = head;
        ListNode fast = head;

        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // slow is now at the mid

        ListNode prev = null;
        while(slow != null) {
            ListNode next = slow.next;
            slow.next = prev;
            prev = slow;
            slow = next;
        }

        ListNode first = head;
        ListNode second = prev;

        while(second.next != null) {
            ListNode temp1 = first.next;
            ListNode temp2 = second.next;

            first.next = second;
            second.next = temp1;

            first = temp1;
            second = temp2;
        }

    }
}
