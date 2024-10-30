package binarysearch;

public class FirstAndLastOcc {

    public static void main(String[] args) {

        int[] arr = new int[]
                {2, 2, 2, 2, 2, 4, 6, 6, 7, 7, 7, 7, 7, 9, 9 ,12};
        for (int j : arr) {
            System.out.print(j + " ");
        }
        System.out.println();
        for (int i = 0; i < arr.length; i++) {
            System.out.print(i + " ");
        }
        System.out.println();
        FirstAndLastOcc fl = new FirstAndLastOcc();
        System.out.println("floor returns:" + fl.floor(arr, 9));
        System.out.println("ceil returns:" + fl.ceil(arr, 9));
    }

    public int floor(int[] arr, int key) {

        int low = 0;
        int high = arr.length - 1;
        int mid = 0;
        int idx = -1;
        while (low <= high) {
            mid = low + (high - low) / 2;
            if (arr[mid] == key) {
                idx = mid;
            }
            if (arr[mid] >= key) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return idx;
    }

    public int ceil(int[] arr, int key) {


        int low = 0;
        int high = arr.length - 1;
        int mid = 0;
        int idx = -1;
        while (low <= high) {
            mid = low + (high - low) / 2;
            if (arr[mid] == key) {
                idx = mid;
            }
            if (arr[mid] > key) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return idx;
    }

}
