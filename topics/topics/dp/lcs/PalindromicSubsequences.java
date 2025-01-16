package dp.lcs;

import java.util.HashMap;
import java.util.Map;

public class PalindromicSubsequences {
    public static void main(String[] args) {

        String str = "abba";
        int n = 0;

        StringBuilder tempString = new StringBuilder();
        PalindromicSubsequences solution = new PalindromicSubsequences();
        //expected , 9 i guess.
//        int result = solution.recursive(str, n, tempString);
//        System.out.println(result);

        Map<String, Integer> cache = new HashMap<>();
        int res = solution.memoization(str, n, tempString, cache);
        System.out.println(res);
        // now caching the results so that we don't have to repeat them.
        //lesssgoooo
    }

    private int memoization(String str, int n, StringBuilder tempString, Map<String, Integer> cache) {
        // base case - n==str.length() stop and evaluate.
        if (n == str.length()) {
            System.out.println("tempString:" + tempString);
            return checkForPalindrome(tempString) ? 1 : 0;
        }

        String key = tempString + ":" + n;

        if(cache.get(key)!=null) {
            //what the fff
            System.out.println("found match for :"+key);
            return cache.get(key);
        }

        //else.
        //take
        tempString.append(str.charAt(n));
        int res1 = memoization(str, n + 1, tempString, cache);
        tempString.deleteCharAt(tempString.length() - 1);

        //not take
        //you stupid fff
        int res2 = memoization(str, n + 1, tempString, cache);

        cache.put(key, res1 + res2);
        return res1 + res2;

    }

    private int recursive(String str, int n, StringBuilder tempString) {
        // base case - n==str.length() stop and evaluate.
        if (n == str.length()) {
            System.out.println("tempString:" + tempString);
            return checkForPalindrome(tempString) ? 1 : 0;
        }
        //else.
        //take
        tempString.append(str.charAt(n));
        int res1 = recursive(str, n + 1, tempString);
        tempString.deleteCharAt(tempString.length() - 1);

        //not take
        int res2 = recursive(str, n + 1, tempString);
        return res1 + res2;
    }

    private boolean checkForPalindrome(StringBuilder tempString) {
        //extra 1 comes up due to empty
        if (tempString.isEmpty()) return false;
        int i = 0;
        int j = tempString.length() - 1;
        while (i < j) {
            if (tempString.charAt(i) == tempString.charAt(j)) {
                i += 1;
                j -= 1;
            } else {
                return false;
            }
        }
        return true;
    }
}
