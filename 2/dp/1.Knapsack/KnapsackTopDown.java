import java.util.*;

public class KnapsackTopDown {

    public static void main(String[] args) {

        int[] values = { 5, 2, 3 };
        int[] weight = { 1, 5, 1 };

        int N = 3;
        int W = 4;

        int[][] dp = new int[N+1][W+1];
        for(int i=0;i<N+1;i++){
            Arrays.fill(dp[i], -1);
        }

        System.out.println(findOptimalWeight(dp, values, weight, N, W));

    }
    
    

    public static int findOptimalWeight(int[][]dp, int[] values, int[] weight, int N, int W) {

        if (N == 0 || W == 0) {
            dp[N][W] = 0;
        }

        if(dp[N][W]!=-1){
            return dp[N][W];
        }

        if (weight[N - 1] <= W) {

            int a = values[N - 1] + findOptimalWeight(dp, values, weight, N - 1, W - weight[N - 1]);
            int b = findOptimalWeight(dp, values, weight, N - 1, W);
            dp[N][W] = Integer.max(a, b);
        } else {
            int c = findOptimalWeight(dp, values, weight, N - 1, W);
            dp[N][W] = c;
        }

        return dp[N][W];
    }

}
