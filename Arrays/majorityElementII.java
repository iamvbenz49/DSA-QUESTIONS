class Solution {
    public List<Integer> majorityElement(int[] nums) {
        int ele1 = 0;
        int ele2 = 0;
        
        int count1 = 0;
        int count2 = 0;

        for(int i=0;i<nums.length;i++){
            if(count1==0&&ele2!=nums[i]){
                count1 =1;
                ele1 = nums[i];
            }
            else if(count2==0&&ele1!=nums[i]){
                count2 = 1;
                ele2 = nums[i];
            }
            else if(ele1==nums[i]){
                count1++;
            }
            else if(ele2==nums[i]){
                count2++;
            }
            else{
                count1--;
                count2--;
            }
        }
        List<Integer> list = new ArrayList<>();
        int count3 = 0;
        int count4 = 0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]==ele1){
                count3++;
            }
            else if(nums[i]==ele2){
                count4++;
            }
        }
        System.out.print(ele1+" "+ele2);
        if(count3>nums.length/3){
            list.add(ele1);
        }
        if(count4>nums.length/3){
            list.add(ele2);
        }
        return list;
    }
}
