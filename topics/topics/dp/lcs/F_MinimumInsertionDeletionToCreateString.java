package dp.lcs;

import java.util.Arrays;

public class F_MinimumInsertionDeletionToCreateString {

    public static void main(String[] args) {

        String from = "abcd";
        String to = "anc";
        F_MinimumInsertionDeletionToCreateString min = new F_MinimumInsertionDeletionToCreateString();
        String lcs = min.convertString(from, to);

        System.out.println(lcs);

        int insertions = 0;
        int fromItr = 0;
        int lcsIter = 0;
        while (fromItr < from.length() && lcsIter < lcs.length()) {
            while (from.charAt(fromItr) != lcs.charAt(lcsIter)) {
                System.out.println("to remove:" + from.charAt(fromItr));
                fromItr += 1;
            }
            System.out.println("matched:" + lcs.charAt(lcsIter));
            fromItr += 1;
            lcsIter += 1;
        }
        while (fromItr < from.length()) {
            System.out.println(from.charAt(fromItr));
            fromItr += 1;
        }




    }

    private String convertString(String from, String to) {

        int[][] dp = new int[from.length()][to.length()];
        for (int[] arr : dp) {
            Arrays.fill(arr, -1);
        }
        StringBuilder answer = new StringBuilder();
        findCommonSubsequence(from, from.length() - 1, to, to.length() - 1, dp, answer);
        return answer.reverse().toString();
    }

    private int findCommonSubsequence(String from, int fromLen, String to, int toLen, int[][] dp, StringBuilder answer) {
        if (fromLen < 0 || toLen < 0) {
            return 0;
        }
        if (dp[fromLen][toLen] != -1) {
            return dp[fromLen][toLen];
        }

        if (from.charAt(fromLen) == to.charAt(toLen)) {
            answer.append(from.charAt(fromLen));
            dp[fromLen][toLen] = 1 + findCommonSubsequence(from, fromLen - 1, to, toLen - 1, dp, answer);
        } else {
            dp[fromLen][toLen] = Integer.max(findCommonSubsequence(from, fromLen - 1, to, toLen, dp, answer),
                    findCommonSubsequence(from, fromLen, to, toLen - 1, dp, answer));

        }
        return dp[fromLen][toLen];
    }

}
