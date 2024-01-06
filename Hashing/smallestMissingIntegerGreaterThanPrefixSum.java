class Solution {
    public int missingInteger(int[] nums) {
        int ptr = 1, sum = nums[0];
        Set<Integer> set = new HashSet<>();
        while(ptr<nums.length){
            if(nums[ptr-1]+1!=nums[ptr])
                break;
            sum += nums[ptr++];
        }
        for(int num:nums)
            set.add(num);
        while(true){
            if(!set.contains(sum))
                return sum;
            sum++;
        }
    }
}
