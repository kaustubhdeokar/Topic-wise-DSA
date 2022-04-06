import util.ArrayUtility;

public class CountingSort {

    public static void main(String[] args) throws java.lang.Exception {

//      int[] arr = {1, 4, 1, 2, 7, 5, 2};
        int[] arr = {1, -4, 8, 8, 7, 9, -9};
        ArrayUtility arrayUtility = new ArrayUtility();

        int min = arrayUtility.arrMin(arr);
        int max = arrayUtility.arrMax(arr);

        int[] count = new int[max - min + 1];
        for (int i : arr) {
            count[i - min] += 1;
        }

        int sum = count[0];
        for (int i = 1; i < count.length; i++) {
            count[i] = sum + count[i];
            sum = count[i];
        }

        int currCount = 0;
        for (int i = min; i <= max; i++) {
            //
            while (currCount < count[i - min]) {
                //
                arr[currCount] = i;
                //
                currCount += 1;
                //
            }
        }

        for (int i : arr) {
            System.out.print(i + " ");
        }

    }


}
