//again the core concept of lcs.
//pallindromes are nothing but same string written front and back.
//here an extra step is to calculate the actual lcs string and calculate deletions.

public class NumberOfDeletionsToMakeItPallindrome {
    
    public int longestPalinSubseq(String s){

        String s2 = new StringBuilder(s).reverse().toString();
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

        String lcsString = extractLCSString(dp, s, s2);
        System.out.println("lcs string:"+lcsString);
        int deletions = calculateDeletions(lcsString, s);
        
        
 
        return deletions;
	    
    }

    public int calculateDeletions(String lcString, String s){

        int l1 = lcString.length();
        int l2 = s.length();
        int i=0;
        int j=0;
        int deletions = 0;
        while(i<l1 && j<l2){
            if(lcString.charAt(i)!=s.charAt(j)){
                System.out.println(s.charAt(j));
                deletions+=1;
                j+=1;
            }
            else{
                i+=1;
                j+=1;
            }
        }
        System.out.println("total deletions:"+deletions);
        return deletions;

    }

    public String extractLCSString(int[][] dp, String s1, String s2){
        int i = s1.length();
        int j = s2.length();
        StringBuilder str = new StringBuilder();
        while(i>0 && j>0){
            if(s1.charAt(i-1)==s2.charAt(j-1)){
                //System.out.print(s.charAt(i-1)+" ");
                str.append(s1.charAt(i-1));
                i-=1;
                j-=1;
            }
            else if(dp[i-1][j]>dp[i][j-1]){
                i-=1;
            }
            else{
                j-=1;
            }
        }
        return str.toString();
    }

    public static void main(String[] args) {
        NumberOfDeletionsToMakeItPallindrome sub = new NumberOfDeletionsToMakeItPallindrome();
        System.out.println(sub.longestPalinSubseq("agbcba"));
    }



}
