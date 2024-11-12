package tries;

public class PrintTrie {

    void showContent(DeleteCount.TrieNode root){
        showContent(root, new StringBuilder());
    }

    void showContent(DeleteCount.TrieNode root, StringBuilder current) {
        if (root.wordEnd > 0) {
            System.out.println(current);
            return;
        }
        for (int i = 0; i < 26; i++) {
            if (root.child[i] != null) {
                current.append((char)(i+'a'));
                showContent(root.child[i], current);
                current.deleteCharAt(current.length()-1);
            }
        }
    }

}
