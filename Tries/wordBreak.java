class Solution {
    class Node {
        boolean isEnd;
        Node[] next;
        public Node() {
            this.isEnd = false;
            this.next = new Node[26];
        }
    }
    class Trie {
        Node root;
        public Trie() {
            this.root = new Node();
        }
        public void insert(String s) {
            Node top = root;
            for(int i = 0; i < s.length(); i++) {
                int idx = s.charAt(i) - 'a';
                if(top.next[idx] == null) top.next[idx] = new Node();
                top = top.next[idx];
            }
            top.isEnd = true;
        }
        public boolean find(Boolean[] dp,String s, int start) {
            if(start == s.length()) return true;
            Node top = root;
            if(dp[start] != null) return dp[start];
            for(int i = start; i < s.length(); i++) {
                int idx = s.charAt(i) - 'a';
                if(top.next[idx] == null) break;
                if(top.next[idx].isEnd && find(dp, s, i + 1)) {
                    return dp[start] = true;
                }
                top = top.next[idx];
            }
            return dp[start] = false;
        }
    }
    public boolean wordBreak(String s, List<String> wordDict) {
        Trie trie = new Trie();
        Boolean[] dp = new Boolean[s.length()];
        for(String word: wordDict) {
            trie.insert(word);
        }
        return trie.find(dp, s, 0);
    }
}