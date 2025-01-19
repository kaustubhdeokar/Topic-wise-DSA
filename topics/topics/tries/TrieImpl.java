package tries;

public class TrieImpl {


    public void insertKey(String key, TrieNode root) {
        for (char ch : key.toCharArray()) {
            if (!root.containsKey(ch)) {
                root.put(ch, new TrieNode());
            }
            root = root.getKey(ch);
            root.incrementCount();
        }
        root.isEnd = true;
    }

    public boolean containsKey(String key, TrieNode root) {
        for (char ch : key.toCharArray()) {
            if (!root.containsKey(ch)) {
                return false;
            }
            root = root.getKey(ch);
        }
        return root.isEnd;
    }

    public void deleteKey(String key, TrieNode root) {
        deleteKey(0, key, root);
        if(root.getKey(key.charAt(0)).count==0){
            root.put(key.charAt(0), null);
        }

    }

    private void deleteKey(int i, String key, TrieNode root) {
        if (i == key.length()) {
            root.decrementCount();
            root.isEnd = false;
            return;
        }
        deleteKey(i + 1, key, root.getKey(key.charAt(i)));
        if(i!=key.length()-1){
            TrieNode curr = root.getKey(key.charAt(i));//l
            if(curr.getKey(key.charAt(i+1)).count==0){
                curr.put(key.charAt(i + 1), null);
            }
            curr.decrementCount();
        }
    }

    public int countWordsEndingAt(String key, TrieNode root) {
        for (char ch : key.toCharArray()) {
            if (!root.containsKey(ch)) {
                return 0;
            }
            root = root.getKey(ch);
        }
        return root.count;
    }

    public boolean hasPrefix(String prefix, TrieNode root) {
        for (char ch : prefix.toCharArray()) {
            if (!root.containsKey(ch)) {
                return false;
            }
            root = root.getKey(ch);
        }
        return true;
    }

    public int countPrefix(String prefix, TrieNode root) {
        for (char ch : prefix.toCharArray()) {
            if (!root.containsKey(ch)) {
                return 0;
            }
            root = root.getKey(ch);
        }
        return root.count;
    }

    public static void main(String[] args) {
        TrieImpl impl = new TrieImpl();
        impl.implementTrie();
    }

    private void implementTrie() {
        TrieNode root = new TrieNode();
        insertKey("apple", root);
        insertKey("apps", root);
        System.out.println(containsKey("app", root));
        System.out.println(containsKey("apps", root));

//        System.out.println(hasPrefix("app", root));
//        System.out.println(countPrefix("app", root));
//        System.out.println(countWordsEndingAt("apps", root));

        deleteKey("apple", root);
        System.out.println(containsKey("apps", root));
    }

}
