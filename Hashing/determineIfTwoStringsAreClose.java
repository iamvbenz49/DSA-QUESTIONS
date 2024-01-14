class Solution {
    public boolean closeStrings(String word1, String word2) {
        if(word1.length()!=word2.length()) return false;
        int[] map1 = new int[26], map2 = new int[26];
        for(int i=0;i<word1.length();i++){
            map1[word1.charAt(i)-97]++;
        }
        for(int i=0;i<word2.length();i++){
            map2[word2.charAt(i)-97]++;
        }
        for(int i=0;i<26;i++){
            if((map1[i]==0)^(map2[i]==0))
                return false;
        }
        Arrays.sort(map1);
        Arrays.sort(map2);
        for(int i=0;i<26;i++)
            if(map1[i]!=map2[i]) return false;
        return true;
    }
}
