public class SubsetSumBottomUp {
    
    public static void main(String[] args) {

        int[] arr = { 1, 9, 7, 1 };
        int sum = 0;
        for (int a : arr) {
            sum += a;
        }

        System.out.println("sum:"+sum);

        int N = arr.length;
        int halfSum = 0;
        if(sum%2==0){
            halfSum = sum/2;
        }
        else{
            halfSum = sum/2+1;
        }
        
        System.out.println("halfSum:"+halfSum);

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

        knapsack(dp, arr, N, halfSum);

        int minDiff = Integer.MAX_VALUE;

        System.out.println();
        for(int i=0;i<=halfSum;i++){
            
            if(dp[N][i]>0){
                System.out.println(i+":"+dp[N][i]+":"+Math.abs(sum -  2*i));
                minDiff = Integer.min(minDiff, Math.abs(sum -  2*i));
            }
        }

        System.out.println("final answer:"+minDiff);
    }


/*

   public static int knapsack(int[] arr, int N, int sumCalculated, int sumTotal) {

        // base case.
        if (N == 0) {
            return Math.abs((sumTotal - sumCalculated) - sumCalculated);
        }

        return Integer.min(knapsack(arr, N - 1, sumCalculated + arr[N - 1], sumTotal),
                knapsack(arr, N - 1, sumCalculated, sumTotal));

    }
 
*/

    public static void knapsack(int[][] dp, int[] arr, int N, int sum){
        
        System.out.println("sum passed is:"+sum);

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


        for(int j=0;j<=sum;j++){
            System.out.print(j+" ");
        }
        System.out.println();

        for(int i=0;i<=N;i++){
            for(int j=0;j<=sum;j++){
                
                System.out.print(dp[i][j]+" ");

            }
            System.out.println();
        }

        
      

    }

}
