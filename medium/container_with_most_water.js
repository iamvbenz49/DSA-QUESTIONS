var maxArea = function(height) {
    let res = 0;
    let first = 0;
    let last = height.length - 1;
    while (first < last) {
        let prod = Math.min(height[first], height[last]) * (last - first);
        if (prod > res) {
            res = prod
        }
        if (height[first] > height[last]) {
            last--;
        } else if (height[first] < height[last]) {
            first++;
        } else {
            last--;
        }

    }
    return res
};
