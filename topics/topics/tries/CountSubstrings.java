package tries;

public class CountSubstrings {

    /*
          idea is to enter strings into a trie.
        - Starting from a b a b
        - Then from first index - b a b
        - Then from second index - a b (Here we see this already existed in the trie), so not a unique substring
        - Continued till the end.


    What a cool way.
    */

    public static void main(String[] args) {

        CountSubstrings countSubstrings = new CountSubstrings();
        countSubstrings.solve("abab");

    }

    public void insertKey(String key, TrieNode root, int[] uniqueCount) {
        for (char ch : key.toCharArray()) {
            if (!root.containsKey(ch)) {
                root.put(ch, new TrieNode());
                uniqueCount[0] += 1;
            }
            root = root.getKey(ch);
            root.incrementCount();
        }
        root.isEnd = true;
    }

    private void solve(String string) {
        int[] count = new int[]{0};
        TrieNode root = new TrieNode();
        for (int i = 0; i < string.length(); i++) {
            for (int j = i; j < string.length(); j++) {
                insertKey(string.substring(j), root, count);
            }
        }
        count[0] += 1; //for empty string.
        System.out.println("count:" + count[0]);
    }

}
