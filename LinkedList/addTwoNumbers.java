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
        ListNode head = new ListNode();
        int carry = 0;
        ListNode dummy = head;
        while(l1!=null && l2!=null){
            ListNode node = new ListNode();
            int sum = l1.val + l2.val + carry;
            node.val = sum%10;
            dummy.next = node;
            dummy = dummy.next;

            l1 = l1.next;
            l2 = l2.next;
            carry = sum/10;
        }
        while(l1!=null){
            int  sum = l1.val + carry;
            ListNode node = new ListNode(sum%10);
            carry = sum/10;
            dummy.next = node;
            dummy = dummy.next;
            l1 = l1.next;
        }
        while(l2!=null){
            int sum =  l2.val + carry;
            ListNode node = new ListNode(sum%10);
            carry = sum/10;
            dummy.next = node;
            dummy = dummy.next;
            l2 = l2.next;
        }
        if(carry!=0){
            ListNode node = new ListNode(carry);
            dummy.next = node;
        }

        return head.next;
    }
}
