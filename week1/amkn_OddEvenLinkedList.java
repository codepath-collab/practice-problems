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
    public ListNode oddEvenList(ListNode head) {
        // current node
        ListNode current = head;
        // dummy node for the list of odd nodes
        ListNode oddDummy = new ListNode(0);
        // first node of the list of odd nodes
        ListNode toReturnOdd = oddDummy;
        // dummy node for the list of even nodes
        ListNode evenDummy = new ListNode(0);
        // first node of the list of even nodes
        ListNode toReturnEven = evenDummy;

        while (current != null) {
            // adding the current node to the list of odd nodes
            oddDummy.next = current;
            oddDummy = oddDummy.next;
            
            if (current.next != null) {
                // adding the next node to the list of even nodes
                evenDummy.next = current.next;
                evenDummy = evenDummy.next;
                // move to the next odd node if there are nodes left
                current.next = current.next.next;
            } else {
                // end the list of even nodes
                evenDummy.next = null;
            }

            // move to the next node
            current = current.next;
        }

        // merge the list of odd nodes and the list of even nodes
        oddDummy.next = toReturnEven.next;

        return toReturnOdd.next;           
    }
}
