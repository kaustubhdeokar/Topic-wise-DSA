public class ShortestCommonSSPrinted {
    

    public String shortestCommonSupersequence(String s, String s2) {
        
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
        //System.out.println("lcsstring:"+lcsString);

        return formShortestCommonSS(lcsString, s, s2);

    }

    public String formShortestCommonSS(String lcsString, String s1, String s2){
        
        int i=0,j=0,k=0;
        int l = lcsString.length();
        int l1 = s1.length();
        int l2 = s2.length();
        StringBuilder str = new StringBuilder();

        while(k<l){
            while(s1.charAt(i)!=lcsString.charAt(k)){
                str.append(s1.charAt(i));
                i+=1;
            }
            while(s2.charAt(j)!= lcsString.charAt(k)){
                str.append(s2.charAt(j));
                j+=1;
            }
            str.append(lcsString.charAt(k));
            i+=1;
            j+=1;
            k+=1;

//            System.out.println(str.toString());
        }

        while(i<l1){
            str.append(s1.charAt(i));
            i+=1;
        }
        while(j<l2){
            str.append(s2.charAt(j));
            j+=1;
        }

        //System.out.println(str.toString());

        return str.toString();

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
        return str.reverse().toString();
    }

    public static void main(String[] args) {
        
        ShortestCommonSSPrinted ss = new ShortestCommonSSPrinted();
        System.out.println(ss.shortestCommonSupersequence("abac","cab"));


    }

}
