import java.util.*;
// 4
// 1 2
// 3 4
// 2 5
// 2 5
// 3 7
// 6 7
// 4 5
// 2 8

public class gameWithDoors {
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        int testcases = sc.nextInt();
        while(testcases-- > 0) {
            solve(); 
        }
        // solve();
    }
    public static void solve() {
        int l = sc.nextInt(), r = sc.nextInt();
        int L = sc.nextInt(), R = sc.nextInt();
        int inter = Math.min(r, R) - Math.max(l, L) + 1;
        int ans = inter -1;
      //  System.out.println("ans : "+ans);
        if(inter   <= 0) {
            ans = 1;
        } else {
            ans += (l == L?0:1);
            ans += (r == R?0:1);
        }
        System.out.println(ans);
    }
}