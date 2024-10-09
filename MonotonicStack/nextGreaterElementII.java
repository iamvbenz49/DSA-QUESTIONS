class Solution {
    private int N;
    public int[] nextGreaterElements(int[] nums) {
        N = nums.length;
        int[] res = new int[N];
        Stack<Integer> stack = new Stack<>();
        findNGE(nums, stack, res);
        findNGE(nums, stack, res);
        return res;
    }
    public void findNGE(int[] nums, Stack<Integer> stack, int[] res) {
        for(int i = N - 1; i >= 0; i--) {
            if(stack.isEmpty()) {
                res[i] = -1;
            } else {
                while(!stack.isEmpty() && stack.peek() <= nums[i]) {
                    stack.pop();
                }
                if(stack.isEmpty()) {
                    res[i] = -1;
                } else {
                    res[i] = stack.peek();
                }
            }
            stack.add(nums[i]);
        }
    }
}