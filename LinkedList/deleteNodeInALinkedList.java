//brute force
class Solution {
    public void deleteNode(ListNode node) {
        ListNode prev = null;
        while(node.next!=null){
            node.val = node.next.val;
            prev = node;
            node = node.next;
        }
        prev.next = null;
    }
}

//optimised
class Solution {
    public void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }
}
