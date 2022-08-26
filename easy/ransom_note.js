var canConstruct = function(ransomNote, magazine) {
    let map1 = {}
    let map2 = {}
    for(let i = 97;i<123;i++){
        map1[String.fromCharCode(i)] = 0
        map2[String.fromCharCode(i)] = 0
    }
    let i = 0;
    let j = 0;
    while(i<ransomNote.length || j<magazine.length){
        if(i<ransomNote.length && j<magazine.length){
            map1[ransomNote[i]] +=1;
            map2[magazine[j]] +=1;
            i++;
            j++;
        }
        else if(i<ransomNote.length){
            map1[ransomNote[i]] +=1;
            i+=1
        }
        else if(j<magazine.length){
            map2[magazine[j]] +=1;
            j+=1
        }
    }
    for(let i = 97;i<123;i++){
        if(map1[String.fromCharCode(i)] <= map2[String.fromCharCode(i)]){
            continue
        }
        else{
            return false
        }
    }
    return true
};
