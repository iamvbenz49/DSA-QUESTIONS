class Solution
{
    public static Node addOne(Node head) 
    { 
        //code here.
        int rem = add1(head);
        if(rem==1){
            Node node = new Node(1);
            node.next = head;
            return node;
        }
        return head;
    }
    public static int add1(Node head){
        if(head.next==null){
            head.data = (head.data+1);
            int rem = head.data/10;
            head.data = head.data%10;
            return rem;
        }
        int rem = add1(head.next);
        head.data = head.data + rem;
        if(head.data>9){
            head.data = head.data%10;
            return 1;
        }
        return 0;
    } 
}
