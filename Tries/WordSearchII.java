class Solution {
    class TrieNode {
        String isWord;
        TrieNode[] next;
        public TrieNode() {
            this.isWord = null;
            this.next = new TrieNode[26];
        }
    }
    public TrieNode buildTree(String[] words) {
        TrieNode trie = new TrieNode();
        for(String word: words) {
            TrieNode node = trie;
            for(int i = 0; i < word.length(); i++) {
                int c = word.charAt(i) - 'a';
                if(node.next[c] == null) node.next[c] = new TrieNode();
                node = node.next[c];
            }
            node.isWord = word;
        }
        return trie;
    }
    public List<String> findWords(char[][] board, String[] words) {
        List<String> res = new ArrayList<>();
        TrieNode node = buildTree(words);
        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board[0].length; j++) {
                dfs(board, res, node, i , j);
            }
        }
        return res;
    }
    public void dfs(char[][] board, List<String> res, TrieNode node, int row, int col){
        if(row < 0 || col < 0 || row >= board.length || col >= board[0].length || board[row][col] == '#') {
            return;
        }
        int c = board[row][col] - 'a';
        if(node.next[c] == null) {
            return;
        }
        if(node.next[c].isWord != null) {
            res.add(node.next[c].isWord);
            node.next[c].isWord = null;
        } 
        board[row][col] = '#';
        dfs(board, res, node.next[c], row - 1, col);
        dfs(board, res, node.next[c], row + 1, col);
        dfs(board, res, node.next[c], row, col - 1);
        dfs(board, res, node.next[c], row, col + 1);
        board[row][col] = (char)(c + 'a');
    }
}
