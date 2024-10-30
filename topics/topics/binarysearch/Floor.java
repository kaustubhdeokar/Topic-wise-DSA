package binarysearch;

public class Floor {

    public static void main(String[] args) {
        Floor floor = new Floor();
        int[] arr = new int[]
                {3, 5, 7, 9, 11, 12, 13, 14, 15, 16, 17, 18, 19};
//        for (int i = 2; i <= 10; i += 2) {
        System.out.println(floor.find(arr, 4));
//        }

    }

    private int find(int[] arr, int key) {
        int low = 0;
        int high = arr.length - 1;
        int mid = 0;
        int idx = 0;
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
}
