class Solution {
    public long minCost(int[] nums, int[] cost) {
        int left = nums[0];
        int right = nums[0];
        long ans = 0;
        for(int i=0;i<nums.length;i++){
            left = Math.min(left,nums[i]);
            right = Math.max(right,nums[i]);
        }
        while(left<right){
            int mid = (left+right)/2;
            long calc1 = calculate(nums,cost,mid);
            long calc2 = calculate(nums,cost,mid+1);
            if(calc1>calc2){
                left = mid+1;
                ans = calc2;
            }
            else{
                right = mid;
                ans = calc1;
            }
        }
        return ans;
    }
    public long calculate(int[] nums,int[] cost,int change){
        long total = 0;
        for(int i=0;i<nums.length;i++){
            total += 1L*Math.abs(nums[i]-change)*cost[i];
            //here nums[i]-change denotes the magnitude of increase or decrease
        }
        return total;
    }
}
