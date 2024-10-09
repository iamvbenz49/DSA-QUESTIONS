class Solution {
    String[] ones = {"", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
    String[] twos = {"", "","Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};
    public String numberToWords(int num) {
        if(num == 0) return "Zero";
        return convertNumberToWords(num);
    }
    public String convertNumberToWords(int n) {
        StringBuilder sb = new StringBuilder();
        if(n >= 1000000000) {
            sb.append( convertNumberToWords(n / 1000000000)).append(" Billion ").append( convertNumberToWords(n % 1000000000));
        } else if(n >= 1000000) {
            sb.append( convertNumberToWords(n / 1000000)).append(" Million ").append( convertNumberToWords(n % 1000000));
        } else if(n >= 1000) {
            sb.append( convertNumberToWords(n / 1000)).append(" Thousand ").append( convertNumberToWords(n % 1000));
        } else if(n >= 100) {
            sb.append( convertNumberToWords(n / 100)).append(" Hundred ").append( convertNumberToWords(n % 100));
        } else if(n >= 20) {
            sb.append(twos[n/10]).append(" ").append( convertNumberToWords(n % 10));
        } else {
            sb.append(ones[n]);
        }
        return sb.toString().trim();
    }
}