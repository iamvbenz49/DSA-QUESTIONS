class Solution{
    //Function to check whether there is a subarray present with 0-sum or not.
    static boolean findsum(int arr[],int n)
    {
        Set<Integer> set = new HashSet<>();
        int prefixSum = arr[0];
        for(int i=1;i<n;i++){
            set.add(prefixSum);
            prefixSum += arr[i];
            if(prefixSum==0||set.contains(prefixSum)){
                return true;
            }
        }
        return false;
    }
}
