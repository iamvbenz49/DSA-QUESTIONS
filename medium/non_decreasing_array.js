var checkPossibility = function(nums) {
    let key = 0;
    for (i = 1; i < nums.length; i++) {
        if (nums[i] <= nums[i - 1]) {
            if (key === 0) {
                return false
            }
            key += 1
            if (i >= 2 && nums[i] < nums[i - 1]) {
                nums[i - 1] = nums[i]
            }
        }
    }
}
