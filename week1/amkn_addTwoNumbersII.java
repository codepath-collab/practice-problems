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
        // turn the first list into a stack
        Stack<Integer> s1 = listToStack(l1);
        // turn the second list into a stack
        Stack<Integer> s2 = listToStack(l2);
        // a stack to store values of nodes in the list to return
        Stack<Integer> sum = new Stack<>();
        ListNode dummy = new ListNode(0);
        // current node
        ListNode current = dummy;
        // carry from previous summation
        int carry = 0;

        while (s1.size() > 0 || s2.size() > 0 || carry == 1) {
            // current digit
            int currentVal = carry;

            if (s1.size() > 0) {
                currentVal += s1.pop();
            }

            if (s2.size() > 0) {
                currentVal += s2.pop();
            }

            if (currentVal > 9) {
                // carry over to the next summation if the result is greater than 9
                currentVal %= 10;
                carry = 1;
            } else {
                carry = 0;
            }

            sum.push(currentVal);
        }

        while (sum.size() > 0) {
            // turn the stack into a list
            current.next = new ListNode(sum.pop());
            current = current.next;
        }
    
        return dummy.next;
    }
    
    // turn a list into a stack
    public Stack<Integer> listToStack(ListNode l) {
        Stack<Integer> toReturn = new Stack<>();
        ListNode current = l;

        while (current != null) {
            toReturn.push(current.val);
            current = current.next;
        }

        return toReturn;
    }
}
