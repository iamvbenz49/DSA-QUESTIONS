class Solution {
    public int maxProduct(int[] nums) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((x,y)->y-x);
        for(int num:nums){
            pq.add(num);
        }
        int firstNumber = pq.poll()-1;
        int secondNumber = pq.poll()-1;
        return firstNumber*secondNumber;
    }
}
