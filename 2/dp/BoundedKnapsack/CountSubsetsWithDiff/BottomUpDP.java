public class BottomUpDP {
    public static void main(String[] args) {
        
        int[] arr ={1, 1, 2, 3};
        int n =arr.length;
        
        int arrSum = 0;
        for(int a:arr){
            arrSum += a;
        }
        System.out.println("arrSum="+arr.length);

        int[][] dp = new int[arr.length+1][arrSum/2+1];
        for(int j=0;j<=arrSum/2;j++){
            dp[0][j] = 0;
        }
        for(int i=0;i<=n;i++){
            dp[i][0] = 1;
        }

        countSubsetsWithDifference(dp, arr, n, arrSum/2);

        System.out.println("n="+arr.length);

        for(int i=0;i<=arrSum/2;i++){
            System.out.print(dp[n][i]+" ");
        }
    }

    public static void countSubsetsWithDifference(int[][] dp, int[] arr, int n, int sum)
    {

        for(int i=1;i<=n;i++){
            for(int j=1;j<=sum;j++){

                if(j>=arr[i-1]){
                    dp[i][j] = dp[i-1][j-arr[i-1]] + dp[i-1][j];
                }
                else{
                    dp[i][j] = dp[i-1][j];
                }

            }
        }

    }


}
