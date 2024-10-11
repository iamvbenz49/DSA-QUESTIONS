class Solution{
    public:
    // n: input to count the number of set bits
    //Function to return sum of count of set bits in the integers from 1 to n.
    int countMaxPower(int n) {
        int power = 0, count = 0;
        while(1 << (count + 1) <= n) {
            count++;
        }
        return count;
    }
    int countSetBits(int n)
    {
        // Explaination
        // https://chatgpt.com/share/670947cf-b380-8008-afd3-81aac5109056
        if(n == 0) {
            return 0;
        }
        // find bits which is present until Max power block
        // then find the number set MSB bits
        // then find the remaining bits
        int maxPower = countMaxPower(n);
        int bitsUntilMaxPower = maxPower * (1 << (maxPower - 1));
        int msbSetBits = (n - (1 << maxPower) + 1);
        int remainingBits = countSetBits(n - (1 << maxPower));
        
        return bitsUntilMaxPower + msbSetBits + remainingBits;
    }
};
