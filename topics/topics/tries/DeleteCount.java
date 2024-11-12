package tries;

import java.util.Arrays;
import java.util.List;

public class DeleteCount {

    class TrieNode {
        TrieNode[] child = new TrieNode[26];
        int wordEnd = 0;
        int wordPrefix = 0;
    }

    public TrieNode getRoot() {
        return new TrieNode();
    }

    public TrieNode insert(char curr, TrieNode root) {
        int idx = curr - 'a';
        if (root.child[idx] == null) {
            root.child[idx] = new TrieNode();
        }
        root.child[idx].wordPrefix += 1;
        return root.child[idx];
    }

    public void insertKey(String key, TrieNode root) {
        for (char curr : key.toCharArray()) {
            root = insert(curr, root);
        }
        root.wordEnd += 1;
    }

    private int countWord(TrieNode root, String str) {
        return countWord(root, str, 0);
    }

    private int countWord(TrieNode root, String str, int idx) {
        if (str.length() == idx) return root.wordEnd;
        if (root.child[str.charAt(idx) - 'a'] != null) {
            return countWord(root.child[str.charAt(idx) - 'a'], str, idx + 1);
        }
        return -1;
    }

    private int countPrefix(TrieNode root, String str) {
        return countPrefix(root, str, 0);
    }

    private int countPrefix(TrieNode root, String str, int idx) {
        if (str.length() == idx) return root.wordPrefix;
        if (root.child[str.charAt(idx) - 'a'] != null) {
            return countPrefix(root.child[str.charAt(idx) - 'a'], str, idx + 1);
        }
        return -1;
    }


    private boolean delete(TrieNode root, String str) {
        return delete(root, str, 0);
    }

    private boolean delete(TrieNode root, String str, int idx) {
        if (idx == str.length()) {
            root.wordEnd -= 1;
            return true;
        }
        int curr = str.charAt(idx) - 'a';
        if (root.child[curr] != null) {
            if (delete(root.child[curr], str, idx + 1)) {
                root.child[curr].wordPrefix -= 1;
                if (root.child[curr].wordPrefix == 0) {
                    root.child[curr] = null;
                }
                return true;
            }
        }
        return false;
    }




    public static void main(String[] args) {
        DeleteCount implementation = new DeleteCount();

        List<String> arr = Arrays.asList(
                "apple", "apple", "apps", "cap","cab");
        TrieNode root = implementation.getRoot();
        for (String s : arr) {
            implementation.insertKey(s, root);
        }

        int res = implementation.countWord(root, "apple");
        System.out.println("count:" + res);
        res = implementation.countPrefix(root, "app");
        System.out.println("count:" + res);
        res = implementation.countPrefix(root, "apps");
        System.out.println("count:" + res);
        System.out.println("---------------------");
        implementation.delete(root, "apple");
        System.out.println("---------------------");
        res = implementation.countWord(root, "apple");
        System.out.println("count:" + res);
        res = implementation.countPrefix(root, "app");
        System.out.println("count:" + res);
        res = implementation.countPrefix(root, "apps");
        System.out.println("count:" + res);

        PrintTrie printTrie = new PrintTrie();
        printTrie.showContent(root);

        //        System.out.println("---------------------");
//        implementation.delete(root, "apple");
//        res = implementation.countWord(root, "apple");
//        System.out.println("count:" + res);
//        res = implementation.countPrefix(root, "app");
//        System.out.println("count:" + res);
//        res = implementation.countPrefix(root, "apps");
//        System.out.println("count:" + res);

    }

}
