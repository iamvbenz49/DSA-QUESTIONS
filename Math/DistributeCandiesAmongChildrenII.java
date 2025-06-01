class Solution {
    public long distributeCandies(int n, int limit) {
        long res = 0;

        for(int i = 0; i <= Math.min(limit, n); i++) {
            if(n - i <= 2 * limit) {
                res += Math.min(n - i, limit) - Math.max(0, n - i - limit) + 1;
            }
        }

        return res;
    }
}

// So we just use a for loop from [0, min(limit, n)] to traverse through all the possible values that B could attain and check accordingly.
// If the candies left can be split into A and C then we need to find all possible ways to split them.
// So we need to count all the possible ways to pick A and C in the range :
// max(0,(n−B)−limit)≤A≤min(limit,(n−B))
