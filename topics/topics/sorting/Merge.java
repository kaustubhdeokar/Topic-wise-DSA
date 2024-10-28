package sorting;

public class Merge {

    public static void main(String[] args) {

        Merge merge = new Merge();
        int[] arr = {10, 9, 8 , 7, 6, 5, 4, 3, 2, 1};
        merge.sort(arr, 0, arr.length - 1);

        for(int i: arr){
            System.out.print(i+" ");
        }
    }

    public void sort(int[] arr, int start, int end) {
        if (start >= end) return;

        int mid = start + (end - start) / 2;
        sort(arr, start, mid);
        //(0)
        sort(arr, mid + 1, end);
        //(1)
        merge(arr, start, mid, end);
    }

    public void merge(int[] arr, int start, int mid, int end) {
        int[] result = new int[end - start + 1];
        int ptr1 = start;
        int ptr2 = mid + 1;
        int ptr3 = 0;
        while (ptr1 <= mid && ptr2 <= end) {
            if (arr[ptr1] < arr[ptr2]) {
                result[ptr3++] = arr[ptr1++];
            } else {
                result[ptr3++] = arr[ptr2++];
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


}
