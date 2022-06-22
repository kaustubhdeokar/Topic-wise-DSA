public class QuickSort2 {

    public static void main(String[] args) {


        int[] arr = {4, 1, 3, 9, 7};
        quickSort(arr, 0, arr.length - 1);

        for (int i : arr) {
            System.out.print(i + " ");
        }
    }

    static void quickSort(int arr[], int low, int high) {

        if (low < high) {

            int partitionElem = partition(arr, low, high);

            quickSort(arr, low, partitionElem - 1);
            quickSort(arr, partitionElem + 1, high);

        }
    }

    static int partition(int arr[], int low, int high) {

        int pivot = arr[high];
        int leftPtr = low;
        int rightPtr = high;

        while (leftPtr < rightPtr) {
            while (arr[leftPtr] <= arr[pivot] && leftPtr < rightPtr)
                leftPtr += 1;
            while (arr[rightPtr] >= arr[pivot] && leftPtr < rightPtr)
                rightPtr -= 1;
            swap(arr, leftPtr, rightPtr);
        }

        swap(arr, leftPtr, high);

        return leftPtr;
    }

    public static void swap(int[] arr, int i, int j) {
        if (arr[i] < arr[j])
            return;
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

}
