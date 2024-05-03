//find disappeared nums from [1,n].

//cyclic sort. 

import java.util.*;

public class CyclicSortDisapperedNums {

    public List<Integer> findDisappearedNumbers(int[] nums) {
        
        List<Integer> list = new ArrayList<>();
     	cyclicSort(nums);
        for(int i=0;i<nums.length;i++){
            if(nums[i]!=i+1)
               	list.add(i+1);
	    }
        return list;
    }

    public void cyclicSort(int[] nums) {

        int n = 0;
        int arrLen = nums.length;
        while (n < arrLen) {
            // System.out.println(n);
            while ((nums[n]<arrLen) && nums[n] != nums[nums[n]-1]) 
            {
                swap(nums, n, nums[n] - 1);
            }
            print(nums);
            n += 1;
        }
    }
    public void print(int[] nums){
        System.out.println();
        for(int n: nums){
            System.out.print(n+" ");
        }
    }

    public void swap(int[] nums, int a, int b) {
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }

    public static void main(String[] args) {

        CyclicSortDisapperedNums disapperedNums = new CyclicSortDisapperedNums();
        int[] arr = {1, 2, 6, 4, 3};
        List<Integer> list = disapperedNums.findDisappearedNumbers(arr);
	    System.out.println();
       	System.out.println("answer:"+list);
	    
    }
}
