class Solution {
    public String robotWithString(String s) {
        int[] freq = new int[26];

        for(int i = 0; i < s.length(); i++) {
            freq[s.charAt(i) - 'a']++;
        }

        Stack<Character> stack = new Stack<>();
        StringBuilder t = new StringBuilder();

        for(int i = 0; i < s.length(); i++) {
            stack.add(s.charAt(i));
            freq[s.charAt(i) - 'a']--;

            while(!stack.isEmpty() && stack.peek() <= find(freq)) {
                t.append(stack.pop());
            }
        }

        while(!stack.isEmpty()) {
            t.append(stack.pop());
        }


        return t.toString();
    }
    public char find(int[] freq) {
        for(int i = 0; i < 26; i++) {
            if(freq[i] > 0) {
                return (char)(i + 'a');
            }
        }
        return 'a';
    }
}
