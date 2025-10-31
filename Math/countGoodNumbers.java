class Solution {
    int MOD = (int)1e9 + 7;
    public int countGoodNumbers(long n) {
        long odd = (n + 1)/2;
        long even = n/2;

        return (int)(count(5, odd) * count(4, even) % MOD);
    }
    public long count(long x, long n) {
        if(n == 0) return 1;

        long current = count(x, n/2);

        if(n % 2 == 0) {
            return (current * current) % MOD;
        } else {
            return (current * current * x) % MOD;
        }
    }
}

class Solution {
    public int countGoodNumbers(long n) {
        long res = 1;
        int MOD = (int)1e9 + 7;

        for(int i = 0; i < n; i++) {
            if(i%2 == 0)
                res = (res * 5)%MOD;
            else
                res = (res * 4)%MOD;
        }

        return (int)res;
    }
}
