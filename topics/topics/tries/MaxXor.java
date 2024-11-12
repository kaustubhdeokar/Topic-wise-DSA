package tries;

public class MaxXor {
    class TrieNode {
        TrieNode[] child = new TrieNode[2];
        boolean isEnd;
    }

    private int findMax(int[] nums) {
        int max = Integer.MIN_VALUE;
        for (int n : nums) {
            if (n > max) max = n;
        }
        return max;
    }

    public static void main(String[] args) {
        MaxXor maxXor = new MaxXor();
        maxXor.helper();
    }

    public void helper() {
        int[] nums = {2147483647,2147483646,2147483645};
        solution(nums);
    }

    public void solution(int[] nums) {
        int maxNumber = findMax(nums);
        int power = (int) Math.floor(Math.log(maxNumber) / Math.log(2));

        TrieNode root = new TrieNode();
        for (int n : nums) {
            insertNum(n, root, power);
        }

        int max = -1;
        for (int n : nums) {
            max = Integer.max(max, calculateMax(n, root, power));
        }
        System.out.println("max xor:" + max);
    }

    public void insertNum(int n, TrieNode root, int power) {
        //n 10 -> 001100
        //x           100000
        int x = 1 << power;
        TrieNode temp = root;
        while (x > 0) {
            int set = (n & x) != 0 ? 1 : 0;
            temp = insertIntoTrie(temp, set);
            x >>= 1;
        }
        temp.isEnd = true;
    }

    public TrieNode insertIntoTrie(TrieNode root, int n) {
        if (root.child[n] == null) {
            root.child[n] = new TrieNode();
        }
        return root.child[n];
    }

    public int calculateMax(int n, TrieNode root, int power) {

        int x = 1 << power;
        int result = 0;
        while (x > 0) {
            int setBit = (n & x) > 0 ? 1 : 0;
            int xorBit = 1 ^ setBit; // if set is 1, to maximize we want xor bit as 0 and vice versa
            if (root.child[xorBit] != null) {
                result += x;
                root = root.child[xorBit];
            } else {
                root = root.child[setBit];
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

}
