// TC - O(2^N) 
// SC - O(2^N) + O(N)

class Solution{
    ArrayList<Integer> subsetSums(ArrayList<Integer> arr, int N){
        //SC - O(2^N)
        ArrayList<Integer> res = new ArrayList<>();
        subsetSum(arr,res,0,0);
        return res;
    }
    // TC - O(2^N)
    // Auxillary stack space O(N)
    void subsetSum(ArrayList<Integer> arr,ArrayList<Integer> res,int sum,int index){
        if(index==arr.size()){
            res.add(sum);
            return;
        }
        subsetSum(arr,res,sum+arr.get(index),index+1);
        subsetSum(arr,res,sum,index+1);
    }
}
