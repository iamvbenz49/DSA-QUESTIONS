class Solution{
    static int findWinner(int n, int A[]){
        if(n%2==0)
            return 1;
        int ans = 0;
        for(int num:A)
            ans ^= num;
        return ans==0?1:2;
    }
}
