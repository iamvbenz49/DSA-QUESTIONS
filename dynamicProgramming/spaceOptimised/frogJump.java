import java.util.* ;
import java.io.*; 
public class Solution {
    public static int frogJump(int n, int heights[]) {
        int[] dp = new int[n];
        int first = 0,  second = 0;
        for(int i=n-2;i>=0;i--){
            int third = Math.abs(heights[i]-heights[i+1]) + first;
            if(i<n-2)
                third = Math.min(third,Math.abs(heights[i]-heights[i+2]) + second);
            second = first;
            first = third;
        }
        return first;
    }
}
