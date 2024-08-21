public class LongestCommonSubsequence {
    public static void main(String[] args) {
        
        String s1 = "abcc";
        String s2 = "asdc";
        System.out.println(longestCommonSubsequence(s1, s2));
        System.out.println(recursive(s1, s2));

    }

    public static int recursive(String s1, String s2){
        return recursive(s1, s1.length(), s2, s2.length());
    }
    
    public static int recursive(String s1, int m, String s2, int n){
        
        if(m==0 || n==0){
            return 0;
        }

        if(s1.charAt(m-1) == s2.charAt(n-1)){
            return 1 + recursive(s1, m-1, s2, n-1);
        }
        else{
            return Integer.max(recursive(s1, m-1, s2, n) , recursive(s1, m, s2, n-1));
        }

    }


    public static int longestCommonSubsequence(String s1, String s2) {
        
        int m = s1.length();
        int n = s2.length();
        int[][] dp = new int[m+1][n+1];

        return lcs(s1, s2, dp, m, n);
        
    }
    
    private static int lcs(String s1, String s2, int[][] dp, int m, int n) {

        for(int i=1;i<=m;i++){
            for(int j=1;j<=n;j++){
                if(s1.charAt(i-1) == s2.charAt(j-1)){
                    dp[i][j] = 1 + dp[i-1][j-1];
                }
                else{
                    dp[i][j] = Integer.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }

        return dp[m][n];
    }
}
