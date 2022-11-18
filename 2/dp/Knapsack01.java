public class Knapsack01 {
    
    public static void main(String[] args) {
      
        int N = 3;
        int W = 4;
        int val[] = {1,2,3};
        int wt[] = {4,5,1};

        System.out.println("Expected is 3, actual is :"+knapSack(W, wt, val, N));

    }

    static int knapSack(int W, int wt[], int val[], int n) 
    { 
         
        int[][] dp = new int[W+1][n+1];
        
        return knapSack(dp, W, wt, val, n);
         
    }
    
    static int knapSack(int[][] dp, int W, int[] wt, int[] val, int n){
        
                 
        if(W==0 || n==0)
            return 0;

        if(dp[W][n]!=0)
            return dp[W][n];
            
        if(wt[n-1]<=W){
            return dp[W][n] = Integer.max(val[n-1]+knapSack(dp, W-wt[n-1], wt, val, n-1),
                                knapSack(dp, W, wt, val, n-1));
        }
        else{
            return dp[W][n] = knapSack(dp, W, wt, val, n-1);
        }
    

    }

}
