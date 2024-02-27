package cyclic_sort;
//find disappeared nums from [1,n].

//cyclic sort. 

import java.util.*;

public class DisapperedNums {

    public List<Integer> findDisappearedNumbers(int[] nums) {

        List<Integer> list = new ArrayList<>();
        // cyclicSort(nums);
        // for(int i=0;i<nums.length;i++){
        // if(nums[i]!=i+1)
        // list.add(i+1);
        // }
        return list;
    }

    public void cyclicSort(List<Integer> list) {

        int n = 0;
        int arrLen = list.size();
        while (n < arrLen) {
            // System.out.println(n);
            while ((list.get(n)<arrLen) && list.get(n) != list.get(list.get(n) - 1)) {
                swap(list, n, list.get(n) - 1);
            }
            System.out.println(list);
            n += 1;
        }

    }

    public void swap(List<Integer> list, int a, int b) {
        int temp = list.get(a);
        list.set(a, list.get(b));
        list.set(b, temp);
    }

    public static void main(String[] args) {

        DisapperedNums disapperedNums = new DisapperedNums();
        List<Integer> list = new ArrayList<>();
        list.addAll(List.of(1, 2, 6, 4, 3));
        disapperedNums.cyclicSort(list);

    }
}
