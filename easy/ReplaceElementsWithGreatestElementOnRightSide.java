class Solution {
    public int[] replaceElements(int[] arr) {
        int max = -1;
        for(int i=arr.length-1;i>=0;i--){
            int curr = max;
            max = Math.max(max,arr[i]);
            arr[i]=curr;
        }
        return arr;
    }
}
