class MyQueue {
    Stack<Integer> enqueue, dequeue;
    public MyQueue() {
        this.enqueue = new Stack<>();
        this.dequeue = new Stack<>();
    }
    
    public void push(int x) {
        this.enqueue.push(x);
    }
    
    public int pop() {
        if(this.dequeue.isEmpty())
            change();
        return this.dequeue.pop();
    }
    
    public int peek() {
        if(this.dequeue.isEmpty())
            change();
        return this.dequeue.peek();
    }
    
    public boolean empty() {
        return this.enqueue.isEmpty() && this.dequeue.isEmpty();
    }

    public void change(){
        while(!this.enqueue.isEmpty()){
            this.dequeue.add(this.enqueue.pop());
        }
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */
