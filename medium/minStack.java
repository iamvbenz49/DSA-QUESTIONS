class MinStack {
    int curr = 0;
    int[] arr;
    int minVal = Integer.MAX_VALUE;
    Node head;
    public MinStack() {
        this.arr = new int[3*1000];
    }
    
    public void push(int val) {
        if(head==null)
            head = new Node(val,val,null);
        else
           head = new Node(val,Math.min(head.min,val),head); 
    }
    
    public void pop() {
        head = head.prev;
    }
    
    public int top() {
        return head.data;
    }
    
    public int getMin() {
        return head.min;
    }
    private class Node{
        int data;
        int min;
        Node prev;
        public Node(int data,int min,Node prev){
            this.data = data;
            this.min = min;
            this.prev = prev;
        }
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
