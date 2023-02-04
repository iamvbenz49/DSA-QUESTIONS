class MyQueue {
    
    Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();

    public void push(int x) {
        if(stack1.empty()){
            stack1.push(x);
        }
        else{
            while(!stack1.empty()){
                stack2.push(stack1.pop());
            }
            stack1.push(x);
            while(!stack2.empty()){
                stack1.push(stack2.pop());
            }
        }
    }
    
    public int pop() {
        return stack1.pop();
    }
    
    public int peek() {
        int curr = stack1.pop();
        stack1.push(curr);
        return curr;
    }
    
    public boolean empty() {
        return stack1.empty() && stack2.empty();
    }
}
