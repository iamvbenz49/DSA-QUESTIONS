var mergeTwoLists = function(list1, list2) {
    let l1,l2,l3,head;
    l1 = list1
    l2 = list2
    head = new ListNode(0)
    l3 = head
    while(l1 && l2){
        if(l1.val>=l2.val){
            l3.next = l2
            l2 = l2.next
        }
        else{
            l3.next = l1
            l1 = l1.next
        }
        l3 = l3.next 
    }
    l3.next = l1 || l2
    return head.next
};
