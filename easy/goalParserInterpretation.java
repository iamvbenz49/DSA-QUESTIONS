class Solution {
    public String interpret(String command) {
        int i =0;
        String r = "";
        while(i<command.length()){
            if(command.charAt(i)=='G'){
                r = r+'G';
                i++;
            }
            else if(command.charAt(i)=='(' && command.charAt(i+1)==')'){
                r = r + 'o';
                i+=2;
            }
            else{
                r=r+'a'+'l';
                i+=4;
            }
        }
        return r;
    }
}
