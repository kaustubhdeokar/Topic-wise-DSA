package dp.lcs;

public class D_PrintLCS {

    public StringBuilder printLcs(String s1, String s2) {

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
                    dp[ind1][ind2] = Integer.max(dp[ind1 - 1][ind2], dp[ind1][ind2 - 1]);
                System.out.print(dp[ind1][ind2]+" ");
            }
            System.out.println();
        }

        int i = n;
        int j = m;

        StringBuilder lcs = new StringBuilder();
        while (i > 0 && j > 0) {
            if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                lcs.append(s1.charAt(i - 1));
                i-=1;
                j-=1;
            } else if (dp[i - 1][j] > dp[i][j - 1]) {
                i-=1;
            } else {
                j-=1;
            }
        }
        System.out.println("s1:" + s1 + ", s2:" + s2 + ", lcs:" + lcs.reverse());
        return lcs.reverse();
    }


    public static void main(String[] args) {
        D_PrintLCS printAllLcs = new D_PrintLCS();
        printAllLcs.printLcs("hfofxe", "hfxeof");
    }
}