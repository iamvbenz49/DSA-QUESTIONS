
class Solution {
    public ListNode removeNodes(ListNode head) {
        ListNode prev=null,curr = head,next=null;
        
        head = reverse(curr,prev,next);
        prev = head;
        curr = head;
        int max = 0;
        while(curr!=null){
            max = Math.max(max,curr.val);
            if(curr.val<max){
                prev.next = curr.next;
            }
            else{
                prev = curr;
            }
            curr = curr.next;
        }
        prev = null;next = null;
        return reverse(head,prev,next);
    }
    public ListNode reverse(ListNode curr,ListNode prev,ListNode next){
        while(curr!=null){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }
}
