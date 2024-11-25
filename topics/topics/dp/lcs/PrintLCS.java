package dp.lcs;

public class PrintLCS {
    public static void main(String[] args) {
        String s1 = "hfofxe";
        String s2 = "hfxeof";
        PrintLCS printLCS = new PrintLCS();
//        System.out.println(printLCS.topDown(s1, s2));
        System.out.println(printLCS.bottomUp(s1,s2));
    }

    public String topDown(String x, String y) {
        A_LongestCommonSubsequence lcs = new A_LongestCommonSubsequence();
        int[][] dp = lcs.topDownReturnsArr(x, y);
        return calculateLcsString(dp, x, x.length(), y, y.length());
    }

    private String calculateLcsString(int[][] dp, String x, int x1, String y, int y1) {
        for (int[] arr : dp) {
            for (int a : arr) {
                System.out.print(a + " ");
            }
            System.out.println();
        }

        StringBuilder res = new StringBuilder();

        while (x1 > 0 && y1 > 0) {

            if (x.charAt(x1 - 1) == y.charAt(y1 - 1)) {
                res.append(x.charAt(x1 - 1));
                x1 -= 1;
                y1 -= 1;
            } else if (dp[x1 - 1][y1] > dp[x1][y1 - 1]) {
                x1 -= 1;
            } else {
                y1 -= 1;
            }

        }
        return res.toString();
    }

    private int topDown(int[][] dp, String x, int xitr, String y, int yitr) {
        if (xitr == 0 || yitr == 0) return 0;

        if (dp[xitr][yitr] != 0) {
            return dp[xitr][yitr];
        }

        if (x.charAt(xitr - 1) == y.charAt(yitr - 1)) {
            dp[xitr][yitr] = 1 + topDown(dp, x, xitr - 1, y, yitr - 1);
        } else {
            dp[xitr][yitr] = Integer.max(topDown(dp, x, xitr - 1, y, yitr), topDown(dp, x, xitr, y, yitr - 1));
        }
        return dp[xitr][yitr];
    }

    private int bottomUp(String s1, String s2) {
        int[][] dp = new int[s1.length()][s2.length()];
        for (int i = 0; i < s1.length(); i++) {
            dp[i][0] = 0;
        }
        for (int j = 0; j < s2.length(); j++) {
            dp[0][j] = 0;
        }
        for (int i = 1; i < s1.length(); i++) {
            for (int j = 1; j < s2.length(); j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        for(int i=0;i<s1.length();i++){
            for(int j=0;j<s2.length();j++){
                System.out.print(dp[i][j]+" ");
            }
            System.out.println();
        }
        return dp[s1.length()-1][s2.length()-1];
    }


}
    