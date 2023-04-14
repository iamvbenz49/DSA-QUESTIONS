class Solution {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        Stack<Integer> stack = new Stack<Integer>();
        int i =0;
        for(int val:pushed){
            stack.push(val);
            while(!stack.isEmpty() && popped[i]==stack.peek()){
                stack.pop();
                i++;
            }
        }
        return stack.isEmpty();
    }
}
