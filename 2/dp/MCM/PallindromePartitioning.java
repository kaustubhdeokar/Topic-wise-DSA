import java.util.Arrays;

public class PallindromePartitioning {
    
    public int mcm(String str, int i, int j){
        
        if(i>=j){
            return 0;
        }

        if(isPallindrome(str, i, j)){
            return 0;
        }

        int min = Integer.MAX_VALUE;

        for(int k=i;k<j;k++){
            int cost = mcm(str, i, k) + mcm(str, k+1, j) + 1;
            if(cost < min){
                min = Integer.min(min, cost);
            }
        }
        
        return min;

    }
    
    public boolean isPallindrome(String arr, int i, int j){
        while(i<j){
            if(arr.charAt(i)!= arr.charAt(j)){
                return false;
            }
            i+=1;
            j-=1;
        }
        return true;
    }


    public static void main(String[] args){

        String str = "ababbnitin";

        int i = str.length();
        int j = str.length();

        int[][] dp = new int[i+1][j+1];
        for(int i1=0;i1<=i;i1++){
            Arrays.fill(dp[i1],-1);
        }

        // int i = str.length();
        // int j = arr.length;

        // int[][] dp = new int[i+1][j+1];


        PallindromePartitioning mcm = new PallindromePartitioning();
        System.out.println(mcm.mcm(str, 0, str.length()-1));

    }

}
