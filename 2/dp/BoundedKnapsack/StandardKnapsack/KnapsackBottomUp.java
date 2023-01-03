public class KnapsackBottomUp {
    public static void main(String[] args) {
      
        int N = 3;
        int W = 4;
        int val[] = {1,2,3};
        int wt[] = {4,5,1};

        System.out.println("Expected is 3, actual is :"+ knapsack(W, wt, val, N));

    }

    public static int knapsack(int W, int[] wt, int[] val, int N){

        int[][] dp = new int[N+1][W+1];

        //initialisation - first row 0 (0 items)
        //initialisaion - first column 0 (0 weight)

        return calculateMaxProfit(dp, W, wt, val, N);

    }

    public static int calculateMaxProfit(int[][] dp, int W, int[] wt, int[] val, int N){

        for(int i=1;i<=N;i++){
            for(int j=1;j<=W;j++){
                if(j>=wt[i-1]){
                    dp[i][j] = Integer.max(val[i-1]+dp[i-1][j-wt[i-1]], dp[i-1][j]);
                }
                else{
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        

        /*
        entirely based on the recursion solution. 
        initialisation is done in the previous method. 
        
        if(W>=wt[N-1]){
            return Integer.max(val[N-1]+knapsack(dp, W-wt[N-1],wt, val, N-1),
                                knapsack(dp, W, wt, val, N-1));
        }
        else{
            return knapsack(dp, W, wt, val, N-1);
        }
          
         */
       
        return dp[N][W];
    }
}
