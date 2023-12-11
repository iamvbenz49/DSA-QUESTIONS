class Solution{
    static long maximumSumSubarray(int k, ArrayList<Integer> arr,int N){
        int left = 0,right =0;
        long sum = 0,maxSum = 0;
        while(right<N){
            if(right<k){
                sum+=arr.get(right);
                right++;
            }else{
                sum+=arr.get(right);
                right++;
                sum-=arr.get(left);
                left++;
            }
            maxSum = Math.max(sum,maxSum);
        }
        return maxSum;
    }
}
