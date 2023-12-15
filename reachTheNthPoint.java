class Solution
{
    static int mod = (int)1e9 + 7;
    public int nthPoint(int n)
    {
        if(n<=2)
            return n;
        int f = 1,s = 2,t = -1;
        for(int i=3;i<=n;i++){
            t = (f+s)%mod;
            f = s;
            s = t;
        }
        return t%mod;
    }
}
