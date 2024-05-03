package trees.src;

import java.util.*;

public class Prac {
    public static void main(String[] args) {
        
        ArrayList<Integer>list = new ArrayList<>();
        list.add(2);
        list.add(3);
        list.add(4);

        list.remove(list.size()-1);
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();

        res.add(new ArrayList(list));
        System.out.println(res);
    }
}
