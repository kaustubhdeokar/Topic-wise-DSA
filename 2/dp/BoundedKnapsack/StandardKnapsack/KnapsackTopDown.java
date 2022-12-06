import java.util.*;

public class KnapsackTopDown {
    
    public static void main(String[] args) {
      
        int N = 3;
        int W = 4;
        int val[] = {1,2,3};
        int wt[] = {4,5,1};

        System.out.println("Expected is 3, actual is :"+ knapsack(W, wt, val, N));

    }

    public static int knapsack(int W, int[] wt, int[] val, int N){

        int[][] dp = new int[N+1][W+1];

        for(int i=0;i<dp.length;i++){
            Arrays.fill(dp[i], -1);
        }
        
        calculateMaxProfit(dp, W, wt, val, N);

        return dp[N][W];
    }

    public static int calculateMaxProfit(int[][] dp, int W, int[] wt, int[] val, int N){

        if(N==0 || W==0){
            return 0;
        }

        if(dp[N][W]!=-1){
            return dp[N][W];
        }

        if(wt[N-1]<=W){
            dp[N][W] =  Integer.max(val[N-1]+calculateMaxProfit(dp, W-wt[N-1], wt, val, N-1),
            calculateMaxProfit(dp, W, wt, val, N-1));
        }
        else 
            dp[N][W] =  calculateMaxProfit(dp, W, wt, val, N-1);

        return dp[N][W];
    }
}
