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
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) {
            // there is no duplicate if the list is empty or has only one node
            return head;
        }
        
        // a dummy node at the start of the list
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        // previous non-duplicate node
        ListNode prev = dummy;
        // current node
        ListNode current = head;

        while (current != null) {
            if (current.next != null && current.val == current.next.val) {
                while (current.next != null && current.val == current.next.val) {
                    // delete the following duplicates  
                    current.next = current.next.next;
                }
                
                // delete the first duplicate
                prev.next = current.next;
            } else {
                // if there are no duplicates, then move to the next node
                prev = current;
            }

            current = current.next;
        }

        return dummy.next;   
    }
}
