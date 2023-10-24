public class SubsetSumBottomUp {
    
    public static void main(String[] args) {

        int[] arr = { 1, 6, 11 , 3 };
        int sum = 0;
        for (int a : arr) {
            sum += a;
        }

        //  21 -> 11 -> subset sums closest or equal to 11.

        int N = arr.length;
        int halfSum = 0;
        if(sum%2==0){
            halfSum = sum/2;
        }
        else{
            halfSum = sum/2+1;
        }
        
        int[][] dp = new int[N+1][halfSum+1];

        for(int i=0;i<=halfSum;i++){
            dp[0][i] = 0; // elements 0 -> no subset found.
        }
        for(int j=0;j<=N;j++){
            dp[j][0] = 1; // sum = 0 -> subset found.
        }

        /*      Sum
            N    0  1 2 3 4 5 6
              0  1  0 0 0 0 0 0
              1  1
              2  1
              3  1
              4  1  
         */

        knapsack(dp, arr, N, 11);

        int minDiff = Integer.MAX_VALUE;

        for(int i=0;i<=halfSum;i++){
            
            if(dp[N][i]==1){
                System.out.println(i+":"+dp[N][i]+":"+Math.abs(sum -  2*i));
                minDiff = Integer.min(minDiff, Math.abs(sum -  2*i));
            }
        }

        System.out.println("final answer:"+minDiff);
    }

    public static void knapsack(int[][] dp, int[] arr, int N, int sum){
        
        for(int i=1;i<=N;i++){
            for(int j=1;j<=sum;j++){
                
                if(j>=arr[i-1]){
                    dp[i][j] = dp[i-1][j - arr[i-1]] + dp[i-1][j];
                }
                else{
                    dp[i][j] = dp[i-1][j];
                }

            }
        }

      

    }

}
