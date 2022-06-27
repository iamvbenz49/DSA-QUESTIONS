var countAsterisks = function(s) {
    let stack ="";
    let res = 0;
    for(i=0;i<s.length;i++){
        if(s[i] === "*" && stack === ""){
            res++;
        }
        else if(s[i] === "|"){
            if(stack === ""){
                stack = "|"
            }
            else{
                stack = ""
            }
        }
    }
    return res
};
