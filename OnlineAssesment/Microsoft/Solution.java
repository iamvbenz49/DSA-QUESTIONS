package MSFT;

import java.util.Arrays;



public class Solution {
    public static void main(String[] args) {
        int[] A = {3, 4, 6};
        int[] B = {6, 5, 4};
        System.out.println(findOptimalPath(A, B, 0, 0, A.length));
        int[] c = {1, 2, 1, 1, 1, 4};

        System.out.println(findOptimalPath(A, B, 0, 0, A.length));
    }
    // public static int solution(int[] A, int[] B) {
    //     int n = A.length;
    //     int[] dpA = new int[n];
    //     int[] dpB = new int[n];
    //     for(int i = 1; i < n; i++) {
    //         dpA[i] = Math.max(A[i], Math.min(dpA[i - 1], dpB[i - 1]));
    //         dpB[i] = Math.max(B[i], Math.min(dpA[i - 1], dpB[i - 1]));
    //     }
        
    //     return Math.min(dpA[n - 1], dpB[n - 1]);
    // }
    public static int findOptimalPath(int[] A, int[] B, int row, int col, int LENGTH) {
        if(col == LENGTH - 1) {
            if(row == 0) {
                return Math.max(A[LENGTH - 1], B[LENGTH - 1]);
            } else {
                return B[LENGTH - 1];
            }
        }
        int moveRight = findOptimalPath(A, B, row, col + 1, LENGTH);
        if(row == 0) {
            int moveDown = findOptimalPath(A, B, row + 1, col, LENGTH);
            return Math.max(A[col], Math.min(moveRight, moveDown));
        }
        return Math.max(B[col], moveRight);
        // int[] dpA = new int[LENGTH];
        // int[] dpB = new int[LENGTH];
        // dpA[LENGTH - 1] = Math.max(A[LENGTH - 1], B[LENGTH - 1]);
        // dpB[LENGTH - 1] = B[LENGTH - 1];
        // for(int i = LENGTH - 2; i >= 0; i--) {
        //     dpA[i] = Math.max(A[i], dpA[i + 1]);
        //     dpB[i] = Math.max(Math.max(B[i], A[i]), dpB[i + 1]);
        // }
        // System.out.println(Arrays.toString(dpA));
        // System.out.println(Arrays.toString(dpB));
        // return dpA[0];
    } 
    
}