public class KnapsackRecursive{

    public static void main(String[] args) {
      
        int N = 3;
        int W = 4;
        int val[] = {1,2,3};
        int wt[] = {4,5,1};

        System.out.println("Expected is 3, actual is :"+ knapsack(W, wt, val, N));

    }

    public static int knapsack(int W, int[] wt, int[] val, int N){
                 
        if(N==0 || W==0){
            return 0;
        }

        if(wt[N-1]<=W){
            return Integer.max(val[N-1]+knapsack(W-wt[N-1], wt, val, N-1),
                                knapsack(W, wt, val, N-1));
        }
        else 
            return knapsack(W, wt, val, N-1);

    }


}