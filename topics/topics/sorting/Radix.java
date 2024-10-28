package sorting;

import java.util.ArrayList;
import java.util.List;

public class Radix {

    public static void main(String[] args) {

        int[] arr = new int[]{170, 45, 75, 90, 802, 24, 2, 66, -9, -19};
        List<Integer> negatives = new ArrayList<>();
        List<Integer> positives = new ArrayList<>();
        for (int n : arr) {
            if (n < 0) {
                negatives.add(Math.abs(n));
            } else {
                positives.add(n);
            }
        }

        Integer[] positiveArr = positives.toArray(new Integer[0]);
        if (positiveArr.length > 0) {
            positiveArr = sort(positiveArr, positiveArr.length);
        }

        Integer[] negativeArr = negatives.toArray(new Integer[0]);
        if (negativeArr.length > 0) {
            negativeArr = sort(negativeArr, negativeArr.length);
        }

        int[] result = new int[arr.length];
        int j=0;
        for (int i = negativeArr.length - 1; i >= 0; i--) {
            result[j++] = -1*negativeArr[i];
        }
        for (int i = 0; i < positiveArr.length; i++) {
            result[i + negativeArr.length] = positiveArr[i];
        }
        for (int i : result) {
            System.out.print(i + " ");
        }
    }

    static int getMax(Integer arr[], int n) {
        int mx = arr[0];
        for (int i = 1; i < n; i++)
            if (arr[i] > mx)
                mx = arr[i];
        return mx;
    }

    static Integer[] sort(Integer[] arr, int n) {

        int max = getMax(arr, n);
        System.out.println(max);

        for (int pow = 1; max / pow > 0; pow *= 10) {
            arr = countSort(arr, pow, n);
        }

        return arr;

    }

    private static Integer[] countSort(Integer[] arr, int power, int arrLen) {

        int[] count = new int[10];
        for (int i = 0; i < arrLen; i++) {
            count[(arr[i] / power) % 10] += 1;
        }

        for (int i = 1; i < 10; i++) {
            count[i] += count[i - 1];
        }

        Integer[] output = new Integer[arrLen];
        for (int i = arrLen - 1; i >= 0; i--) {
            int nthplace = (arr[i] / power) % 10;
            int index = count[nthplace] - 1;
            output[index] = arr[i];
            count[nthplace] -= 1;
        }

        return output;
    }

}
