package cyclic_sort;

//WHENEVER GIVEN RANGE FROM 1-N, use cyclic sort.

public class CyclicSort {

    public static void main(String[] args) {
        int[] nums = {3, 5, 2, 1, 4};
        int n = 0;
        while (n < nums.length) {
            
            //order after sort   1 2 3 4 5
            //indexes after sort 0 1 2 3 4
            //correct index of number 3 -> 2 

            //i=0, arr[i] = 3
            //correct index of i, number 3 -> arr[i] -1 -> 2
            //swap arr[i], arr[arr[i]-1]

            while (!(n == nums[n] - 1)) {
                swap(nums, n, nums[n] - 1);
            }
            n += 1;
        }

        for(int i:nums){
            System.out.print(i+" ");
        }

    }

    public static void swap(int[] nums, int a, int b) {
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }


}
