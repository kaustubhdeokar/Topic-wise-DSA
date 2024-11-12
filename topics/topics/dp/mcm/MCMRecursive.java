package dp.mcm;

public class MCMRecursive {

    public int mcm(int[] arr, int i, int j) {

        if (i >= j) {
            return 0;
        }

        int min = Integer.MAX_VALUE;

        for (int k = i; k < j; k++) {
            int cost = mcm(arr, i, k) + mcm(arr, k + 1, j) + arr[i - 1] * arr[k] * arr[j];
            if (cost < min) {
                min = Integer.min(min, cost);
            }
        }

        return min;

    }

    public static void main(String[] args) {

        int[] arr = { 3, 2, 4, 2, 5 };

        MCMRecursive mcm = new MCMRecursive();
        System.out.println(mcm.mcm(arr, 1, arr.length-1));

    }
}