import java.util.ArrayList;
class Solution {
    public int[] separateDigits(int[] nums) {
        ArrayList<Integer> res = new ArrayList<Integer>();
        for(int i=0;i<nums.length;i++){
            ArrayList<Integer> curr = new ArrayList<Integer>();
            while(nums[i]!=0){
                curr.add(nums[i]%10);
                nums[i]/=10;
            }
            Collections.reverse(curr);
            res.addAll(curr);
        }
        int[] l = res.stream().mapToInt(Integer::intValue).toArray();
        // res.toArray(l);
        return l;
    }
}
