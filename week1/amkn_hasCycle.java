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
    public boolean hasCycle(ListNode head) {
        // all the ListNode that have been seen
        Set<ListNode> seen = new HashSet<>();
        
        while (head != null) {
            
            if (seen.contains(head)) {
                // there is a cycle if the node has been seen
                return true;
            } else {
                // add the node to the set of the ListNode that have been seen
                seen.add(head);
            }
            
            // move to the next ListNode
            head = head.next;
            
        }
        
        // there is no cycle
        return false;
    }
}
