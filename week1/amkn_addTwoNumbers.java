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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = null;         // the ListNode to be returned
        ListNode current = null;      // the current ListNode
        boolean toAdd = false;        // true if we need to add 1 from the previous ListNode 
        int iteration = 0;            // iteration == 0 if and only if this is the first iteration
        
        while (l1 != null || l2 != null || toAdd) {
            // continue adding if either we have not reached the end of any list or if we still have to
            // add 1 from previous ListNode
                
            int currentVal = 0;       // current value 
            
            if (toAdd == true) {
                // plus 1 if we need to add from previous ListNode
                currentVal += 1;
            }
            
            if (l1 == null && l2 != null) {
                // add from the second list if we have reached the end of the first list
                currentVal += l2.val;
                l2 = l2.next;
            } else if (l2 == null && l1 != null) {
                // add from the first list if we have reached the end of the second list
                currentVal += l1.val;
                l1 = l1.next;
            } else if (l1 != null && l2 != null) {
                // add from both lists
                currentVal += l1.val + l2.val;
                l1 = l1.next;
                l2 = l2.next;
            }
            
            if (currentVal > 9) {
                // have to add 1 to the next ListNode since the current value is greater than 9
                currentVal %= 10;
                toAdd = true;
            } else {
                toAdd = false;
            }
            
            if (iteration == 0) {
                // define the head to be returned if this is the first iteration
                head = new ListNode(currentVal);
                current = head;
                iteration++;
            } else {
                // create the ListNode for the current value and move to the next one
                current.next = new ListNode(currentVal);
                current = current.next;
            }
            
        }
        
        return head;
    }
}
