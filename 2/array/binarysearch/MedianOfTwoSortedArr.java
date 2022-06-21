public class MedianOfTwoSortedArr {

    public static void main(String[] args) {

        int n = 5;
        int m = 6;
        int[] arr1 = {1, 2, 3, 4, 5};
        int[] arr2 = {3, 4, 5, 6, 7, 8};

        System.out.println(medianOfArrays(n, m, arr1, arr2));
    }

    static double medianOfArrays(int n, int m, int a[], int b[]) {

        int[] resultArr = new int[n + m];
        merge(resultArr, a, b);

        int start = 0;
        int end = resultArr.length - 1;
        int mid = start + (end - start) / 2; //

        if ((resultArr.length & 1) == 0) {

            int midPlusOne = mid + 1;
            return (resultArr[mid] + resultArr[midPlusOne]) * 1.0 / 2.0;
        } else {
            return resultArr[mid];
        }
    }

    private static void merge(int[] resultArr, int[] arr1, int[] arr2) {
        int ptrArr1 = 0;
        int ptrArr2 = 0;
        int ptrResultArr = 0;

        while (ptrArr1 < arr1.length && ptrArr2 < arr2.length) {
            if (arr1[ptrArr1] < arr2[ptrArr2]) {
                resultArr[ptrResultArr++] = arr1[ptrArr1++];
            } else {
                resultArr[ptrResultArr++] = arr2[ptrArr2++];
            }
        }
        while (ptrArr1 < arr1.length) {
            resultArr[ptrResultArr++] = arr1[ptrArr1++];
        }
        while (ptrArr2 < arr2.length) {
            resultArr[ptrResultArr++] = arr2[ptrArr2++];
        }
    }

}
