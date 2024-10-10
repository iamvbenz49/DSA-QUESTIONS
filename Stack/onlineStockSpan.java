class StockSpanner {
    class Cell {
        private int index, val; 
        public Cell(int index, int val) {
            this.index = index;
            this.val = val;
        }
    }
    Stack<Cell> stack = new Stack<>();
    private int numberOfCalls;
    public StockSpanner() {
        this.stack = new Stack<>();
        this.numberOfCalls = 0;
    }
    
    public int next(int price) {
        while(!this.stack.isEmpty() && stack.peek().val <= price) {
            stack.pop();
        }
        int res;
        if(stack.isEmpty()) {
            res  = this.numberOfCalls + 1;
        } else {
            System.out.println(this.numberOfCalls + " " + stack.peek().index);
            res = this.numberOfCalls - stack.peek().index;
        }
        stack.add(new Cell(numberOfCalls, price));
        this.numberOfCalls++;
        return res;
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */