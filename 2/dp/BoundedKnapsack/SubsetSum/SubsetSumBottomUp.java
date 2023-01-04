public class SubsetSumBottomUp {

    
    static Boolean isSubsetSumDP(int N, int[] arr, int sum){
        
        boolean[][] dp = new boolean[N+1][sum+1];
        
        //n = 0 false
        for(int j=0;j<=sum;j++){
            dp[0][j] = false;
        }

        //sum = 0 , true
        for(int i=1;i<=N;i++){
            dp[i][0] = true;
        }

        return isSubsetSumDP(dp, N, arr, sum);        
    }

    static boolean isSubsetSumDP(boolean[][] dp, int N, int[] arr, int sum){

        for(int i=1;i<=N;i++){
            for(int j=1;j<=sum;j++){
                if(arr[i-1]<=j){
                    dp[i][j] = dp[i-1][j-arr[i-1]] || dp[i-1][j];
                }
                else{
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        return dp[N][sum];
    }


    public static void main(String[] args) {
        
        int n = 6;
        int[] arr = {3, 34, 4, 12, 5, 2};
        int sum = 9;
        System.out.println("expected true, got:"+isSubsetSumDP(n, arr, sum));
        
        sum = 30;
        System.out.println("expected false, got:"+isSubsetSumDP(n, arr, sum));

    }

}
