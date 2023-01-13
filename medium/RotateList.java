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
    public ListNode rotateRight(ListNode head, int k) {
        if(head==null||head.next==null)return head;
        ListNode slow = head;
        ListNode fast = head;
        //find the fast pointer
        while(k>0){
            if(fast.next==null){fast=head;}
            else{fast=fast.next;}
            k--;
        }
        while(fast.next!=null){
            fast=fast.next;
            slow=slow.next;
        }
        fast.next=head;
        head = slow.next;
        slow.next=null;
        return head;
    }
}
