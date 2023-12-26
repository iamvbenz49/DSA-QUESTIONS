class Solution { 
    private int mod = 1000000007;
    public int numRollsToTarget(int n, int k, int target) {
        int[][] memo = new int[n+1][target+1];
        for(int i=0;i<=n;i++)
            Arrays.fill(memo[i],-1);
        return rolls(memo,n,k,target);
    }
    public int rolls(int[][] memo,int n,int k,int target){
        if(n==0 && target==0)
            return 1;
        if(n==0||target<=0)
            return 0;
        if(memo[n][target]!=-1)
            return memo[n][target];
        int res = 0;
        for(int i=1;i<=k;i++){
            if(target-i>=0)
                res = (res + rolls(memo,n-1,k,target-i))%mod;
            else 
                break;
        }
        return memo[n][target] = res;
    }
}
