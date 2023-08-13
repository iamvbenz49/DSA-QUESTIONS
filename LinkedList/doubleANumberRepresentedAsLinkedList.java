class Solution:
    def doubleIt(self, head: Optional[ListNode]) -> Optional[ListNode]:
        def double(head,res):
            if not head:
                return res*2
            curr = double(head.next,(res*10)+head.val)
            head.val = curr%10
            return curr//10
        temp =head
        res = double(temp,0)
        node = ListNode(res)
        if res:
            node.next = head
            head = node
        return head
