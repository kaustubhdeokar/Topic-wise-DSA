public class SubsetSumRecursion {

    public static void main(String[] args) {

        int[] arr = { 1, 6, 11, 3 };
        int sum = 0;
        for (int a : arr) {
            sum += a;
        }

        int N = arr.length;
        System.out.println(knapsack(arr, N, 0, sum));
    }

    public static int knapsack(int[] arr, int N, int sumCalculated, int sumTotal) {

        // base case.
        if (N == 0) {
            return Math.abs((sumTotal - sumCalculated) - sumCalculated);
        }

        return Integer.min(knapsack(arr, N - 1, sumCalculated + arr[N - 1], sumTotal),
                knapsack(arr, N - 1, sumCalculated, sumTotal));

    }

}
