package dp.problems;
// question is to display the min operations to convert str1->str2.
// core logic consists of finding dp.lcs.

public class MinOperationsAddAndDelete {
    
    public int minOperations(String str1, String str2) 
	{ 
	    System.out.println("str1:"+str1+" str2:"+str2);
	    int l1 = str1.length();
	    int l2 = str2.length();
	    
	    int[][] dp = new int[l1+1][l2+1];
	    
        //calculate dp.lcs.
        String lcsStr = lcs(dp, str1, str2, l1, l2);
	    System.out.println("lcsstr:"+lcsStr);
        
        //calculate number of deletions from str1.
        int deletions = countChanges(lcsStr, str1);
        System.out.println("deletions:"+deletions);
        
        //calculate number of additions to str2..
        int additions = countChanges(lcsStr, str2);
	    System.out.println("additions:"+additions);
	    
	    return deletions + additions;
	    
	}
	
	
	public int countChanges(String main, String str){
	    
	    int l1 = 0;
	    int l2 = 0;
	    
	    //main - ea
	    //str  - heap
	    int count = 0;
	    
	    while(l1<main.length () && l2<str.length()){
	        
	        if(str.charAt(l2)!=main.charAt(l1)){
	            count+=1;
	            //System.out.println("count:"+count);
	            l2+=1;
	        }
	        else{
	            l1+=1;
	            l2+=1;
	        }
	    }
	    //System.out.println("count:"+count);
	    
	    if(l2!=str.length()){
	        count+= (str.length()-l2);
	    }
	    //System.out.println("count:"+count);
	    return count;
	}
	
	
	public String lcs(int[][]dp, String str1, String str2, int l1, int l2){
	    
	    for(int i=1;i<=l1;i++){
	        for(int j=1;j<=l2;j++){
	            if(str1.charAt(i-1)==str2.charAt(j-1)){
	                dp[i][j] = 1 + dp[i-1][j-1];
	            }
	            else{
	                dp[i][j] = Integer.max(dp[i-1][j], dp[i][j-1]);
	            }
	       }
	    }
	    
	    int count = dp[l1][l2];
	    int i = l1;
	    int j = l2;
	    
	    StringBuilder stringBuilder = new StringBuilder();
	    
	    
	    while(i>0 && j>0){
	        if(str1.charAt(i-1)==str2.charAt(j-1)){
	            stringBuilder.append(str1.charAt(i-1));
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
	    
	    return stringBuilder.reverse().toString();
	}

    public static void main(String[] args) {
        
        MinOperationsAddAndDelete min = new MinOperationsAddAndDelete();
        System.out.println("min operations:"+min.minOperations("dbfef", "ididffab"));

    }

}
