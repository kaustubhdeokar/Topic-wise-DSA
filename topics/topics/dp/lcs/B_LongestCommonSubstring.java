package dp.lcs;

public class B_LongestCommonSubstring {
    public static void main(String[] args) {
        String y = "hfofxe";
        String x = "hfxeof";
        B_LongestCommonSubstring lcs = new B_LongestCommonSubstring();
        //lcs.recursive(x, y);
        int[][] dp = new int[x.length() + 1][y.length() + 1];
        lcs.bottomUp(dp, x, y);
    }

    private void bottomUp(int[][] dp, String x, String y) {

        int maxCount = 0;
        int maxI = 0, maxJ = 0;

        for (int i = 1; i < x.length(); i++) {
            for (int j = 1; j < y.length(); j++) {
                if (x.charAt(i-1) == y.charAt(j-1)) {
                    dp[i][j] = 1 + dp[i-1][j-1];
                    if(dp[i][j]>maxCount){
                        maxCount = dp[i][j];
                        maxI = i;
                        maxJ = j;
                    }
                }
                else{
                    dp[i][j] = 0;
                }
            }
        }

//        for(int i=0;i<=x.length();i++){
//            for(int j=0;j<=y.length();j++){
//                System.out.print(dp[i][j]+" ");
//            }
//            System.out.println();
//        }

        System.out.println(maxCount+":"+maxI+":"+maxJ);

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