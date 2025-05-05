class Solution {
    public int[] singleNumber(int[] nums) {
        // find the overall xor
        // find the Right most bit which is one
        // which indicates that at that pos 0 and 1 are found in the number
        // then group them into two numbers based on that position
        
        int xor = nums[0];

        for(int i = 1; i < nums.length; i++) {
            xor ^= nums[i];
        }

        int diff_in_pos = 0;
        while(((xor >> diff_in_pos) & 1) != 1) {
            diff_in_pos++;
        }

        int first = 0, second = 0;

        for(int number: nums) {
            if(((number >> diff_in_pos) & 1) == 1) {
                first ^= number;
            } else {
                second ^= number;
            }
        }

        return new int[]{first, second};
    }
}