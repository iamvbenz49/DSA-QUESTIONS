var addTwoNumbers = function(l1, l2) {
    let head = new ListNode()
    let current = head
    
    let carry = 0
    while(l1 !== null || l2!== null ||carry!= 0){
        let v1,v2,sum;
        if(l1 !== null){
              v1 = l1.val
        }
        else{
            v1 = 0
        }
        if(l2 !== null){
            v2 = l2.val
        }
        else{
            v2 = 0
        }
        sum = v1 + v2 + carry
        carry = Math.floor(sum/10) 
        sum = sum%10
        current.next = new ListNode(sum)
        current = current.next
        if(l1){l1 = l1.next}
        if(l2){l2 = l2.next}
    }
    return head.next
};
