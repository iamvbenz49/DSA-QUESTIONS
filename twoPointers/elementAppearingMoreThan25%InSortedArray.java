class Solution {
    public int findSpecialInteger(int[] arr) {
        int left = 0,right = arr.length/4;
        while(left<=right){
            if(arr[left]==arr[right]){
                return arr[left];
            }
            left++;
            right++;
        }
        return -1;
    }
}
