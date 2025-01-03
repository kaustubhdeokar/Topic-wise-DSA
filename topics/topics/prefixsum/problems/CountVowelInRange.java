package prefixsum.problems;

import java.util.Set;
//2559. https://leetcode.com/problems/count-vowel-strings-in-ranges
public class CountVowelInRange {
    public int[] vowelStrings(String[] words, int[][] queries) {

        int[] result = new int[queries.length];
        Set<Character> vowels = Set.of('a', 'e', 'i', 'o', 'u');
        int count = 0;
        int[] dp = new int[words.length];

        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            if (vowels.contains(word.charAt(0)) && vowels.contains(word.charAt(word.length() - 1))) {
                count += 1;
            }
            dp[i] = count;
        }

        for (int i = 0; i < queries.length; i++) {
            int start = queries[i][0];
            if (start != 0) {
                result[i] = dp[queries[i][1]] - dp[queries[i][0] - 1];
            } else {
                result[i] = dp[queries[i][1]];
            }
        }

        return result;

    }

}
