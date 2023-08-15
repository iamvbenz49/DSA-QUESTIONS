class Solution {
    public boolean isPalindrome(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        ListNode prev = null;
        while(fast!=null && fast.next!=null){
            fast = fast.next.next;
            ListNode temp = slow;
            slow = slow.next;
            temp.next = prev;
            prev = temp;
        }
        if(fast!=null){
            slow = slow.next;
        }
        while(prev!=null&&slow!=null){
            if(prev.val!=slow.val){
                return false;
            }
            prev = prev.next;
            slow = slow.next;
        }
        return true;
    }
}
