class Solution {
    // Function to convert an infix expression to a postfix expression.
    public static  int findPrec(char c) {
        if(c == '+' || c == '-') {
            return 1;
        } else if(c == '*' || c == '/') {
            return 2;
        } else if(c == '^') {
            return 3;
        } else if(c == '(') {
            return 18;
        }
        return 20;
    }
    public static String infixToPostfix(String s) {
        // ^ greater than * equals to / greater than + equals to -. 
        // Ignore the right associativity of ^.
        // Priority 1 -> ^
        // 2 -> * /
        // 3 -> + -
        
        // if letter add to string
        // if stack empty and stack.peek precedence >= current precendence
        // add to string
        // if ) encountered 
        // add all symbols to stack until )
        // if stack.peek precedence < current precendence
        // add to stack
        int N = s.length();
        Stack<Character> stack = new Stack<>();
        String res = "";
        for(int i = 0; i < N; i++) {
            char c = s.charAt(i);
            if(Character.isLetterOrDigit(c)) {
                res += c;
            } else {
                if(stack.isEmpty() || (stack.peek() != '(' && findPrec(stack.peek()) >= findPrec(c))) {
                    while(!stack.isEmpty() && stack.peek() != '(' && findPrec(stack.peek()) >= findPrec(c)) {
                        res += stack.pop();
                    }
                    stack.add(c);
                } else if(c == ')'){
                    while(stack.peek() != '(') {
                        res += stack.pop();
                    }
                    stack.pop();
                } else {
                    stack.add(c);
                }
            }
        }
        while(!stack.isEmpty()) {
            res += stack.pop();
        }
        return res;

        // for infix to prefix -- > follow these steps
        // Reverse the infix, change ( -- > ) and ) --> (
        // only change in condition if ^ encountered remove everything from stack
        // stack.isEmpty() || stack.peek() != '^'
        // Reverse the answer
    }
}