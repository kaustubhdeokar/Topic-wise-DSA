package dp.lcs;

class Scratch {
    public static void main(String[] args) {

        String s1 = "abcaa";
        String s2 = "aacba";
        Scratch s = new Scratch();
        s.lcsTabulation(s1, s1.length(), s2, s2.length());
    }

    private int lcs(int[][] memo, String s1, int l1, String s2, int l2) {
        if (l1 <= 0 || l2 <= 0) return 0;

        if (memo[l1][l2] != -1) return memo[l1][l2];

        if (s1.charAt(l1 - 1) == s2.charAt(l2 - 1)) {
            return memo[l1][l2] = 1 + lcs(memo, s1, l1 - 1, s2, l2 - 1);
        } else {
            return memo[l1][l2] = Integer.max(lcs(memo, s1, l1 - 1, s2, l2), lcs(memo, s1, l1, s2, l2 - 1));
        }
    }

    private int lcsTabulation(String s1, int l1, String s2, int l2) {
        int[][] dp = new int[l1 + 1][l2 + 1];
        for (int i = 1; i <= l1; i++) {
            for (int j = 1; j <= l2; j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Integer.max(dp[i - 1][j], dp[i][j - 1]);
                }
                System.out.print(dp[i][j] + " ");
            }
            System.out.println();
        }

        printLcs(dp, s1, l1, s2, l2);
        return dp[l1][l2];
    }

    private void printLcs(int[][] dp, String s1, int l1, String s2, int l2)
    {
        while (l1 > 0 && l2 > 0) {
            if (s1.charAt(l1 - 1) == s2.charAt(l2 - 1)) {
                System.out.print(s1.charAt(l1 - 1) + " ");
                l1 -= 1;
                l2 -= 1;
            } else if (dp[l1 - 1][l2] > dp[l1][l2 - 1]) {
                l1 -= 1;
            } else {
                l2 -= 1;
            }
        }
    }
}