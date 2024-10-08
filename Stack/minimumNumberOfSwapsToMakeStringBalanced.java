class Solution {
    public int minSwaps(String s) {

        // We can discard the balanced components from our input string as they will not matter in 
        // balancing the string. Now, after excluding them, we will find that all the unbalanced brackets look like this:

        // ]]]]]…..[[[[[…..

        // Now, since we can swap any pair of brackets, the optimal approach is to balance 2 sets of brackets at a time using 1 swap (hinting at result = total unbalanced / 2, which we will handle for even and odd lengths together). Take 
        Stack<Integer> stack = new Stack<>();
        int mismatch = 0;
        for(int i = 0;i < s.length(); i++) {
            char c = s.charAt(i);
            if(c == '[') {
                stack.add(i);
            } else {
                if(!stack.isEmpty()) {
                    stack.pop();
                } else {
                    mismatch++;
                }
            }
        }
        return (mismatch + 1)/2;
    }
}