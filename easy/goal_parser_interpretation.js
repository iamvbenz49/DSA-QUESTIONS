var interpret = function(command) {
    let res = "";
    for(let i = 0;i<command.length;i++){
        if(command[i] === "("){
            if(command[i+1] == ")"){
                i++;
                res = res + "o"
            }
        }
        else if(command[i] === ")"){
            continue
        }
        else{
            res = res + command[i]
        }
    }
    return res
};
