var count = function(str){
    let res = 1
    for(let i = 0;i<str.length;i++){
        if(str[i] === " "){
            res++;
        }
    }
    return res
}
var mostWordsFound = function(sentences) {
    let max = 0;
    for(let i = 0;i<sentences.length;i++){
        if(count(sentences[i])>max){
            max = count(sentences[i])
        }
    }
    return max
};
