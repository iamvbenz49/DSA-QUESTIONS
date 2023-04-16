//Using TC : HashMap o(n) + o(log n) SC : O(n)

class Solution {
    public int majorityElement(int[] nums) {
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i:nums){
            if(map.containsKey(i)){
                map.put(i,map.get(i)+1);
            }
            else{
                map.put(i,1);
            }
        }
        int max = 0;
        int maxKey = 0;
        for (Map.Entry<Integer,Integer> mapElement : map.entrySet()) {
            int value = (mapElement.getValue() + 10);
 
            if(value>max){
                max = Math.max(max,value);
                maxKey = mapElement.getKey();
            }
        }
        return maxKey;
    }
}
//MOORE'S VOTING ALGORITHM TC : O(n) SC:O(1)

class Solution {
    public int majorityElement(int[] nums) {
        int element = nums[0];
        int count = 1;
        for(int i=1;i<nums.length;i++){
            if(count==0){
                count++;
                element = nums[i];
            }
            else if(nums[i]==element){
                count++;
            }
            else{
                count--;
            }
        }
        return element;
    }
}
