class Solution {
    // Function to find if there is a celebrity in the party or not.
    public int celebrity(int mat[][]) {
        // The idea is to use two pointers, one from start and one from the end. Assume the start person is A, 
        // and the end person is B. If A knows B, then A must not be the celebrity. Else, B must not be the celebrity. 
        // At the end of the loop, only one index will be left as a celebrity. Go through each person again and check whether this is the celebrity. 
        // The Two Pointer approach can be used where two pointers can be assigned, one at the start and the other at the end, and the elements 
        // can be compared and the search space can be reduced. 
    
        // Follow the steps below to solve the problem:
    
        // Create two indices i and j, where i = 0 and j = n-1
        // Run a loop until i is less than j.
        // Check if i knows j, then i can’t be a celebrity. so increment i, i.e. i++
        // Else j cannot be a celebrity, so decrement j, i.e. j–
        // Assign i as the celebrity candidate
        // Now at last check whether the candidate is actually a celebrity by re-running a loop from 0 to n-1  
        //  and constantly checking if the candidate knows a person or if there is a candidate who does not know the candidate.
        
        int N = mat.length;
        int i = 0, j = N - 1;
        while(i < j) {
            if(mat[j][i] == 1) {
                j--;
            } else {
                i++;
            }
        }
        int candidate = j;
        for(i = 0; i < N; i++) {
            if(i != candidate) {
                if(mat[candidate][i] == 1 || mat[i][candidate] == 0) {
                    return -1;
                }
            }
        }
        return candidate;
    }
}