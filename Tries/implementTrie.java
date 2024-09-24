class Trie {
    class Node {
        boolean isEnd;
        Node[] next;
        public Node() {
            this.isEnd = false;
            next = new Node[26];
        }
    }
    Node node;
    public Trie() {
        this.node = new Node();
    }
    
    public void insert(String word) {
        Node currentNode = this.node;
        for(int i = 0; i < word.length(); i++) {
            int c = word.charAt(i) - 'a';
            if(currentNode.next[c] == null) {
                currentNode.next[c] = new Node();
            }
            currentNode = currentNode.next[c];
        }
        currentNode.isEnd = true;
    }
    
    public boolean search(String word) {
        Node currentNode = this.node;
        for(int i = 0; i < word.length(); i++) {
            int c = word.charAt(i) - 'a';
            if(currentNode.next[c] == null) {
                return false;
            }
            currentNode = currentNode.next[c];
        }
        return currentNode.isEnd;
    }
    
    public boolean startsWith(String prefix) {
        Node currentNode = this.node;
        for(int i = 0; i < prefix.length(); i++) {
            int c = prefix.charAt(i) - 'a';
            if(currentNode.next[c] == null) {
                return false;
            }
            currentNode = currentNode.next[c];
        }
        return true;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */