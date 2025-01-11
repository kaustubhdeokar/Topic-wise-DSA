package dp.lcs;

import java.util.ArrayList;
import java.util.List;

public class D_PrintAllLcs {

    public void printLcs(String s1, String s2) {

        int n = s1.length();
        int m = s2.length();

        int[][] dp = new int[n + 1][m + 1];
        for (int i = 0; i <= n; i++) {
            dp[i][0] = 0;
        }
        for (int i = 0; i <= m; i++) {
            dp[0][i] = 0;
        }

        for (int ind1 = 1; ind1 <= n; ind1++) {
            for (int ind2 = 1; ind2 <= m; ind2++) {
                if (s1.charAt(ind1 - 1) == s2.charAt(ind2 - 1))
                    dp[ind1][ind2] = 1 + dp[ind1 - 1][ind2 - 1];
                else
                    dp[ind1][ind2] = 0 + Math.max(dp[ind1 - 1][ind2], dp[ind1][ind2 - 1]);
            }
        }

        for (int[] d : dp) {
            for (int d1 : d) {
                System.out.print(d1 + " ");
            }
            System.out.println();
        }
        System.out.println();

        int i = n;
        int j = m;

        StringBuilder lcs = new StringBuilder();
        while (i > 0 && j > 0) {
            if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                lcs.append(s1.charAt(i - 1));
                i--;
                j--;
            } else if (dp[i - 1][j] > dp[i][j - 1]) {
                i--;
            } else {
                j--;
            }
        }
        System.out.println("s1:" + s1 + ", s2:" + s2 + ", lcs:" + lcs.reverse());
    }


    public static void main(String[] args) {
        D_PrintAllLcs printAllLcs = new D_PrintAllLcs();
        printAllLcs.printLcs("hfofxe", "hfxeof");
    }
}