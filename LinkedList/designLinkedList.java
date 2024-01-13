class MyLinkedList {
    class Node{
        int data;
        Node next;
        public Node(int data){
            this.data = data;
            this.next = null;
        }
    }
    Node head;
    int size;
    public MyLinkedList() {
        this.head = null;
        this.size = 0;
    }
    
    public int get(int index) {
        System.out.println(this.size);
        if(size<=index)return -1;
        Node temp = this.head;
        while(temp!=null && index!=0){
            temp = temp.next;
            index--;
        }
        return temp.data;
    }
    
    public void addAtHead(int val) {
        Node node = new Node(val);
        if(this.head!=null)
            node.next = this.head;
        this.head = node;
        this.size++;
    }
    
    public void addAtTail(int val) {
        if(this.size==0){
            this.addAtHead(val);
            return;
        }
        Node temp = this.head;
        while(temp.next!=null)
            temp = temp.next;
        temp.next = new Node(val);
        this.size++;
    }
    public void addAtIndex(int index, int val) {
        if(size<index)return;
        if(index==0){
            this.addAtHead(val);
            return;
        }
        if(index==size){
            this.addAtTail(val);
            return;
        }
        Node temp = head, node = new Node(val);
        while(index!=1){
            temp = temp.next;
            index--;
        }
        node.next = temp.next;
        temp.next = node;
        this.size++;
    }
    
    public void deleteAtIndex(int index) {
        if(index>=size)return;
        if(index==0){
            this.head = this.head.next;
            this.size--;
            return;
        }
        Node temp = head;
        while(index!=1){
            temp = temp.next;
            index--;
        }
        temp.next = temp.next.next;
        this.size--;
    }
}
