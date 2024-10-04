class Solution {
    public int maximalRectangle(char[][] matrix) {
        int rows = matrix.length, cols = matrix[0].length;
        int maxArea = 0;
        int[] heights = new int[cols];
        for(int i = 0; i < rows; i++) {
            Stack<Integer> stack = new Stack<>();
            for(int j = 0; j < cols; j++) {
                if(matrix[i][j] == '1') {
                    heights[j]++;
                } else {
                    heights[j] = 0;
                }
                if(stack.isEmpty() || heights[j] >= heights[stack.peek()]) {
                    stack.push(j);
                } else {
                    while(!stack.isEmpty() && heights[j] < heights[stack.peek()]) {
                        int top = stack.pop();
                        if(stack.empty()) {
                            maxArea = Math.max(maxArea, heights[top] * j);
                        } else {
                            maxArea = Math.max(maxArea, heights[top] * ( j - (stack.peek() + 1) ));
                        }
                    }
                    stack.push(j);
                }
            }
            while(!stack.isEmpty()) {
                int top = stack.pop();
                if(stack.isEmpty()) {
                    maxArea = Math.max(maxArea, heights[top] * cols);
                } else {
                    maxArea = Math.max(maxArea, heights[top] * ( cols - (stack.peek() + 1) ));
                }
            }
        }
        return maxArea;
    }
}