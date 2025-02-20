package dp.knapsack;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CountPartitionDiffEx {

    public static void main(String[] args) {

        int[] arr = {5,2,4,6};
        List<Map<Integer, Integer>> cache = new ArrayList<>();
        for(int i=0;i<arr.length;i++) cache.add(new HashMap<>());
        cache.get(1).put(2, 1);
        System.out.println(cache.get(1).get(2));

        if(cache.get(1).containsKey(2)) {
            System.out.println(cache.get(1).get(2));
        }

    }

}
