package tries;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class MaxXorWithLimit {

    public static void main(String[] args) {
        MaxXorWithLimit maxXorWithLimit = new MaxXorWithLimit();
        int[] nums = {5, 2, 4, 6, 6, 3};
        int[][] queries = {{12, 4}, {8, 1}, {6, 3}};
        int[] result = maxXorWithLimit.maximizeXor(nums, queries);
        for (int r : result) System.out.print(r + " ");
    }

    class TrieNode {
        TrieNode[] node = new TrieNode[2];

        public void put(int num, TrieNode root) {
            node[num] = root;
        }

        public boolean contains(int num) {
            return node[num] != null;
        }

        public TrieNode get(int num) {
            return node[num];
        }

    }

    public int maxXorPossibleWithElementsInTrie(int number, int power, TrieNode root) {

        int current = 1 << power;
        int result = 0;

        while (current > 0 && root != null) {
            int set = (current & number) > 0 ? 1 : 0;
            int xor = set ^ 1;

            if (root.get(xor) != null) {
                root = root.get(xor);
                result += current;
            } else {
                root = root.get(set);
            }
            current >>= 1;
        }
        if (result == 0) return -1;
        return result;
    }

    public void insertIntoTrie(int number, int power, TrieNode root) {

        int x = 1 << power;
        while (x > 0) {
            int ithDigit = (number & x) != 0 ? 1 : 0;
            if (!root.contains(ithDigit)) {
                root.put(ithDigit, new TrieNode());
            }
            root = root.get(ithDigit);
            x >>= 1;
        }
    }


    public int[] maximizeXor(int[] nums, int[][] queries) {
        Arrays.sort(nums);
        int maxNumber = nums[nums.length - 1];
        int power = (int) Math.ceil(Math.log(maxNumber) / Math.log(2));

        ArrayList<int[]> queriesWithIndex = new ArrayList<>();
        for (int q = 0; q < queries.length; q++) {
            int number = queries[q][0];
            int limit = queries[q][1];
            queriesWithIndex.add(new int[]{number, limit, q});
        }

        Comparator<int[]> querySort = (c1, c2) -> Integer.compare(c1[1], c2[1]);
        queriesWithIndex.sort(querySort);

        int numsPtr = 0;
        int queryPtr = 0;
        int[] result = new int[queries.length];
        TrieNode root = new TrieNode();

        while (numsPtr < nums.length && queryPtr < queriesWithIndex.size()) {

            int[] currentQuery = queriesWithIndex.get(queryPtr);
            int currNum = currentQuery[0];
            int currLimit = currentQuery[1];
            int currIndex = currentQuery[2];

            while (numsPtr < nums.length && nums[numsPtr] <= currLimit) {
                insertIntoTrie(nums[numsPtr], power, root);
                numsPtr += 1;
            }

            int currResult = maxXorPossibleWithElementsInTrie(currNum, power, root);

            result[currIndex] = currResult;
            queryPtr += 1;
        }

        return result;

    }
}
