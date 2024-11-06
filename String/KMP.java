class KMP {
    public int kmp(String s, int len) {
        int n = s.length();
        int[] LPS = new int[n];
        for(int i = 1; i < s.length(); i++) {
            int prev_index = LPS[i - 1];
            while(prev_index > 0 && s.charAt(i) != s.charAt(prev_index)) {
                prev_index = LPS[prev_index - 1];
            }
            if(s.charAt(i) == s.charAt(prev_index)) {
                LPS[i] = prev_index + 1;
            }
            if(i > len && LPS[i] == len) {
                return i - 2*len;
            }
        }
        return -1;
    }
}