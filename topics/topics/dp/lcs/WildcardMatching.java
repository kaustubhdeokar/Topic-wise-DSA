package dp.lcs;

import java.util.Arrays;

public class WildcardMatching {
    public static void main(String[] args) {

        String s1 = "aabc";
        String s2 = "*aabc";

        int[][] memo = new int[s1.length() + 1][s2.length() + 1];
        for (int[] m : memo) {
            Arrays.fill(m, -1);
        }

        WildcardMatching wildcardMatching = new WildcardMatching();
        boolean res = wildcardMatching.match(memo, s1, s1.length(), s2, s2.length());
    }

    private boolean match(int[][] memo, String s1, int i, String pattern, int p) {

        if (i == 0 && p == 0) return true;
        if (i != 0 && p == 0) return false;
        if (i == 0 && p > 0) {
            for (int k = 0; k <= p; k++) {
                if (pattern.charAt(k) != '*') return false;
            }
            return true;
        }

        if (memo[i][p] != -1) return memo[i][p] == 1;

        boolean res;
        if (s1.charAt(i - 1) == pattern.charAt(p - 1) || pattern.charAt(p - 1) == '?') {
            res = match(memo, s1, i - 1, pattern, p - 1);
        } else {
            res = match(memo, s1, i - 1, pattern, p) || match(memo, s1, i, pattern, p-1);
        }
        if(res){
            memo[i][p] = 1;
        }
        else{
            memo[i][p] = 0;
        }
        return res;
    }

}
