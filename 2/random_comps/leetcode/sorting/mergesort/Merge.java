package sorting.mergesort;

public class Merge {

    public void merge(int[] arr1, int[] arr2, int[] finalArr, int start) {
        int ptr1 = 0;
        int ptr2 = 0;
        int arrPtr = start;

        while (ptr1 < arr1.length && ptr2 < arr2.length) {

            if (arr1[ptr1] < arr2[ptr2]) {
                finalArr[arrPtr] = arr1[ptr1];
                ptr1 += 1;
            } else {
                finalArr[arrPtr] = arr2[ptr2];
                ptr2 += 1;
            }
            arrPtr += 1;
        }

        while (ptr1 < arr1.length) {
            finalArr[arrPtr] = arr1[ptr1];
            arrPtr += 1;
            ptr1 += 1;
        }
        while (ptr2 < arr2.length) {
            finalArr[arrPtr] = arr2[ptr2];
            arrPtr += 1;
            ptr2 += 1;
        }
    }

}
