package recursion;

import java.util.*;

public class CombinationSumLeetcode {

    public static void main(String[] args) {

        List<List<Integer>> numWays = new ArrayList<>();
        int[] candidates = new int[]{48, 22, 49, 24, 26, 47, 33, 40, 37, 39, 31, 46, 36, 43, 45, 34, 28, 20, 29, 25, 41, 32, 23};
        Arrays.sort(candidates);
        Set<List<String>> answer = combinationSum(candidates, "", 69);



        for (List<String> str : answer) {
            List<Integer> innerList = new ArrayList<>();
            for(String s:str){
                innerList.add(candidates[Integer.parseInt(s)]);
            }
            System.out.println(innerList);
            numWays.add(innerList);
        }



    }

    public static Set<List<String>> combinationSum(int[] candidates, String selected, int target) {


        Set<List<String>> numWays = new HashSet<>();

        if (target < 0) {
            return numWays;
        }

        if (target == 0) {
            String[] split = selected.split(",");
            Arrays.sort(split);
            List<String> list = new ArrayList<>();
            for (String s : split) {
                list.add(s);
            }
            numWays.add(list);
            return numWays;
        }

        for (int i = 0; i < candidates.length && candidates[i] <= target; i++) {
            numWays.addAll(combinationSum(candidates, selected + i + ",", target - candidates[i]));
        }
        return numWays;

    }

}

