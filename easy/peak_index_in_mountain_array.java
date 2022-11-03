class Solution {
    public int peakIndexInMountainArray(int[] arr) {
        int start = 0;
        int end = arr.length-1;
        int ans = 0;
        while(start<end){
                int mid = start + (end-start)/2;
                if(arr[mid-1]<arr[mid] && arr[mid]>arr[mid+1]){
                    ans = mid;
                    break;
                }
                else if(arr[mid-1]>arr[mid]){
                    end = mid;
                }
                else if(arr[mid+1]>arr[mid]){
                    start = mid;
                }
            }
        return ans;
        }
}
