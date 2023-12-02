// TC - O(N) SC- O(N)
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        Set<ListNode> set = new HashSet<>();
        while(headA!=null){
            set.add(headA);
            headA = headA.next;
        }
        while(headB!=null){
            if(set.contains(headB)){
                return headB;
            }
            headB = headB.next;
        }
        return null;
    }
}
// TC - O(M+N)
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int LengthA = 0;
        int LengthB = 0;
        ListNode tempA = headA,tempB = headB;
        while(tempA!=null){
            LengthA++;
            tempA = tempA.next;
        }
        while(tempB!=null){
            LengthB++;
            tempB = tempB.next;
        }
        if(tempA!=tempB)return null;
        while(LengthA>LengthB){
            headA = headA.next;
            LengthA--;
        }
        while(LengthA<LengthB){
            headB = headB.next;
            LengthB--;
        }
        while(headA!=headB){
            headA = headA.next;
            headB = headB.next;
        }
        return headA;
    }
}
//single loop
public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
    if(headA == null || headB == null) return null;
    
    ListNode a = headA;
    ListNode b = headB;
    
    while( a != b){
        a = a == null? headB : a.next;
        b = b == null? headA : b.next;    
    }
    
    return a;
}
// https://leetcode.com/problems/intersection-of-two-linked-lists/solutions/49785/java-solution-without-knowing-the-difference-in-len/comments/165648
