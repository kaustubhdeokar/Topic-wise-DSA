package dp.oned;

public class MaxProductSubarray {
    public static void main(String[] args) {

        int[] arr = {-4, -3, -2};

        int posMaxSoFar = arr[0];
        int posOverallMax = arr[0];
        int negMaxSoFar = arr[0];
        int negOverallMax = arr[0];

        for (int i = 1; i < arr.length; i++) {

            int tempMax = Integer.max(negMaxSoFar * arr[i], Integer.max(arr[i], arr[i] * posMaxSoFar));
            int tempMin = Integer.min(negMaxSoFar * arr[i], Integer.min(arr[i], arr[i] * posMaxSoFar));

            posMaxSoFar = tempMax;
            negMaxSoFar = tempMin;

            posOverallMax = Integer.max(posOverallMax, posMaxSoFar);
            negOverallMax = Integer.min(negOverallMax, negMaxSoFar);

        }

        System.out.println(posOverallMax);
    }
}
