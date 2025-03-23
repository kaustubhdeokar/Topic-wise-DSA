package binarysearch;

public class AllocateMinPages {

    public int findPages(int[] arr, int students) {
        if(students > arr.length) return -1;
        int max = -1;
        int sum = 0;
        for (int num : arr) {
            max = Integer.max(max, num);
            sum += num;
        }

        int low = max;
        int high = sum;
        int resultMin = Integer.MAX_VALUE;

        while (low <= high) {
            System.out.println("low:" + low + " high:" + high);
            int mid = low + (high - low) / 2;
            int ptr = 0;
            int allotted = 0;
            int maxAllocation = 0;

            while (ptr < arr.length) {
                int curr = 0;
                while (ptr < arr.length && (curr + arr[ptr] <= mid)) {
                    curr += arr[ptr++];
                }
                maxAllocation = Integer.max(maxAllocation, curr);
                if (curr > 0) allotted += 1;
            }

            System.out.println("max alloc:" + maxAllocation + " allotted:" + allotted);

            if (allotted < students) {
                high = mid - 1;
            } else {
                low = mid + 1;

            }

        }
        System.out.println(low);
        return low;
    }

    public static void main(String[] args) {
        int[] arr = {15, 10, 19, 10, 5, 18, 7};
        int students = 5;
        AllocateMinPages allocateMinPages = new AllocateMinPages();
        allocateMinPages.findPages(arr, students);
    }

}
