class Solution {
    public int countEven(int num) {
        int sum = 0;
        int n = num;
        while(num > 0) {
            sum += num%10;
            num /= 10;
        }

        if(sum%2 == 0) {
            return n/2;
        }
        return (n - 1)/2;
    }
}
