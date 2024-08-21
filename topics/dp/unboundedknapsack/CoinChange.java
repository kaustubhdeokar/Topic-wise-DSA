public class CoinChange {
    
    public static long recursiveKnapsack(int coins[], int N, int sum) {        
        
        if(sum==0){
            return 1;
        }
        
        if(N==0 || sum <0){
            return 0;
        }

        if(sum>=coins[N-1]){
            return recursiveKnapsack(coins, N, sum - coins[N-1]) + recursiveKnapsack(coins, N-1, sum);
        }

        else{
            return recursiveKnapsack(coins, N-1, sum);
        }

    }

    public static long dp(int[] coins, int N, int sum){

        long[][] dp = new long[N+1][sum+1];
        
        for(int j=0;j<=sum;j++){
            dp[0][j] = 0;
        }
        for(int i=0;i<=N;i++){
            dp[i][0] = 1;
        }

        for(int i=1;i<=N;i++){
            for(int j=1;j<=sum;j++){
                if(j>=coins[i-1]){
                    dp[i][j] = dp[i][j-coins[i-1]] + dp[i-1][j];
                }
                else{
                    dp[i][j] = dp[i-1][j];
                }
            }
        }

        return dp[N][sum];
    }


    

    public static void main(String[] args) {
        
        int[] coins = new int[]{2,5,3,6};
        int N =4;
        int sum = 10;
        System.out.println(recursiveKnapsack(coins, N, sum));
        System.out.println(dp(coins, N, sum));
    }
}
