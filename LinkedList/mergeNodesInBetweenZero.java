
class Solution {
    public ListNode mergeNodes(ListNode head) {
        ListNode temp = head;
        ListNode prev = head;
        head = head.next;
        int s = 0;
        while(head!=null){
            if(head.val==0){
                head.val = s;
                prev.next = head;
                prev = head;
                s = 0;
            }
            else{
                s = s + head.val;
            }
            head = head.next;
        }
        return temp.next;
    }
}
