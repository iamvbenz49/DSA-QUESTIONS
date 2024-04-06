class Solution {
    public String minRemoveToMakeValid(String s) {
        int left = 0, right = 0;
        Stack<Integer> stack = new Stack<>();
        char[] res = new char[s.length()];
        while( right < s.length() ){
            char c = s.charAt(right);
            if(c == '('){
                stack.add(left);
                res[left++] = c;
            } else if( c == ')' ) {
          //      System.out.println(stack + " "+right);
                if(!stack.isEmpty()){
                    res[left++] = c;
                    stack.pop();
                }
            } else {
                res[left++] = c;
            }
            right++;
        }
        while(!stack.isEmpty()){
        //    System.out.println(stack + " "+stack.peek());
            res[stack.pop()] = '\u0000';
          //  System.out.println(Arrays.toString(res));
        }
        String restring = "";
        for(char c:res){
            if(c!='\u0000')
                restring += c;
        }
        return restring;
    }
}

class Solution {
    public String minRemoveToMakeValid(String s) {
        int open = 0, left = 0;
        char[] res = s.toCharArray();
        for(int i=0;i<res.length;i++) {
            char c = res[i];
            if( c == '(' ){
                open++;
            }
            else if( c == ')'){
                if(open > 0){
                    open--;
                }else{
                    continue;
                }
            }
            res[left++] = c;
        }
        int index = left-1;
        
        while(open > 0 && index>=0){
            if(res[index] == '('){
                res[index] = '*';
                open--;
            }
            index--;
        }
        int right = 0;
        for(int i = 0;i < left;i++){
            if(res[i] != '*')
                res[right++] = res[i];
        }
        return new String(res).substring(0,right);
    }
}
