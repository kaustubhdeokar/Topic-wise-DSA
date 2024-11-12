package dp.problems;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WordBreak {
    public boolean wordBreak(String s, List<String> wordDict) {

        Set<String> set = new HashSet<>(wordDict);
        int[][] dp = new int[s.length()][s.length()];
        for (int[] d : dp) Arrays.fill(d, -1);
        return wordBreak(s, 0, s.length() - 1, set, dp);

    }

    public boolean wordBreak(String s, int start, int end, Set<String> set, int[][] dp) {

        if (start > end) return true;
        if (dp[start][end] != -1) {
            if (dp[start][end] == 1) return true;
            return false;
        }

        StringBuilder curr = new StringBuilder();
        for (int i = start; i <= end; i++) {
            curr.append(s.charAt(i));
            if (set.contains(curr.toString())) {
                boolean res = wordBreak(s, i + 1, end, set, dp);
                if (res) {
                    return true;
                }
            }
        }
        dp[start][end] = 0;
        return false;

    }

    public static void main(String[] args) {

        WordBreak wordBreak = new WordBreak();
        List<String> list = List.of("cats", "dog", "sand", "and", "cat");
        System.out.println(wordBreak.wordBreak("catsandog", list));
    }
}
