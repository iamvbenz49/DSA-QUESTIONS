class Solution {
    public ListNode oddEvenList(ListNode head) {
        ListNode left = new ListNode(0);
        ListNode right = new ListNode(0);
        ListNode tl = left,tr = right;
        int now = 1;
        while(head!=null){
            if(now%2==1){
                left.next = head;
                left = left.next;
            }
            else{
                right.next = head;
                right = right.next;
            }
            now++;
            head = head.next;
        }
        left.next = tr.next;
        right.next = null;
        return tl.next;
    }
}
