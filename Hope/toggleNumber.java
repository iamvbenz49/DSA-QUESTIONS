package Hope;

public class toggleNumber {
    public static void main(String[] args) {
        int m = 10, n = 25, count = 0;
        while(n > 0 || m > 0) {
            if((m&1) != (n&1)) {
                count++;
            }
            m>>=1;
            n>>=1;
        }
        System.out.println(count);
    }
}
