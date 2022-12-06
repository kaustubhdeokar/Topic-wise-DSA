
public class SubsetsWithMinDiff {
    
    public static void main(String[] args) {
      
        int arr[] = {-36,36};
        
        int arrSum = 0;
        for(int a: arr){
            arrSum+=a;
        }

        int min = Integer.MAX_VALUE;
        for(int a: arr){
            min = Integer.min(min, a);
        }

        if (min < 0) {
            for (int i = 0; i < arr.length; i++) {
                arr[i] += Math.abs(min);
            }
        }

        boolean[][] dp = new boolean[arr.length+1][arrSum/2+1];

        for(int j=0;j<=arrSum/2;j++){
            dp[0][j] = false;
        }
        for(int i=0;i<=arr.length;i++){
            dp[i][0] = true;
        }

        knapsack(dp, arr, arr.length, arrSum/2+1);

        int max = 0;
        for(int j=0;j<=arrSum/2;j++){
            if(dp[arr.length][j])
                max= j;
        }

        System.out.println("Expected is 2, actual is :"+(arrSum - 2*max));

    }

    public static void knapsack(boolean[][] dp, int[] nums, int n, int sum){
         
        for(int i=1;i<=n;i++){
            for(int j=1;j<sum;j++){
                if(j>=nums[i-1])
                    dp[i][j] = dp[i-1][j-nums[i-1]] || dp[i-1][j];
                
                else
                    dp[i][j] = dp[i-1][j];
        
            }
        }

    }

//   public static void recursive(){
//     if(n==0){
//         if(currSum!=0 && currSum!=arrSum){
//             System.out.println("currSum:"+currSum +" rem:"+ (arrSum - currSum));
//             minSum[0] = Integer.min(minSum[0], Math.abs(currSum - (arrSum - currSum)));
//         }
//         return;
//     }

//     knapsack(arr, n-1, currSum + arr[n-1], arrSum, minSum);
//     knapsack(arr, n-1, currSum, arrSum, minSum);

//   }

}
