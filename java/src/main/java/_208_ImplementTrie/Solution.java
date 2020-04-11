// 15: 33
class TrieNode {

    private static final int N = 26;

    private boolean isEnd = false;

    private TrieNode[] links;  

    public TrieNode() {
        links = new TrieNode[N];
    }

    public TrieNode get(char ch) {
        return links[ch - 'a'];
    }

    public void put(char ch, TrieNode node){
        links[ch - 'a'] = node;
    }

    public boolean hasKey(char ch) {
        return links[ch - 'a'] != null;
    }

    public void setEnd() {
        isEnd = true;
    }

    public boolean isEnd() {
        return isEnd;
    }
}
class Trie {

    TrieNode root;

    /** Initialize your data structure here. */
    public Trie() {
        root = new TrieNode();
    }
    
    /** Inserts a word into the trie. */
    public void insert(String word) {
        TrieNode curr = root;
        for (int i = 0; i < word.length(); i ++) {
            char ch = word.charAt(i);
            if (!curr.hasKey(ch)) {
                curr.put(ch, new TrieNode());
            }
            curr = curr.get(ch);
        }
        curr.setEnd();
    }
    
    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        TrieNode curr = root;
        for (int i = 0; i < word.length(); i ++) {
            char ch = word.charAt(i);
            if (!curr.hasKey(ch)) {
                return false;
            }
            curr = curr.get(ch);
        }
        return curr.isEnd();
    }
    
    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        TrieNode curr = root;
        for (int i = 0; i < prefix.length(); i ++) {
            char ch = prefix.charAt(i);
            if (!curr.hasKey(ch)) {
                return false;
            }
            curr = curr.get(ch);
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