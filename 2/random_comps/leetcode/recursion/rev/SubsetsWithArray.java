package recursion.rev;

import java.util.*;

public class SubsetsWithArray {
    
    public static void main(String[] args){

        int[] nums = {1,2,3};
        
        ArrayList<Integer> curr = new ArrayList<>();

        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        
        createSubsets(nums , curr, 0, list);

        printArrayList(list);
    }

    public static void print(ArrayList<String> list){
        for(String s:list){
            System.out.println(s);
        }
    }

    public static void printArrayList(ArrayList<ArrayList<Integer>> list){
        for(ArrayList<Integer> innerList: list){
            for(Integer i:innerList){
                System.out.print(i+" ");
            }
            System.out.println();
        }
    }

    public static ArrayList<ArrayList<Integer>> createSubsets(int[] nums, ArrayList<Integer> curr, int index, ArrayList<ArrayList<Integer>> list){

        if(index >= nums.length){
            list.add(new ArrayList<>(curr));
            return list;
        }
        
        curr.add(nums[index]);
        createSubsets(nums, curr, index+1, list);
        curr.remove(curr.size()-1);

        createSubsets(nums, curr, index+1, list);
        
        return list;

    }

}
