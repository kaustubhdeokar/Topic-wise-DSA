public class Knapsack {

    public static void main(String[] args) {

        int[] values = { 5, 2, 3 };
        int[] weight = { 1, 5, 1 };

        int N = 3;
        int W = 4;

        System.out.println(findOptimalWeight(values, weight, N, W));

    }
    
    

    public static int findOptimalWeight(int[] values, int[] weight, int N, int W) {

        if (N == 0 || W == 0) {
            return 0;
        }

        if (weight[N - 1] <= W) {

            int a = values[N - 1] + findOptimalWeight(values, weight, N - 1, W - weight[N - 1]);
            int b = findOptimalWeight(values, weight, N - 1, W);
            return Integer.max(a, b);
        } else {
            int c = findOptimalWeight(values, weight, N - 1, W);
            return c;
        }
    }

}
