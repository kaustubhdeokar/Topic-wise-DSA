package sorting;

public class Merge {

    private int swapCount;

    public static void main(String[] args) {
        Merge merge = new Merge();
        int[] arr = {7, 6, 5, 4};
        merge.sort(arr, 0, arr.length - 1);

        for (int i : arr) {
            System.out.print(i + " ");
        }
        System.out.println("\nTotal swaps: " + merge.getSwapCount());
    }

    public void sort(int[] arr, int start, int end) {
        if (start >= end) return;

        int mid = start + (end - start) / 2;
        sort(arr, start, mid);
        sort(arr, mid + 1, end);
        merge(arr, start, mid, end);
    }

    public void merge(int[] arr, int start, int mid, int end) {
        int[] result = new int[end - start + 1];
        int ptr1 = start;
        int ptr2 = mid + 1;
        int ptr3 = 0;
        while (ptr1 <= mid && ptr2 <= end) {
            if (arr[ptr1] <= arr[ptr2]) {
                result[ptr3++] = arr[ptr1++];
            } else {
                result[ptr3++] = arr[ptr2++];
                swapCount += (mid - ptr1 + 1); // Count swaps
            }
        }
        while (ptr1 <= mid) {
            result[ptr3++] = arr[ptr1++];
        }
        while (ptr2 <= end) {
            result[ptr3++] = arr[ptr2++];
        }
        ptr3 = 0;
        for (int i = start; i <= end; i++) {
            arr[i] = result[ptr3++];
        }
    }

    public int getSwapCount() {
        return swapCount;
    }
}