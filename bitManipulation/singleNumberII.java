//bit manipulation
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
