package dp.mcm;

public class MCMRecursive {

    public int mcm(int[] arr, int i, int j) {

        if(i+1==j){
            return 0;
        }


        int min = Integer.MAX_VALUE;

        for (int k = i+1; k < j; k++) {
            int cost = mcm(arr, i, k) + mcm(arr, k, j) + arr[i] * arr[k] * arr[j];
            if (cost < min) {
                min = Integer.min(min, cost);
            }
        }

        return min;

    }

    public static void main(String[] args) {

        int[] arr = { 3,1,5,8 };

        MCMRecursive mcm = new MCMRecursive();
        System.out.println(mcm.mcm(arr, 0, arr.length-1));

    }
}