var max_of_array = function(arr){
    let max = 0
    for(let i = 0;i<arr.length;i++){
        if(arr[i]>max){
            max = arr[i]
        }
    }
    return max
}
var kidsWithCandies = function(candies, extraCandies) {
    let max = max_of_array(candies)
    let res = []
    for(let i = 0;i<candies.length;i++){
        if(max<=candies[i]+extraCandies){
                res.push(true)  
        }
        else{
                res.push(false)
        }
    }
    return res
};
