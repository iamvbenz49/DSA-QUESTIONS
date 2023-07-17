//reversing LInked List
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
        ListNode revHead1 = reverseLinkedList(l1);
        ListNode revHead2 = reverseLinkedList(l2);

        return reverseLinkedList(add(revHead1,revHead2));
    }
    public ListNode reverseLinkedList(ListNode head){
        ListNode curr = head;
        ListNode prev = null;
        while(curr!=null){
            ListNode temp = curr;
            curr = curr.next;
            temp.next = prev;
            prev = temp;
        }
        return prev;
    }
    public ListNode add(ListNode l1, ListNode l2) {
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
//using stacks
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
        Stack<ListNode> stack1 = new Stack<>();
        Stack<ListNode> stack2 = new Stack<>();
        Stack<ListNode> resStack = new Stack<>();
        while(l1!=null){
            stack1.add(l1);
            l1 = l1.next;
        }
        while(l2!=null){
            stack2.add(l2);
            l2 = l2.next;
        }

        int carry = 0;
        while(!stack1.isEmpty() && !stack2.isEmpty()){
            ListNode node = new ListNode();
            int sum = stack1.pop().val + stack2.pop().val + carry;
            node.val = sum%10;
            resStack.add(node);
            carry = sum/10;
        }
        while(!stack1.isEmpty()){
            int  sum = stack1.pop().val + carry;
            ListNode node = new ListNode(sum%10);
            resStack.add(node);
            carry = sum/10;
        }
        while(!stack2.isEmpty()){
            int sum =  stack2.pop().val + carry;
            ListNode node = new ListNode(sum%10);
            resStack.add(node);
            carry = sum/10;
        }
        if(carry!=0){
            ListNode node = new ListNode(carry);
            resStack.add(node);
        }
        ListNode head = new ListNode();
        ListNode dummy = head;
        while(!resStack.isEmpty()){
            dummy.next= resStack.pop();
            dummy = dummy.next;
        }
        return head.next;
    }
}
