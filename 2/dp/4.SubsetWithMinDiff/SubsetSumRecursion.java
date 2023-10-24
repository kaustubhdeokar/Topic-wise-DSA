public class SubsetSumRecursion {

    public static void main(String[] args) {

        int[] arr = { 1, 6, 11 , 3 };
        int sum = 0;
        for (int a : arr) {
            sum += a;
        }

        //  21 -> 11 -> subset sums closest or equal to 11.

        int N = arr.length;

        System.out.println(knapsack(arr, N, 11));
    }

    public static int knapsack(int[] arr, int N, int sum){
        
        //base case. 
        if(sum==0){
            return 1;
        }
        if(sum<0 || N==0){
            return 0;
        }

        if(sum >= arr[N-1]){
            return knapsack(arr, N-1, sum - arr[N-1]) + knapsack(arr, N - 1, sum);
        }
        else{
            return knapsack(arr, N-1, sum);
        }

    }

}
