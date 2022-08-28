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

//while solving second time

var maxArea = function(height) {
    let i = 0;
    let j = height.length-1
    let len = height.length
    let max = 0
    while(i<j){
        let temp;
        if(height[i]>=height[j]){
            temp = height[j]*(j-i) 
            j--;
        }
        else{
            temp = height[i]*(j-i)
            i++;
        }
        if(temp > max){
            max = temp
        }
    }
    return max
};
