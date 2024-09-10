import java.util.*;

public class File {
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        int testcases = sc.nextInt();
        while(testcases-- > 0) {
            solve(); 
        }
        // solve();
    }
    public static void solve() {
        int n = sc.nextInt();
        int[] nums = new int[n];
        for(int i = 0;i < n; i++) {
            nums[i] = sc.nextInt();
        }
        int max = nums[0], min = nums[n-1], left = 1, right = n-2, index = 0;
        while(left <  right) {
            if(index%2 == 0) {
                
            }
        }
    }
}
