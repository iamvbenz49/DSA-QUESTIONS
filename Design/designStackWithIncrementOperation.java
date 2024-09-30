class CustomStack {
    int[] increment;
    Stack<Integer> stack;
    int size;
    public CustomStack(int maxSize) {
        this.size = maxSize;
        this.stack = new Stack<>();
        this.increment = new int[maxSize];
    }
    
    public void push(int x) {
        if(this.stack.size() < this.size) {
           this.stack.push(x);
        }
    }
    
    public int pop() {
        if(stack.size() == 0) return -1;
        int currentSize = this.stack.size();
        int res = this.stack.pop() + this.increment[currentSize-1];
        if(currentSize > 1) {
            this.increment[currentSize - 2] += this.increment[currentSize - 1];
        }
        this.increment[currentSize - 1] = 0;
        return res;
    }
    
    public void increment(int k, int val) {
        if(stack.size() == 0) return;
        int max = Math.min(k, this.stack.size());
        this.increment[max - 1] += val;
    }
}

// Explanation

// Use an additional array to record the increment value.
// inc[i] means for all elements stack[0] ~ stack[i],
// we should plus inc[i] when popped from the stack.
// Then inc[i-1]+=inc[i],
// so that we can accumulate the increment inc[i]
// for the bottom elements and the following pops.

// Complexity

// C++/Python, initialization is O(1) time & space.
// Java, initialization is O(N) time & space.
// (We cam use ArrayList, but shrug)
// push, pop, increment, all O(1) time and space.