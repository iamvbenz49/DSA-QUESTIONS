//brute Force TLE
class Solution {
    public int arrangeCoins(int n) {
        int k = 0;
        int c = 0;
        while(c<=n){
            c+=k;
            k++;
        }
        return c==n?k-1:k-2;
    }
}
//optimised o(log n)
class Solution {
    public int arrangeCoins(int n) {
        long s = 0;
        long e = n;
        while(s<=e){
            long mid = (s+e)/2;
            long pivot = mid * (mid+1)/2; //Math formula := n * (n+1)/2
            if(pivot==n){
                return (int)mid;
            }
            if(n<pivot){
                e = mid-1;
            }
            else{
                s = mid+1;
            }
        }
        return (int)e;
    }
}
