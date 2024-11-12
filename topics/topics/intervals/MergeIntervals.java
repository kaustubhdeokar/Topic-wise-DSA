package intervals;

import java.util.ArrayList;
import java.util.List;

public class MergeIntervals {
    public static void main(String[] args) {

        List<int[]> list = new ArrayList<>();
        list.add(new int[]{1,2});
        list.add(new int[]{2,3});

        Integer[][] a = new Integer[list.size()][];
        for (Integer[] anInt : a) {
            System.out.println(anInt[0] + " " + anInt[1]);
        }

        list.toArray(new int[list.size()][]);


    }
}
