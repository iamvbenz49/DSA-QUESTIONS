class Solution {
    public int peopleAwareOfSecret(int n, int delay, int forget) {
        // create a array for share and delay 
        // keep track people shared on a day and forgotten on a day
        // store them on a array
        // in the end number of people who knows the secret will be stored in that variable
        long MOD = (int)1e9 + 7;
        
        long[] shares = new long[n];
        long[] forgets = new long[n];
        if(delay < n)
            shares[delay] = 1;
            
        if(forget < n)
            forgets[forget] = 1;

        long peopleKnows = 1, sharedToday = 0;

        for(int i = delay; i < n; i++) {
            sharedToday += shares[i] % MOD;
            sharedToday -= forgets[i] % MOD;

            peopleKnows += sharedToday % MOD;
            peopleKnows -= forgets[i] % MOD;

            if(i + delay < n) {
                shares[delay +  i] += sharedToday % MOD;
            }

            if(i + forget < n) {
                forgets[forget + i] += sharedToday % MOD;
            }
        }

        return (int)(peopleKnows % MOD);
    }
}
