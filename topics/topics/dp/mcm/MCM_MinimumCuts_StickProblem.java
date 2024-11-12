package dp.mcm;

public class MCM_MinimumCuts_StickProblem {

    public int minCost(int n, int cutsLen, int[] cuts) {

        int totalLen = cuts.length + 2;
        int[] arr = new int[totalLen];
        arr[0] = 0;
        arr[totalLen - 1] = n;

        int i = 1;
        int k = i;
        for (int cut : cuts) {
            arr[k++] = cut;
        }

        int j = totalLen;
        return minCuts(arr, 1, cutsLen);

    }

    public int minCuts(int[] arr, int i, int j) {

        if (i >j) return 0;
        int min = Integer.MAX_VALUE;

        for (int k = i; k <= j; k++) {
            System.out.println("K:"+k);
            int tempCuts = minCuts(arr, i, k-1) + minCuts(arr, k + 1, j) + arr[j+1] - arr[i - 1];
            System.out.println(tempCuts);
            if (tempCuts < min) min = tempCuts;
        }

        return min;
    }

    public static void main(String[] args) {

        int[] arr = new int[]{1, 3, 4, 5};
        int n = 7;
        MCM_MinimumCuts_StickProblem mcmStickProblem = new MCM_MinimumCuts_StickProblem();
        int res = mcmStickProblem.minCost(n, arr.length, arr);
        System.out.println("res:" + res);
    }
}
