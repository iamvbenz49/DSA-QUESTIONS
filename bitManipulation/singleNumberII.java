//bit manipulation
//Let us consider the array [2,2,2,3,4,4,4]
// 2 --> 010
// 2 --> 010
// 2 --> 010
// 3 --> 011
// 4 --> 100
// 4 --> 100  here when you add the bits it should be a multiple of three if not it is an extra bit by
// 4 --> 100  by doing mod operation on that sum of bits we can get the ith bit
//     -------
//      3 4 1
//     -------
//      0 1 1 After doing mod operation 
//     -------
// 4 --> 0 1 1 by this approach we will find the integer that occur exactly once


class Solution {
    public int singleNumber(int[] nums) {
        int ans = 0;
        for(int i=0;i<32;i++){
            int sum = 0;
            for(int j =0;j<nums.length;j++){
                if((nums[j]&1)==1){
                    sum++;
                    sum%=3;
                }
                nums[j]>>=1;
            }
            if(sum!=0){
                ans|= sum<<i;
            }  
        }
        return ans;
    }
}


//bit magic
class Solution {
    public int singleNumber(int[] nums) {
        int ones = 0;
        int twos = 0;
        //&~twos nums[i] is not in ones
        //&~ones nums[i] is not in twos
        for(int i=0;i<nums.length;i++){
            ones = (ones^nums[i])&~twos;
            twos = (twos^nums[i])&~ones;
        }
        return ones;
    }
}
