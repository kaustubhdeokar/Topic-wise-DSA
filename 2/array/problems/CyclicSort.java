package array;

public class CyclicSort {

    public static void main(String[] args) {

        int[] arr = {3, 5, 2, 1, 4};
        for (int i = 0; i < arr.length; i++) {
            while (arr[i] != i + 1) {
                swap(arr, i, arr[i] - 1);
            }
        }

        for (int i : arr)
            System.out.print(i + " ");

    }

    private static void swap(int[] arr, int i, int i1) {
        int t = arr[i];
        arr[i] = arr[i1];
        arr[i1] = t;
    }
}
