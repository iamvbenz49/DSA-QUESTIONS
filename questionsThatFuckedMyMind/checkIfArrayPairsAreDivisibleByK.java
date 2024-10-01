// Most of the solution on editorial will not pass this testcase
// Ex: arr = [2,2,2,2,2,2] k = 3
// check this solution - https://leetcode.com/problems/check-if-array-pairs-are-divisible-by-k/solutions/709225/most-of-the-solutions-here-are-wrong-correct-solution-is-here/
// dry run through few testcase to understand what the fuck is happening


class Solution {
    public boolean canArrange(int[] arr, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        int n = arr.length;
        if(n%2 == 1) {
            return false;
        }
        int count = 0;
        for(int i = 0; i < arr.length; i++) {
            // get the remainder
            // but why + k and %k --> for negative numbers
            // arr[i] = -5 and k = 7
            // arr[i]%k = -5 + k --> 2%7 = 2
            int remainder = (arr[i]%k + k)%k; 
            int target = (k - remainder)%k;

            if(map.getOrDefault(target, 0) > 0) {
                map.put(target, map.get(target) - 1);
                count++;
            } else {
                map.put(remainder, map.getOrDefault(remainder, 0) + 1);
            }
        } 
        System.out.println(count);
        return count == n/2;
    }
}