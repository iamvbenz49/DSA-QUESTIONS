// Recursion TLE  TC - O(2^N) SC - O(N)
class Solution{


    static Boolean isSubsetSum(int N, int arr[], int sum){
        // code here
        return check(arr,0,sum);
    }
    public static boolean check(int[] arr,int index,int target){
        if(target==0)
            return true;
        if(index>=arr.length)
            return false;
        boolean pick = check(arr,index+1,target-arr[index]);
        boolean notPick = check(arr,index+1,target);
        return pick||notPick;
    }
}
//Memoisation TC-O(N^2) SC-O(N^2) + O(N)
class Solution{


    static Boolean isSubsetSum(int N, int arr[], int sum){
        // code here
        Boolean[][] dp = new Boolean[N][sum+1]; 
        return check(arr,dp,0,sum);
    }
    public static boolean check(int[] arr,Boolean[][] dp,int index,int target){
        if(target==0)
            return true;
        if(target<0)
            return false;
        if(index>=arr.length)
            return false;
        if(dp[index][target]!=null)
            return dp[index][target];
        boolean pick = check(arr,dp,index+1,target-arr[index]);
        boolean notPick = check(arr,dp,index+1,target);
        return dp[index][target] = pick||notPick;
    }
}

//Tabulation TC-O(N^2) SC-O(N^2) 

class Solution{


    static Boolean isSubsetSum(int N, int arr[], int target){
        // code here
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
//space optimised TC-O(N^2) SC-O(N) 
class Solution{


    static Boolean isSubsetSum(int N, int arr[], int target){
        // code here
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
