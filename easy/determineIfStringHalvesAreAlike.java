class Solution {
    public boolean halvesAreAlike(String s) {
        int first = 0;
        int second = 0;
        for(int i=0;i<s.length();i++){
            char c = s.charAt(i);
            if(c=='a'||c=='A'||c=='e'||c=='E'||c=='I'||c=='i'||c=='o'||c=='O'||c=='u'||c=='U'){
                if(i<s.length()/2)
                    first++;
                else
                    second++;
            }
        }
        return first==second;
    }
   
}
