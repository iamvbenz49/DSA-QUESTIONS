class Solution {
    public boolean makeEqual(String[] words) {
        int[] map = new int[26]; //SC - O(26)
        //TC - 0(total characters)
        for(int i=0;i<words.length;i++){
            for(int j=0;j<words[i].length();j++){
                map[words[i].charAt(j)-97]++;
            }
        }
        //TC - O(26)
        for(int i=0;i<26;i++){
            if(map[i]%words.length!=0)
                return false;
        }
        return true;
    }
}
