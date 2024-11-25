package dp.lcs;

import java.util.HashSet;
import java.util.Set;

public class B_LongestCommonSubstring {
    public static void main(String[] args) {
        String x = "hfofxe";
        String y = "hfxeof";
        B_LongestCommonSubstring lcs = new B_LongestCommonSubstring();
//        lcs.recursive(x, y);
        System.out.println("tabulation res:" + lcs.tabulation(x, y, 3));

    }

    private boolean tabulation(String x, String y, int cuts) {
        int xLen = x.length();
        int yLen = y.length();
        int[][] dp = new int[xLen + 1][yLen + 1];
        Set<String> substrings = new HashSet<>();
        int max = -1;
        for (int i = 1; i <= xLen; i++) {
            for (int j = 1; j <= yLen; j++) {
                if (x.charAt(i - 1) == y.charAt(j - 1)) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                    if (dp[i][j] >= 1) {
                        substrings.add(x.substring(i - dp[i][j], i));
                        substrings.add(String.valueOf(x.charAt(i - 1)));
                        substrings.add(y.substring(j - dp[i][j], j));
                        substrings.add(String.valueOf(y.charAt(j - 1)));
                    }
                    max = dp[i][j] > max ? dp[i][j] : max;
                } else {
                    dp[i][j] = 0;
                }
            }
        }

        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {
                System.out.print(dp[i][j] + " ");
            }
            System.out.println();
        }

        return findKCuts(y, substrings, cuts);
    }

    private boolean findKCuts(String target, Set<String> substrings, int cuts) {
        int t = 0;
        StringBuilder str = new StringBuilder();
        int currentCuts = 0;
        while (!target.isEmpty() && currentCuts < cuts) {
            while (t < target.length() && (str.isEmpty() || substrings.contains(str.toString()))) {
                str.append(target.charAt(t));
                t += 1;
            }
            if (!substrings.contains(str.toString())) {
                str = str.deleteCharAt(str.length() - 1);
            }
            currentCuts += 1;
            target = target.replace(str.toString(), "");
            str = new StringBuilder();
            t = 0;
        }

        return currentCuts <= cuts && target.isEmpty();


    }

    private void recursive(String x, String y) {
        int[] maxYet = new int[]{0};
        recursive(x, x.length(), y, y.length(), maxYet);
        System.out.println("recursion res:" + maxYet[0]);

    }

    private int recursive(String x, int xLen, String y, int yLen, int[] maxYet) {
        if (xLen == 0 || yLen == 0) return 0;

        if (x.charAt(xLen - 1) == y.charAt(yLen - 1)) {
            int midRes = 1 + recursive(x, xLen - 1, y, yLen - 1, maxYet);
            maxYet[0] = Integer.max(maxYet[0], midRes);
            return midRes;
        } else {
            recursive(x, xLen, y, yLen - 1, maxYet);
            recursive(x, xLen - 1, y, yLen, maxYet);
            return 0;
        }

    }


}