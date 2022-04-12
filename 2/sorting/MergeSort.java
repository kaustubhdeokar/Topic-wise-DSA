public class MergeSort {

    public static void main(String[] args) {


        int[] arr = {9, 7, 1, 5};
        mergesort(arr);
        for(int i:arr)
            System.out.print(i+" ");
    }

    private static void mergesort(int[] inputArray) {
        int len = inputArray.length;
        if (len < 2)
            return;

        int midIndex = len / 2;
        int[] leftArr = new int[midIndex];
        int[] rightArr = new int[len - midIndex];

        for (int i = 0; i < len / 2; i++)
            leftArr[i] = inputArray[i];
        for (int i = midIndex; i < len; i++)
            rightArr[i - midIndex] = inputArray[i];

        mergesort(leftArr);
        mergesort(rightArr);

        merge(inputArray, leftArr, rightArr);
    }

    private static void merge(int[] inputArray, int[] leftArr, int[] rightArr) {
        int leftArrLen = leftArr.length;
        int rightArrLen = rightArr.length;

        int leftPointer = 0, rightPointer = 0, inputArrPointer = 0;

        while (leftPointer < leftArrLen && rightPointer < rightArrLen) {
            if (leftArr[leftPointer] <= rightArr[rightPointer])
                inputArray[inputArrPointer++] = leftArr[leftPointer++];
            else
                inputArray[inputArrPointer++] = rightArr[rightPointer++];
        }

        while (leftPointer < leftArrLen)
            inputArray[inputArrPointer++] = leftArr[leftPointer++];
        while (rightPointer < rightArrLen)
            inputArray[inputArrPointer++] = rightArr[rightPointer++];


    }
}

