class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int M = nums1.length, N = nums2.length;
        Map<Integer, Integer> map = new HashMap<>();
        Stack<Integer> stack = new Stack<>();
        int[] res = new int[M];
        
        for(int i = N - 1; i >= 0; i--) {
            if(stack.isEmpty()) {
                map.put(nums2[i], -1);
            } else {
                while(!stack.isEmpty() && nums2[i] > stack.peek()) {
                    stack.pop();
                }
                if(!stack.isEmpty()) {
                    map.put(nums2[i], stack.peek());
                } else {
                    map.put(nums2[i], -1);
                }
            }
            stack.add(nums2[i]);
        }
        for(int i = 0; i < M; i++) {
            res[i] = map.get(nums1[i]);
        }
        return res;
    }
}