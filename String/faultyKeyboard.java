class Solution {
    public String finalString(String s) {
        String res = "";
        for(int i=0;i<s.length();i++){
            char c = s.charAt(i);
            if(c=='i'){
                res = reverse(res);
            }
            else{
                res = res + c;
            }
        }
        return res;
    }
    public String reverse(String s){
        String rev = "";
        for(int i=0;i<s.length();i++){
            rev = s.charAt(i) + rev;
        }
        return rev;
    }
}
