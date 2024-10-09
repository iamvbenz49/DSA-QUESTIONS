class Solution {
    private int MOD = (int)1e9 + 7;
    public int sumSubarrayMins(int[] arr) {
        int N = arr.length;
        int[] leftSmallerElements = new int[N];
        int[] rightSmallerElements = new int[N];
        Stack<Integer> stack = new Stack<>();
        for(int i = 0; i < N; i++) {
            while(!stack.isEmpty() && arr[stack.peek()] > arr[i]) stack.pop();

            if(stack.isEmpty()) {
                leftSmallerElements[i] = i + 1;
            } else {
                leftSmallerElements[i] = i - stack.peek();
            }
            stack.add(i);
        }


        stack = new Stack<>();

        for(int i = N - 1; i >= 0; i--) {
            while(!stack.isEmpty() && arr[stack.peek()] >= arr[i]) stack.pop();

            if(stack.isEmpty()) {
                rightSmallerElements[i] = N - i;
            } else {
                rightSmallerElements[i] = stack.peek() - i;
            }
            stack.add(i);
        }
      
        long res = 0;
        for(int i = 0; i < N; i++) {
            long possibleWays = (
                leftSmallerElements[i] * rightSmallerElements[i]
            )%MOD;

            possibleWays = (possibleWays * arr[i])%MOD;
            res = (res + possibleWays)%MOD;
        }
        return (int)res;
    }
}