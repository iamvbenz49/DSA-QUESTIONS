var restoreString = function(s, indices) {
    arr = []
    for(let i = 0;i<s.length;i++){
        arr[indices[i]] = s[i]
    }
    return arr.join("")
};
