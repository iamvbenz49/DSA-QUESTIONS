class Solution {
    public ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {
        ListNode org_start,org_end,new_start,new_end;
        ListNode head = list1;
        b = b-a+1;
        while(a!=1){
            a--;
            list1 = list1.next;
        }
        org_start = list1;
        while(b!=0){
            b--;
            list1 = list1.next;
        }
        org_end = list1;
        new_start = list2;
        while(list2.next!=null){
            list2 = list2.next;
        }
        new_end = list2;
        org_start.next = new_start;
        new_end.next = org_end.next;
        return head;
    }
}
