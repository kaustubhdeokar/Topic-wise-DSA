public class Knapsack01BottomUp {
    
    public static void main(String[] args) {
      
        int N = 3;
        int W = 4;
        int val[] = {1,2,3};
        int wt[] = {4,5,1};

        System.out.println("Expected is 3, actual is :"+knapSack(W, wt, val, N));

    }


   
    public static int knapSack(int w, int[] wt, int[] val, int n){

        int[][] dp = new int[n+1][w+1];
        
        for(int i=1;i<=n;i++){

            for(int j=1;j<=w;j++){

                /*
                if(wt[n-1]<=W){
                        return Integer.max(
                        val[n-1]+knapSack(W-wt[n-1], wt, val, n-1),
                        knapSack(W, wt, val, n-1));
                    }
                    else{
                        return knapSack(W, wt, val, n-1);
                    } 
                
                */

                if(wt[i-1]<=j){
                    dp[i][j] = Integer.max(val[i-1] + dp[i-1][j-wt[i-1]],
                                        dp[i-1][j]);
                }
                else{
                    dp[i][j] = dp[i-1][j];
                }
                
            }

        }


        return dp[n][w];

    }

}
