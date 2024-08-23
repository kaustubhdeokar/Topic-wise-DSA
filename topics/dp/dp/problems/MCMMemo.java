package dp.problems;

import java.util.Arrays;

public class MCMMemo{
    
    public int mcm(int[] arr, int[][] dp, int i, int j){
        
        
        if(i>=j) return 0;

        if(dp[i][j]!=-1) return dp[i][j];


        int min = Integer.MAX_VALUE;

        for(int k=i;k<j;k++){
            int cost = mcm(arr, dp, i, k) + mcm(arr, dp, k+1, j) + arr[i-1]*arr[k]*arr[j];
            if(cost < min){
                min = Integer.min(min, cost);
            }
        }
        
        return min;

    }
    

    public static void main(String[] args){

        int[] arr = {1, 2, 3, 4, 3};

        int i = arr.length;
        int j = arr.length;

        int[][] dp = new int[i+1][j+1];

        for(int i1=0;i1<=arr.length;i1++){
            Arrays.fill(dp[i1],-1);
        }

        MCMMemo mcm = new MCMMemo();
        System.out.println(mcm.mcm(arr, dp, 1, arr.length-1));

    }
}