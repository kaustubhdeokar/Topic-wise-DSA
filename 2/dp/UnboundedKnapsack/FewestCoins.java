public class FewestCoins {
    
    public static void main(String[] args) {
        
        int[] minCoins = {Integer.MAX_VALUE};
        int currCount = 0;
        
        int[] coins = {1,2,3};
        int N = 3;
        int sum = 6;

        System.out.println(recursiveKnapsack(coins, N, sum, minCoins, currCount));

    }

    public static int recursiveKnapsack(int coins[], int N, int sum, int[] minCoins, int currCount) {        
        
        if(sum==0){
            minCoins[0] = Integer.min(minCoins[0], currCount);
            return minCoins[0];
        }
        
        if(sum>0 && currCount>minCoins[0]){
            return Integer.MAX_VALUE;
        }

        if(N==0 || sum <0){
            return Integer.MAX_VALUE;
        }

        if(sum>=coins[N-1]){
            minCoins[0] = Integer.min(minCoins[0], Integer.min(recursiveKnapsack(coins, N, sum - coins[N-1], minCoins, currCount+1),
                    recursiveKnapsack(coins, N-1, sum, minCoins, currCount)));
        }

        else{
            minCoins[0] = Integer.min(minCoins[0], recursiveKnapsack(coins, N-1, sum, minCoins, currCount));
        }
        return minCoins[0];
    }
}
