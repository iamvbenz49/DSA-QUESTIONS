//O(2*n) + o(1)

class Solution {
    public void sortColors(int[] nums) {
        int zeros = 0;
        int ones = 0;
        int twos = 0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]==0){
                zeros++;
            }
            else if(nums[i]==1){
                ones++;
            }
            else{
                twos++;
            }
        }
        for(int i=0;i<nums.length;i++){
            if(zeros-- >0){
                nums[i]=0;
            }
            else if(ones-- >0){
                nums[i]=1;
            }
            else{
                nums[i]=2;
            }
        }
    }
}

//O(N) + O(1) Dutch National Flag
class Solution {
    public void sortColors(int[] nums) {
        int low = 0;
        int mid = 0;
        int high = nums.length-1;
        while(mid<=high){
            if(nums[mid]==0){
                int temp = nums[low];
                nums[low] = nums[mid];
                nums[mid] = temp;
                low++;
                mid++;
            }
            else if(nums[mid]==1){
                mid++;
            }
            else{
                int temp = nums[mid];
                nums[mid] = nums[high];
                nums[high] = temp;
                high--;
            }
        }
    }
}
