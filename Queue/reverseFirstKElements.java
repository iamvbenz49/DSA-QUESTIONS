class GfG {
    // Function to reverse first k elements of a queue.
    public Queue<Integer> modifyQueue(Queue<Integer> q, int k) {
        // add code here.
        Queue<Integer> queue = new LinkedList<>();
        Stack<Integer> stack = new Stack<>();
        while(k--!=0 && !q.isEmpty())
            stack.add(q.poll());
        while(!q.isEmpty())
            queue.add(q.poll());
        while(!stack.isEmpty())
            q.add(stack.pop());
        while(!queue.isEmpty())
            q.add(queue.poll());
        
        return q;
    }
}
