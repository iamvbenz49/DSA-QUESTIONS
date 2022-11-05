class Solution {
    public int search(int[] nums, int target) {
        int peak = peakIndex(nums);
        int left = search(nums,target,0,peak);
        if(left!=-1){
            return left;
        }
        return search(nums,target,peak+1,nums.length-1);
    }
    static int peakIndex(int[] arr){
        int start = 0;
        int end = arr.length-1;
        while(start<end){
            int mid = start + (end-start)/2;
            if(mid<end && arr[mid+1]<arr[mid]){
                return mid;
            }
            if(start<mid && arr[mid]<arr[mid-1]){
                return mid-1;
            }
            if(arr[start]>=arr[mid]){
                end = mid-1;
            }
            else{
                start = mid+1;
            }
        }
        return -1;
    }
    static int search(int[] arr,int target,int start,int end){
        while(end>=start){
            int mid = start + (end-start)/2;
            if(target>arr[mid]){
                start = mid+1;
            }
            else if(target<arr[mid]){
                end = mid-1;
            }
            else if(target == arr[mid]){
                return mid;
            }
        }
        return -1;
    }
}
