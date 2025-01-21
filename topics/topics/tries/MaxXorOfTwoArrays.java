package tries;

public class MaxXorOfTwoArrays {
    public static void main(String[] args) {
        MaxXorOfTwoArrays maxXorOfTwoArrays = new MaxXorOfTwoArrays();
        maxXorOfTwoArrays.helper();
    }

    public void helper() {
        int[] nums1 = {0, 142254206, 330218644};
        TrieNode root = new TrieNode();
        int power = 31;
        for (int n : nums1) {
            insertNum(n, root, power);
        }
        int[] num2 = {214004};
        int result = -1;
        for (int n2 : num2) {
            result = Integer.max(result, calculateMax(n2, root, power));
        }
        System.out.println("max xor:" + result);
    }

    public void insertNum(int number, TrieNode root, int power) {
        power = 1 << power - 1;
        while (power > 0) {
            int bit = (power & number) > 0 ? 1 : 0;
            if (!root.contains(bit)) {
                root.put(bit, new TrieNode());
            }
            root = root.get(bit);
            power >>= 1;
        }
    }


    public int calculateMax(int n, TrieNode root, int power) {
        int x = 1 << power - 1;
        int result = 0;
        while (x > 0) {
            int setBit = (n & x) > 0 ? 1 : 0;
            int xorBit = 1 ^ setBit; // if set is 1, to maximize we want xor bit as 0 and vice versa
            if (root.contains(xorBit)) {
                result += x;
                root = root.get(xorBit);
            } else {
                root = root.get(setBit);
            }
            x >>= 1;
        }
        return result;
    }

    void showContent(TrieNode root) {
        showContent(root, new StringBuilder());
    }

    void showContent(TrieNode root, StringBuilder current) {
        if (root.isEnd) {
            System.out.println(current);
            return;
        }
        for (int i = 0; i < 1; i++) {
            if (root.child[i] != null) {
                current.append((char) (i));
                showContent(root.child[i], current);
                current.deleteCharAt(current.length() - 1);
            }
        }
    }

    class TrieNode {
        TrieNode[] child = new TrieNode[2];
        boolean isEnd;

        public void put(int key, TrieNode root) {
            child[key] = root;
        }

        public TrieNode get(int key) {
            return child[key];
        }

        public boolean contains(int key) {
            return child[key] != null;
        }
    }

}
