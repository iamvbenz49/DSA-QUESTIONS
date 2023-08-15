class Solution {
    public ListNode partition(ListNode head, int x) {
        ListNode left = new ListNode(0);
        ListNode right = new ListNode(0);
        ListNode tempLeft = left;
        ListNode tempRight = right;
        while(head!=null){
            if(head.val<x){
                left.next = head;
                left = left.next;
            }
            else{
                right.next = head;
                right = right.next;
            }
            head = head.next;
        }
        left.next = tempRight.next;
        right.next = null;
        return tempLeft.next;
    }
}
