class StreamChecker {
    
    class TrieNode {
        boolean isWord;
        TrieNode[] next = new TrieNode[26];
    }
    
    TrieNode root = new TrieNode();
    StringBuilder sb = new StringBuilder();

    public StreamChecker(String[] words) {
        createTrie(words);
    }
    
    public boolean query(char letter) {
        sb.append(letter);
        TrieNode leaf = root;
        for (int i = sb.length() - 1; i >= 0; i--) {
            char c = sb.charAt(i);
            if (leaf.next[c - 'a'] != null) {
                leaf = leaf.next[c - 'a'];
                if (leaf.isWord) {
                    return true;
                }
            } else {
                return false;
            }
        }
        return false;
    }
    
    private void createTrie(String[] words) {
        for (String word : words) {
            TrieNode leaf = root;
            for (int i = word.length() - 1; i>= 0; i--) {
                char c = word.charAt(i);
                if (leaf.next[c - 'a'] == null) {
                    TrieNode node = new TrieNode();
                    leaf.next[c - 'a'] = node;
                    leaf = node;
               } else {
                    leaf = leaf.next[c - 'a'];
                }
            }
            leaf.isWord = true;
        }
    }
}

/**
 * Your StreamChecker object will be instantiated and called as such:
 * StreamChecker obj = new StreamChecker(words);
 * boolean param_1 = obj.query(letter);
 */
