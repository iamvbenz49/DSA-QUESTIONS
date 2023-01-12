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
    public ListNode swapPairs(ListNode head) {
        ListNode temp = head;
        ListNode prev = null;
        if(temp!=null && temp.next!=null)head= head.next;
        while(temp!=null && temp.next!=null){
            ListNode curr = temp.next;
            if(prev!=null)prev.next = curr;
            temp.next = curr.next;
            curr.next = temp;
            prev = temp;
            temp = temp.next;
        }
        return head;
    }
}
