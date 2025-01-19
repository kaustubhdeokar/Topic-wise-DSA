package tries;

public class TrieNode {

    TrieNode[] trieNode = new TrieNode[26];
    boolean isEnd = false;
    int count = 0;

    public void put(char ch, TrieNode node) {
        trieNode[ch - 'a'] = node;
    }

    public void incrementCount() {
        this.count += 1;
    }

    public void decrementCount() {
        this.count -= 1;
    }

    public boolean containsKey(char ch) {
        return trieNode[ch - 'a'] != null;
    }

    public TrieNode getKey(char ch) {
        return trieNode[ch - 'a'];
    }

    public void deleteKey(char ch) {
        trieNode[ch - 'a'] = null;
    }

}
