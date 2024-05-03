package sorting.mergesort;

import java.util.Arrays;

public class Divide {


    public void divideArray(int[] arr, int start, int end) {

        if (start < end) {
            int mid = (start + end) / 2;
            divideArray(arr, start, mid);
            divideArray(arr, mid + 1, end);
            int[] arr1 = Arrays.copyOfRange(arr, start, mid + 1);
            int[] arr2 = Arrays.copyOfRange(arr, mid + 1, end + 1);
            Merge merge = new Merge();
            merge.merge(arr1, arr2, arr, start);
        }
    }

    public static void main(String[] args) {

        Divide divide = new Divide();
        int[] arr = {4, 1, 2, 3};
        divide.divideArray(arr, 0, 3);
        for (int j : arr) {
            System.out.print(j+" ");
        }
    }


}
