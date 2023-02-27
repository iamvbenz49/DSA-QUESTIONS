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
    public ListNode swapNodes(ListNode head, int k) {
        ListNode fast = head;
        ListNode slow = head;
        for(int i=1;i<k;i++)
            fast = fast.next;
        ListNode n1 = fast;
        while(fast.next!=null){
            fast=fast.next;
            slow = slow.next;
        }
        ListNode n2 = slow;
        int temp = n2.val;
        n2.val = n1.val;
        n1.val = temp;
        return head;
    }
}
