package tries;

import java.util.Arrays;
import java.util.List;

public class Implementation {

    class TrieNode {
        TrieNode[] child = new TrieNode[26];
        boolean isEnd = false;
    }

    public TrieNode getRoot() {
        return new TrieNode();
    }

    public TrieNode insert(char c, TrieNode root) {
        if (root.child[c - 'a'] == null) {
            root.child[c - 'a'] = new TrieNode();
        }
        return root.child[c - 'a'];
    }

    public void insertKey(String key, TrieNode root) {
        for (char curr : key.toCharArray()) {
            root = insert(curr, root);
        }
        root.isEnd = true;
    }

    public boolean checkKey(String key, TrieNode root) {
        return checkKey(root, key, 0);
    }


    private boolean checkKey(TrieNode root, String key, int index) {
        if (index == key.length()) return root.isEnd;
        if (root != null && root.child[key.charAt(index) - 'a'] != null) {
            return checkKey(root, key, index + 1);
        } else return false;
    }

    private boolean startsWith(TrieNode root, String substr) {
        return startsWith(root, substr, 0);
    }

    private boolean startsWith(TrieNode root, String substr, int idx) {
        if (idx == substr.length()) return true;
        if (root.child[substr.charAt(idx) - 'a'] != null) {
            return startsWith(root.child[substr.charAt(idx) - 'a'], substr, idx + 1);
        } else return false;
    }

    public static void main(String[] args) {
        Implementation implementation = new Implementation();

        List<String> arr = Arrays.asList(
                "and", "ant", "do", "geek", "dad", "ball");
        TrieNode root = implementation.getRoot();
        for (String s : arr) {
            implementation.insertKey(s, root);
        }

        boolean res = implementation.startsWith(root, "an");
        System.out.println("starts with:" + res);

        res = implementation.checkKey("ball", root);
        System.out.println("starts with:" + res);
    }

}
