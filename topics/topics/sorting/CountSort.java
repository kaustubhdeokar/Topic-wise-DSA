package sorting;

public class CountSort {

    public static void main(String[] args) {

        CountSort countSort = new CountSort();
        int[] input = {74, 62, 52, 48, 33, 23, 11, 10};
        // combining both steps below -> radix sort.
        int[] arr = countSort.countSortByUnitsPlace(input);
        int[] finalOutput = countSort.countSortByTensPlace(arr);

        for(int o: finalOutput){
            System.out.print(o+" ");
        }

    }

    public int[] countSortByTensPlace(int[] arr) {
        int[] cumulativeArr = new int[10]; // 0-9

        for (int i = 0; i < arr.length; i++) {
            cumulativeArr[arr[i] / 10] += 1;
        }

        for (int i = 1; i < 10; i++) {
            cumulativeArr[i] += cumulativeArr[i - 1];
        }
        int[] output = new int[arr.length];

        for (int i = arr.length - 1; i >= 0; i--) {
            int n = arr[i] / 10;
            output[cumulativeArr[n] - 1] = arr[i];
            cumulativeArr[n] -= 1;
        }

        for (int o : output) {
            System.out.print(o + " ");
        }
        System.out.println();
        return output;
    }

    public int[] countSortByUnitsPlace(int[] input) {
        int[] cumulativeArr = new int[10]; // 0-9
        for (int n : input) {
            cumulativeArr[n % 10] += 1;
        }
//        for (int c : cumulativeArr) {
//            System.out.print(c + " ");
//        }
        System.out.println();
        int total = 0;
        for (int i = 0; i < cumulativeArr.length; i++) {
            total += cumulativeArr[i];
            cumulativeArr[i] = total;
        }
//        for (int c : cumulativeArr) {
//            System.out.print(c + " ");
//        }
        int[] output = new int[input.length];
        for (int i = input.length - 1; i >= 0; i--) {
            output[cumulativeArr[input[i] % 10] - 1] = input[i];
            cumulativeArr[input[i] % 10] -= 1;
        }
        System.out.println();
        for (int o : output) {
            System.out.print(o + " ");
        }
        System.out.println();

        return output;
    }

}
