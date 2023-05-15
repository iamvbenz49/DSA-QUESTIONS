//stack + two pointers 
class Solution {
    public int pairSum(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        Stack<Integer> stack = new Stack<Integer>();
        while(fast!=null && fast.next!=null){
            stack.push(slow.val);
            fast = fast.next.next;
            slow = slow.next;
        }
        int max = 0;
        while(!stack.isEmpty()){
            max = Math.max(slow.val+stack.pop(),max);
            slow = slow.next;
        }
        return max;
    }
}

//reversing half of a linked list using fast and slow pointer then adding the sum from slow pointer and prev pointer
class Solution {
    public int pairSum(ListNode head) {
        ListNode prev = null;
        ListNode next = null;
        ListNode fast = head;
        ListNode slow = head;
        while(fast!=null && fast.next!=null){
            fast = fast.next.next;
            next = slow.next;
            slow.next = prev;
            prev = slow;
            slow = next;
        }
        int sum = 0;
        while(prev!=null){
            sum = Math.max(prev.val+slow.val,sum);
            prev = prev.next;
            slow = slow.next;
        }
        return sum;
    }
}
