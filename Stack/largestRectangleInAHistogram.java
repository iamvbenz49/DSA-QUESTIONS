class Solution {
    public int largestRectangleArea(int[] heights) {
        int n = heights.length, maxArea = 0;
        Stack<Integer> stack = new Stack<>();
        for(int i = 0; i < n; i++) {
            while(!stack.isEmpty() && heights[i] < heights[stack.peek()]) {
                int top = stack.pop();
                if(stack.isEmpty()) {
                    maxArea = Math.max(maxArea, heights[top] * i);
                } else {
                    maxArea = Math.max(maxArea, heights[top] * (i - (stack.peek() + 1)));
                }
            }
            stack.push(i);
        }

        while(!stack.isEmpty()) {
            int top = stack.pop();
            if(stack.isEmpty()) {
                maxArea = Math.max(maxArea, heights[top] * n);
            } else {
                maxArea = Math.max(maxArea, heights[top] * (n - (stack.peek() + 1)));
            }
        }
        return maxArea;
    }
}