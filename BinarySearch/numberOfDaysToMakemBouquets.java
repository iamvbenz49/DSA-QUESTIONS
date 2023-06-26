class Solution {
    public int minDays(int[] bloomDay, int m, int k) {
        int max = 0;
        int min = Integer.MAX_VALUE;
        for(int i=0;i<bloomDay.length;i++){
            max = Math.max(max,bloomDay[i]);
            min = Math.min(min,bloomDay[i]);
        }
        int ans = -1;
        while(min<=max){
            int mid = min + (max-min)/2;
            if(check(bloomDay,mid,m,k)){
                ans = mid;
                max = mid-1;
            }
            else{
                min = mid+1;
            }
        }
        return ans;
    }
    public boolean check(int[] arr,int mid,int m,int k){
        int count = 0;
        int bouquets = 0;
        for(int i=0;i<arr.length;i++){
            if(arr[i]<=mid){
                count++;
            }
            else{
                count = 0;
            }
            if(count==k){
                count = 0;
                bouquets++;
            }
        }
        return bouquets>=m;
    }
}
