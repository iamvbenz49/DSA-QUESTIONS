//recursion + memo TLE
class Solution {
    public int longestSubsequence(int[] arr, int difference) {
        return dp(arr,-100000,0,difference);
    }
    public int  dp(int[] arr,int prev,int curr,int diff){
        if(curr>=arr.length){
            return 0;
        }
        int takeIt = 0;
        int leaveIt = 0;

        if(prev==-100000){
            takeIt = 1+dp(arr,curr,curr+1,diff);
            leaveIt = dp(arr,prev,curr+1,diff);
        }
        else{
            leaveIt = dp(arr,prev,curr+1,diff);
            if(arr[curr]-arr[prev]==diff){
                takeIt = 1+dp(arr,curr,curr+1,diff);
            }
        }

        return Math.max(takeIt,leaveIt);
    }
}
//dp + memo
class Solution {
    public int longestSubsequence(int[] arr, int difference) {
        int[][] dp = new int[arr.length][arr.length];
        for(int[] i:dp){
            Arrays.fill(i,-1);
        }
        return LSA(arr,dp,-100000,0,difference);
    }
    public int  LSA(int[] arr,int[][] dp,int prev,int curr,int diff){
        if(curr>=arr.length){
            return 0;
        }
        if(prev>-1 && dp[curr][prev]!=-1){
            return dp[curr][prev];
        }
        int takeIt = 0;
        int leaveIt = 0;

        if(prev==-100000){
            takeIt = 1+LSA(arr,dp,curr,curr+1,diff);
            leaveIt =LSA(arr,dp,prev,curr+1,diff);
        }
        else{
            leaveIt =  LSA(arr,dp,prev,curr+1,diff);
            if(arr[curr]-arr[prev]==diff){
                takeIt = 1+LSA(arr,dp,curr,curr+1,diff);
            }
        }
        if(prev>-1){
            dp[curr][prev] = Math.max(takeIt,leaveIt);
        }
        return Math.max(takeIt,leaveIt);
    }
}
//hashing
class Solution {
    public int longestSubsequence(int[] arr, int difference) {
        Map<Integer,Integer> map = new HashMap<>();
        int max = 0;
        for(int val:arr){
            map.put(val,map.getOrDefault(val-difference,0)+1);
            max = Math.max(max,map.get(val));
        }
        return max;
    }
}
