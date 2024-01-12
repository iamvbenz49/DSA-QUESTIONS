class Solution {
    public boolean halvesAreAlike(String s) {
        int count = 0, index = 0;
        int length = s.length();
        while(index<length/2){
            if(isVowel(s.charAt(index)))
                count++;
            if(isVowel(s.charAt(length-index-1)))
                count--;
            index++;
        }
        return count==0;
    }
    public boolean isVowel(char c){
        c = Character.toLowerCase(c);
        return c=='a'||c=='e'||c=='i'||c=='o'||c=='u';
    }
}
