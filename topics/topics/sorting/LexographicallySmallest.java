package sorting;

public class LexographicallySmallest {

    public static void main(String[] args) {
        LexographicallySmallest ls = new LexographicallySmallest();
        int[] nums = {1,60,34,84,62,56,39,76,49,38};
        int limit = 4;
        ls.lexicographicallySmallestArray(nums, limit);
    }

    public int[] lexicographicallySmallestArray(int[] nums, int limit) {
        int s = 0;
        int end = nums.length - 1;
        divide(nums, s, end, limit);
        return nums;
    }

    public void divide(int[] nums, int start, int end, int limit) {
        if (start < end) {
            int mid = start + (end - start) / 2;
            System.out.println("mid:" + mid);
            divide(nums, start, mid, limit);
            divide(nums, mid + 1, end, limit);
            merge(nums, start, mid, end, limit);
        }
    }

    public void merge(int[] nums, int start, int mid, int end, int limit) {
        int[] result = new int[end - start + 1];
        int ptr1 = start;
        int ptr2 = mid + 1;
        int ptr = 0;

        while (ptr1 <= mid && ptr2 <= end) {
            if (nums[ptr1] <= nums[ptr2]) {
                result[ptr++] = nums[ptr1++];
            } else {
                if ((nums[ptr1] - nums[ptr2]) <= limit) {
                    result[ptr++] = nums[ptr2++];
                } else {
                    result[ptr++] = nums[ptr1++];
                }
            }
        }

        System.out.println("result formed");
        while (ptr1 <= mid) {
            result[ptr++] = nums[ptr1++];
        }
        while (ptr2 <= end) {
            result[ptr++] = nums[ptr2++];
        }

        ptr = 0;
        for (int i = start; i <= end; i++) {
            nums[i] = result[ptr++];
        }
        System.out.println("result returned");

    }
}
