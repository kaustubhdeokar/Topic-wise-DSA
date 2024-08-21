
public class Recursive {
    
    public static void main(String[] args) {
        
        int[] arr ={1, 2, 3, 1, 2};
        int n =arr.length;
        int diff = 1;
        int currSum = 0;
        
        int arrSum = 0;
        for(int a:arr){
            arrSum += a;
        }

        System.out.println("subsets:"+findSubsetsWithDiff(arr, n, diff, currSum, arrSum));
    }

    public static int findSubsetsWithDiff(int[] arr, int n, int diff, int currSum, int arrSum){

        if(n == 0){
            
            if(arrSum - 2*currSum == diff){
                return 1;
            }
            else{
                return 0;
            }
        }

        else 
            return findSubsetsWithDiff(arr, n-1, diff, currSum + arr[n-1], arrSum) +
                findSubsetsWithDiff(arr, n-1, diff, currSum, arrSum);

    }







}
