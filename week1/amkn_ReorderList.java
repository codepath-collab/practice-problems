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
        if (head == null || head.next == null) {return;}
        
        // creating a list containing the fist left elements of the list using the two pointers approach
        ListNode slow = head;
        ListNode fast = head.next;
        ListNode firstList = head;
        ListNode current = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            current.next = slow;
            current = current.next;
            fast = fast.next.next;
        }

        // reversing the second half of the list
        ListNode next = reverseList(slow.next);

        current.next = null;

        // merging the two lists
        head = mergeList(firstList, next);    
    }
    
    // merging two lists
    public ListNode mergeList(ListNode l1, ListNode l2) {
        ListNode first = l1;
        ListNode second = l2;
        ListNode toReturn = new ListNode(0);
        ListNode current = toReturn;

        while (first != null || second != null) {
            if (first != null) {
                current.next = first;
                current = current.next;
                first = first.next;
            }

            if (second != null) {
                current.next = second;
                current = current.next;
                second = second.next;
            }
        }

        return toReturn.next;
    }

    // reverse a list
    public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode current = head;

        while (current != null) {
            ListNode nextNode = current.next;
            current.next = prev;
            prev = current;
            current = nextNode;
        }

        head = prev;
        return head;
    }
}




