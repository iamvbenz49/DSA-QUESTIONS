class Solution {
    public int smallestDivisor(int[] nums, int threshold) {
        int start = 1;
        int end=0;
        for(int i=0;i<nums.length;i++){
            end = Math.max(nums[i],end);            
        }
        int ans = 0;
        while(start<=end){
            int mid = start + (end-start)/2;
            if(check(nums,threshold,mid)){
                ans = mid;
                end = mid-1;
            }
            else{
                start = mid+1;
            }
        }
        return ans;
    }
    public boolean check(int[] nums,int threshold,int divisor){
        int sum = 0;
        for(int i=0;i<nums.length;i++){
            sum += Math.ceil((float)nums[i]/(float)divisor);
        }
        return sum<=threshold;
    }
}
