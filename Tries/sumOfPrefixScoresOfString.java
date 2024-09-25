class Solution {
    class Node {
        Node[] next;
        int count;
        public Node() {
            this.next = new Node[26];
            this.count = 0;
        }
    }
    class Trie {
        Node node;
        public Trie() {
            this.node = new Node();
        }
        public void insert(String word) {
            Node top = this.node;
            for(int i = 0; i < word.length(); i++) {
                int c = word.charAt(i) - 'a';
                if(top.next[c] == null) top.next[c] = new Node();
                top.next[c].count++;
                top = top.next[c];
            }
        }
        public int get(String word) {
            Node top = this.node;
            int res = 0;
            for(int i = 0; i < word.length(); i++) {
                int c = word.charAt(i) - 'a';
                if(top.next[c] == null) break;
                res += top.next[c].count;
                top = top.next[c];
            }
            return res;
        }
    }
    public int[] sumPrefixScores(String[] words) {
        int n = words.length;
        Trie trie = new Trie();
        for(String word: words) {
            trie.insert(word);
        }
        int[] res = new int[n];
        for(int i = 0; i < n; i++) {
            res[i] = trie.get(words[i]);
        }
        return res;
    }
}