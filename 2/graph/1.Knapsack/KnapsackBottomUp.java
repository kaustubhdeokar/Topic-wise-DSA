public class KnapsackBottomUp {

    public static void main(String[] args) {

        int[] values = { 5, 2, 3 };
        int[] weight = { 1, 5, 1 };

        int N = 3;
        int W = 4;

        int[][] dp = new int[N + 1][W + 1];

        System.out.println(findOptimalWeight(dp, values, weight, N, W));

    }

    /*
       recursion code -> replace N -> i, W -> j. for dp.bottom up approach. 
       
        if (weight[N - 1] <= W) {
          int a = values[N - 1] + findOptimalWeight(values, weight, N - 1, W - weight[N- 1]);
          int b = findOptimalWeight(values, weight, N - 1, W);
          return Integer.max(a, b);
        } 
        
        else 
          return findOptimalWeight(values, weight, N - 1, W);
    */


    public static int findOptimalWeight(int[][] dp, int[] values, int[] weight, int N, int W) {

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= W; j++) {
                if (weight[i - 1] <= j) {
                    dp[i][j] = Integer.max(dp[i - 1][j - weight[i - 1]], dp[i - 1][j]);
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }

        return dp[N][W];
    }

    

}
