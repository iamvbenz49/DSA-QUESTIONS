class Solution {
    public class valIndex {
        private int index, val;
        public valIndex(int index, int  val) {
            this.index = index;
            this.val = val;
        }
    }
    public List<Integer> countSmaller(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];
        valIndex[] newNums = new valIndex[n];
        for(int i = 0; i < n; i++) newNums[i] = new valIndex(i, nums[i]);

        merge(newNums, result, 0, n-1);
        List<Integer> res = new ArrayList<>();
        for (int count : result) {
            res.add(count);
        }
        return res;
    }
    public void merge(valIndex[] nums, int[] result, int start, int end) {
        if(start >= end) return;
        int mid = start + (end-start)/2;
        int left = start, right = mid + 1, lessThanLeft = 0;
        List<valIndex> list = new ArrayList<>();
        merge(nums, result, start, mid);
        merge(nums, result, mid+1, end);
        while(left <= mid && right <= end) {
            if(nums[left].val > nums[right].val) {
                lessThanLeft++;
                list.add(nums[right]);
                right++;
            } else {
                result[nums[left].index] += lessThanLeft;
                list.add(nums[left]);
                left++;
            }
        }
        while(left <= mid) {
            result[nums[left].index] += lessThanLeft;
            list.add(nums[left]);
            left++;
        }
        while(right <= end) {
            lessThanLeft++;
            list.add(nums[right]);
            right++;
        }
        left = start;
        for(int i = 0; i < list.size(); i++) {
            nums[left++] = list.get(i); 
        }
    }
}

// Reference - https://leetcode.com/problems/count-of-smaller-numbers-after-self/solutions/445769/merge-sort-clear-simple-explanation-with-examples-o-n-lg-n/

// 315. Count of Smaller Numbers After Self
// Solved
// Hard
// Topics
// Companies

// Given an integer array nums, return an integer array counts where counts[i] is the number of smaller elements to the right of nums[i].

 

// Example 1:

// Input: nums = [5,2,6,1]
// Output: [2,1,1,0]
// Explanation:
// To the right of 5 there are 2 smaller elements (2 and 1).
// To the right of 2 there is only 1 smaller element (1).
// To the right of 6 there is 1 smaller element (1).
// To the right of 1 there is 0 smaller element.

// Example 2:

// Input: nums = [-1]
// Output: [0]

// Example 3:

// Input: nums = [-1,-1]
// Output: [0,0]

 

// Constraints:

//     1 <= nums.length <= 105
//     -104 <= nums[i] <= 104

