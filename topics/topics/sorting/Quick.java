package sorting;

public class Quick {

    public static void main(String[] args) {
        Quick q = new Quick();
        int[] nums = {1, 3, 2, 3, 1};
        q.quickSortUtil(nums, 0, nums.length - 1);
        System.out.println("--------------");
        for (int n : nums) {
            System.out.print(n + " ");
        }

    }

    public void quickSortUtil(int[] arr, int start, int end) {
        if (start < end) {
            int partition = partition(arr, start, end);
            quickSortUtil(arr, start, partition - 1);
            quickSortUtil(arr, partition + 1, end);
        }
    }

    int partition(int[] arr, int start, int end) {
        int pivot = arr[end];
        int s = start;
        int e = end;
        while (s < e) {
            while (s < e && arr[s] <= pivot) s += 1;
            while (s < e && arr[e] >= pivot) e -= 1;

            System.out.println("s: " + arr[s]);
            System.out.println("e: " + arr[e]);
            swap(arr, s, e);
            System.out.println("h");
        }
        swap(arr, s, end);
        System.out.println("h");
        return s;
    }


    void swap(int[] arr, int start, int end) {
        int temp = arr[start];
        arr[start] = arr[end];
        arr[end] = temp;
    }

}
