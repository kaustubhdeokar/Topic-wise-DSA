package dp.lcs;

import java.util.HashMap;
import java.util.Map;

public class LexicographicallyLargestSubsequence {

    public static void main(String[] args) {

        String s = "abcd";
        LexicographicallyLargestSubsequence lc = new LexicographicallyLargestSubsequence();
        int N = 0;
        String t = "b";
        StringBuilder result = new StringBuilder();
        Map<String, Integer> map = new HashMap<>();
        System.out.println(lc.generateString(s.toCharArray(), result, t, N, map));
        System.out.println( map);
    }

    public int generateString(char[] s, StringBuilder result, String t, int i, Map<String, Integer> memo) {
        if (i == s.length) {
            if (result.toString().compareTo(t) > 0) return 1;
            return 0;
        }
        String key = i + "|" + result.toString();
        if (memo.containsKey(key)) {
            return memo.get(key);
        }

        result.append(s[i]);
        int res1 = generateString(s, result, t, i + 1, memo);
        result.deleteCharAt(result.length() - 1);
        int res2 = generateString(s, result, t, i + 1, memo);
        System.out.println("i:" + i + " res:" + (res2 + res1));
        memo.put(i + "|" + result.toString(), res1 + res2);
        return res1 + res2;
    }

}
