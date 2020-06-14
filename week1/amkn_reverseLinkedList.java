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
        if (head == null) {
            // return null if the head is null
            return head;
        }
        
        // previous ListNode
        ListNode prev = null;
        
        // current ListNode
        ListNode current = head;
        
        while (current.next != null) {
            // the following ListNode
            ListNode nextNode = current.next;
            // reverse the pointer
            current.next = prev;
            // move the previous ListNode to the next ListNode
            prev = current;
            // change the current ListNode into the following ListNode
            current = nextNode;
        }
        
        // reverse the pointer of the last ListNode
        current.next = prev;
                
        return current;
    }
    
}
