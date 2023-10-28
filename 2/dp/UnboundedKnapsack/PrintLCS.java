import java.util.ArrayList;
import java.util.List;

public class PrintLCS {
        public static void main(String[] args) {
            
            String s1 = "abcc";
            String s2 = "asdc";
            // System.out.println(longestCommonSubsequence(s1, s2));
            
            s1 = "dbfef";
            s2 = "ididffab";

            PrintLCS printLCS = new PrintLCS();
            System.out.println(printLCS.longestCommonSubsequence(s1, s2));
    
        }
    
        public char[] longestCommonSubsequence(String s1, String s2) {
            
            int m = s1.length();
            int n = s2.length();
            int[][] dp = new int[m+1][n+1];
    
            int ans = lcs(s1, s2, dp, m, n);
            
            char[] chars = new char[ans+1];

            for(int i=1;i<=m;i++){
                for(int j=1;j<=n;j++){
                    if(s1.charAt(i-1) == s2.charAt(j-1)){
                        dp[i][j] = 1 + dp[i-1][j-1];
                        chars[dp[i][j]] = s1.charAt(i-1);
                    }
                    else{
                        dp[i][j] = Integer.max(dp[i-1][j], dp[i][j-1]);
                    }
                }
            }
    
            return chars;
        }
        
        private int lcs(String s1, String s2, int[][] dp, int m, int n) {
    
    
            int max = Integer.MIN_VALUE;
            
            List<Character> list = new ArrayList<>();
            int len = Integer.min(s1.length(), s2.length());
            for(int i=0;i<len;i++){
                list.add('-');
            }
            


            for(int i=1;i<=m;i++){
                for(int j=1;j<=n;j++){
                    if(s1.charAt(i-1) == s2.charAt(j-1)){
                        dp[i][j] = 1 + dp[i-1][j-1];
                        max = Integer.max(max, dp[i][j]);
                    }
                    else{
                        dp[i][j] = Integer.max(dp[i-1][j], dp[i][j-1]);
                    }
                }
            }
    
            return max;
        }
}
    