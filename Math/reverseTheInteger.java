class Solution {
    private int MAX_VALUE = Integer.MAX_VALUE, MIN_VALUE = Integer.MIN_VALUE;
    public int reverse(int x) {
        // Division (/): The result’s sign is determined by the dividend and divisor:

        // Same signs → Positive result.
        // Different signs → Negative result.

        // Modulo (%): The result always has the same sign as the dividend (the number on the left).



        int reversedNumber = 0;
        while(x != 0) {
            if(reversedNumber > MAX_VALUE/10 || reversedNumber < MIN_VALUE/10) {
                return 0;
            }
            reversedNumber = reversedNumber * 10 + (x%10);
            System.out.println(reversedNumber+" "+x);
            x /= 10;
        }
        return reversedNumber;
    }
}