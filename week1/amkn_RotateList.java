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
    public ListNode rotateRight(ListNode head, int k) {
        // current ListNode
        ListNode current = head;
        
        if (current == null) {
            // return null if the head is null
            return current;
        }
        
        // length of the list
        int len = 1;

        while (current.next != null) {
            // caculate length of the list
            len++;
            current = current.next;
        }

        // connect the end of the list to its head
        current.next = head;

        if (k > len) {
            // caculate how many items in the list we should move backwards
            k %= len;
        }

        // number of items we should move from the original head to get to the new head
        int target = len - k;
        // pointer to the current item in the list
        int pointer = 0;

        current = head;

        while (pointer < target) {
            // move to the new head
            current = current.next;
            pointer++;
        }

        pointer = 0;
        // head to be returned
        ListNode toReturn = current;

        while (pointer < len - 1) {
            // traverse through the whole new list
            current = current.next;
            pointer++;
        }

        // end the list by breaking the circle
        current.next = null;

        return toReturn;    
    
    }
}
