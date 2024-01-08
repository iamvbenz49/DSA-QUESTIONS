// Memoisation TC - O(N^2) SC - O(N^2) + O(N)
class Solution {
    public boolean canPartition(int[] nums) {
        int target = 0;
        for(int num:nums)
            target += num;
        if(target%2==1)
            return false;
        Boolean[][] dp = new Boolean[nums.length][(target/2) +1];
        return canPartition(nums,dp,0,target/2);
    }
    public boolean canPartition(int[] nums,Boolean[][] dp,int index,int target){
        if(target==0)
            return true;
        if(index>=nums.length||target<0)
            return false;
        if(dp[index][target]!=null)
            return dp[index][target];
        boolean pick = canPartition(nums,dp,index+1,target-nums[index]);
        boolean notPick = canPartition(nums,dp,index+1,target);

        return dp[index][target] =  pick||notPick;
    }
}

//Tabulation TC - O(N^2) SC - O(N^2)
class Solution {
    public boolean canPartition(int[] arr) {
        int N = arr.length;
        int target = 0;
        for(int num:arr)
            target += num;
        if(target%2==1)
            return false;
        target/=2;
        boolean[][] dp = new boolean[target][N+1]; 
        for(int i=target-1;i>=0;i--){
            for(int j=N-1;j>=0;j--){
                boolean notPick =  dp[i][j+1];
                boolean pick = false;
                if(i+arr[j]==target)
                    pick = true;
                else if(i+arr[j]<target)
                    pick = dp[i+arr[j]][j+1];
                dp[i][j] = pick || notPick;
            }
        }
        return dp[0][0];
    }
}
//space optimised DP TC - O(N) SC - O(N)
class Solution {
    public boolean canPartition(int[] arr) {
        int N = arr.length;
        int target = 0;
        for(int num:arr)
            target += num;
        if(target%2==1)
            return false;
        target/=2;
        boolean[] dp = new boolean[target+1]; 
        dp[target] =  true;
        for(int i=N-1;i>=0;i--){
            boolean[] temp = new boolean[target+1];
            temp[target] =  true;
            for(int j=target-1;j>=0;j--){
                boolean notPick =  dp[j];
                boolean pick = false;
                if(j+arr[i]==target)
                    pick = true;
                else if(j+arr[i]<target)
                    pick = dp[j+arr[i]];
                temp[j] = pick || notPick;
            }
            dp = temp;
        }

        return dp[0];
    }
}
