public class NumberCheck {
    
    public static boolean checkNumberConditions(int n) {
        boolean hasEvenDigit = false;
        boolean hasFive = false;
        int sumOfDigits = 0;
        
        // Process each digit of the number
        while (n > 0) {
            int digit = n % 10;  // Get the last digit
            
            // Check if the digit is even
            if (digit % 2 == 0) {
                hasEvenDigit = true;
            }
            
            // Check if the digit is 5
            if (digit == 5) {
                hasFive = true;
            }
            
            // Add the digit to the sum
            sumOfDigits += digit;
            
            n /= 10;  // Remove the last digit
        }
        
        // Check if the sum of digits is divisible by 3
        boolean sumDivisibleBy3 = (sumOfDigits % 3 == 0);
        
        // Return true if any of the conditions is met
        return hasEvenDigit || hasFive || sumDivisibleBy3;
    }

    public static void main(String[] args) {
        int number = 1523;
        if (checkNumberConditions(number)) {
            System.out.println(number + " meets at least one of the conditions.");
        } else {
            System.out.println(number + " does not meet any of the conditions.");
        }
    }
}
