package problems;//again the core concept of lcs.
//pallindromes are nothing but same string written front and back.

public class LongestPallindromicSubsequence {
    
    public int longestPalinSubseq(String s)
    {
        String s2 = new StringBuilder(s).reverse().toString();
        
        //System.out.println(s+":"+s2);
        
        int l1 = s.length();
        int l2 = s2.length();
	    int[][] dp = new int[l1+1][l2+1];

        for(int i=1;i<=l1;i++){
	        for(int j=1;j<=l2;j++){
	            if(s.charAt(i-1)==s2.charAt(j-1)){
	                dp[i][j] = 1 + dp[i-1][j-1];
	            }
	            else{
	                dp[i][j] = Integer.max(dp[i-1][j], dp[i][j-1]);
	            }
	       }
	    }
	    
	    return dp[l1][l2];
	    
    }

    public static void main(String[] args) {
        LongestPallindromicSubsequence sub = new LongestPallindromicSubsequence();
        System.out.println(sub.longestPalinSubseq("bbabcbcab"));
    }



}
