class Solution {
    public int strStr(String haystack, String needle) {
        if(haystack.length()<needle.length())return -1;
        int i =0;
        int j= 0;
        int k=0;
        while(i<haystack.length()-needle.length()+1){
            if(haystack.charAt(i)==needle.charAt(0)){
                j=i;
                while(k<needle.length()){
                    if(haystack.charAt(j)!=needle.charAt(k)){
                        break;
                    }
                    j++;
                    k++;
                }
                if(k==needle.length()){
                    return i;
                }
                k=0;
                j=0;
            }
            i++;
        }
        return -1;
    }
}
