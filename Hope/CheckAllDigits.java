public class CheckAllDigits {

    public static boolean containsAllDigits(int number) {
        int mask = 0; // Initialize mask
        int allDigitsMask = (1 << 10) - 1; // Binary 1111111111, meaning all digits 0-9 are present

        while (number > 0) {
            int digit = number % 10; // Extract last digit
            mask |= (1 << digit);    // Set the corresponding bit for the digit
            number /= 10;            // Remove the last digit
        }

        return mask == allDigitsMask; // Check if all digits 0-9 are set
    }

    public static void main(String[] args) {
        int num = 1023456789; // Example number

        if (containsAllDigits(num)) {
            System.out.println("The number contains all digits 0-9.");
        } else {
            System.out.println("The number does not contain all digits 0-9.");
        }
    }
}
