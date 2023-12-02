class Solution {
    public int countCharacters(String[] words, String chars) {
        int[] charHash = new int[26];
        for(int i=0;i<chars.length();i++){
            charHash[chars.charAt(i)-97]++;
        }
        int res = 0;
        for(int i=0;i<words.length;i++){
            int[] wordHash = new int[26];
            for(int j=0;j<words[i].length();j++){
                wordHash[words[i].charAt(j)-97]++;
            }
            int k = 0;
            for(k=0;k<26;k++){
                if(charHash[k]<wordHash[k])
                    break;
            }
            if(k==26)res+=words[i].length();
        }
        return res;
    }
}
