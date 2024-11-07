class Solution {
    public String longestPrefix(String s) {
        int[] lps = kmp(s);
        int n = s.length();
        
        StringBuilder res = new StringBuilder();
        for(int i = 0; i < lps[n - 1]; i++) {
            res.append(s.charAt(i));
        }
        return res.toString();
    }
    public int[] kmp(String s){
        int n = s.length();
        int[] lps = new int[n];

        for(int i = 1; i < n; i++) {
            int prev_index = lps[i - 1];
            while(prev_index > 0 && s.charAt(i) != s.charAt(prev_index)) {
                prev_index = lps[prev_index - 1];
            }
            if(s.charAt(i) == s.charAt(prev_index)) {
                lps[i] = prev_index + 1;
            }
        }
        return lps;
    }
}