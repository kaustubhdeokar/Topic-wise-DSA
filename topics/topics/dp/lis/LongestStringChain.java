package dp.lis;

import java.util.*;

public class LongestStringChain {

    public static void main(String[] args) {


//        String[] words = {"a", "b", "ba", "bca", "bda", "bdca"};
        String[] words = {"xbc","pcxbcf","xb","cxbc","pcxbc"};
        LongestStringChain lsc = new LongestStringChain();
        //lsc.bruteForce(words);
        lsc.usingLis(words);

    }

    private void usingLis(String[] words) {

        Comparator<String> comp = (c1, c2) -> Integer.compare(c1.length(), c2.length());
        List<String> wordList = new ArrayList<>(List.of(words));
        Collections.sort(wordList, comp);

        int[] lis = new int[words.length];
        Arrays.fill(lis, 1);
        int[] sequence = new int[words.length];
        for (int i = 1; i < wordList.size(); i++) {
            for (int j = 0; j < i; j++) {
                if (compare(wordList.get(i), wordList.get(j)) && lis[j] + 1 > lis[i]) {
                    lis[i] = lis[j] + 1;
                    sequence[i] = j;
                }
            }
        }

        printLongestStringChain(words, lis, sequence);
    }

    private void printLongestStringChain(String[] words, int[] lis, int[] sequence) {
        int largestLis = -1;
        int lisEndingAt = -1;
        for (int i = 0; i < words.length; i++) {
            System.out.print(lis[i] + " ");
            if (lis[i] > largestLis) {
                largestLis = lis[i];
                lisEndingAt = i;
            }
        }
        System.out.println(largestLis + ":" + lisEndingAt);

        List<String> list = new ArrayList<>();
        int start = lisEndingAt;
        while (sequence[start] != start) {
            list.add(words[start]);
            start = sequence[start];
        }
        list.add(words[start]);
        Collections.reverse(list);
        System.out.println(list);
    }

    private boolean compare(String word, String word1) {
        int ptr1 = 0;
        int ptr2 = 0;
        int diff = 0;
        if (word.length() == word1.length()) return false;

        String smaller = word.length() < word1.length() ? word : word1;
        String larger = word.length() > word1.length() ? word : word1;

        while (ptr1 < smaller.length() && ptr2 < larger.length()) {
            if (smaller.charAt(ptr1) == larger.charAt(ptr2)) {
                ptr1 += 1;
                ptr2 += 1;
            } else {
                diff += 1;
                if (diff > 1) return false;
                ptr2 += 1;
            }
        }
        while (ptr1 < smaller.length()) {
            diff += 1;
            ptr1 += 1;
            if (diff > 1) return false;
        }
        while (ptr2 < larger.length()) {
            diff += 1;
            ptr2 += 1;
            if (diff > 1) return false;
        }
        return true;
    }

    private void bruteForce(String[] words) {
        Set<String> wordSet = new HashSet<>(List.of(words));
        Map<String, Integer> wordRank = new HashMap<>();
        wordRank.put("", 0);
        LongestStringChain longestStringChain = new LongestStringChain();
        String curr = "";
        longestStringChain.bruteForce(wordSet, curr, wordRank);
        System.out.println(wordRank);
    }

    private void bruteForce(Set<String> wordSet, String curr, Map<String, Integer> wordRank) {

        int currWordRank = wordRank.get(curr);
        for (int i = 0; i <= curr.length(); i++) {
            StringBuilder prefix = new StringBuilder(curr.substring(0, i));
            StringBuilder suffix = new StringBuilder(curr.substring(i));
            for (int j = 0; j < 26; j++) {
                char currChar = (char) ('a' + j);
                String str = prefix.toString() + currChar + suffix;
                if (wordSet.contains(str)) {
                    wordSet.remove(str);
                    wordRank.put(str, currWordRank + 1);
                    bruteForce(wordSet, str, wordRank);
                    wordSet.add(str);
                }
            }
        }
    }
}
