class MyStack {
    private int size;
    private Queue<Integer> q;
    public MyStack() {
        this.size = size;
        this.q = new LinkedList<>();
    }
    
    public void push(int x) {
        int tempSize = this.size;
        this.q.offer(x);
        while(tempSize-- > 0) {
            this.q.offer(this.q.poll());
        }
        this.size++;
    }
    
    public int pop() {
        this.size--;
        return this.q.poll();
    }
    
    public int top() {
        return this.q.peek();
    }
    
    public boolean empty() {
        return this.size == 0;
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */