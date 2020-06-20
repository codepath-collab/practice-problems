# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def removeNthFromEnd(self, head: ListNode, n: int) -> ListNode:
        '''
        example test case:
        1->2->3->4 n=2 so removing 3 to get 1->2->4
        
        plan:
        dummy->1->2->3->4->None
        - initially we want firstPointer @ dummy and secondPointer n+1 steps from firstPointer @ 3
        - the goal is to have n+1 steps between these pointers so at the end state:
            - firstPointer will be @ 2 and secondPointer will be at None
        (we want firstPointer to land @ 2 and not 3 so we can set 2.next to 2.next.next to drop 3)
        
        '''    
        if not head:
            return None
        
        #set pointers to dummy
        dummyNode = firstPointer = secondPointer = ListNode(None)
        dummyNode.next = head
        
        #move secondPointer n+1 steps forward from dummy
        for i in range(n+1):
            secondPointer = secondPointer.next
        
        #move both pointers forward until secondPointer reaches None
        while secondPointer:
            firstPointer = firstPointer.next
            secondPointer = secondPointer.next
        
        #drop the ListNode we are removing
        firstPointer.next = firstPointer.next.next
        
        return dummyNode.next