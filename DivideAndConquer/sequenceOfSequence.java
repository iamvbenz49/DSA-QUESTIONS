class Solution{
    static int numberSequence(int m, int n)
    {
        // code here
        int res = 0;
        for(int i=m;i>=1;i--){
            res += findSequence( i, n-1);
        }
        return res;
    }
    public static int findSequence(int amount,int count){
        if(count==0)
            return 1;
        if(amount/2<=0)
            return 0;
        amount/=2;
        int res = 0;
        for(int i=amount;i>0;i--){
            res += findSequence(i,count-1);
        }
        return res;
    }
}
