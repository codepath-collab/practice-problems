/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode detectCycle(ListNode head) {
        // current ListNode
        ListNode current = head;
        // a set for all the ListNode that have been seen
        Set<ListNode> seen = new HashSet<>();

        while (current != null) {
            if (seen.contains(current)) {
                // the first one to be seen again is the start of the cycle
                return current;
            }
            
            // add ListNode to the seen set
            seen.add(current);
            // move to the next ListNode
            current = current.next;
        }
        
        // return null when there is no cycle
        return null;
    }
}
