class Solution {
    public int jump(int[] nums) {
        int howFarCanIGo = 0, jumps = 0, currentMax = 0;
        for(int i=0;i<nums.length-1;i++){
            howFarCanIGo = Math.max(howFarCanIGo,i+nums[i]);
            if(i==currentMax){
                currentMax = howFarCanIGo;
                jumps++;
            }
        }
        return jumps;
    }
}
