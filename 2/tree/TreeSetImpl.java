package tree;

import java.util.TreeSet;

//this implements a red black tree.
public class TreeSetImpl {
    public static void main(String[] args) {

        TreeSet<Integer> set = new TreeSet<>();
        set.add(1);
        set.add(3);
        set.add(5);
        set.add(7);

        findLower(set, 5);
        findHigher(set, 5);
        findFloor(set,4);
        findCeil(set,4);

        System.out.println(set.pollFirst());
        System.out.println(set.pollFirst());
        System.out.println(set.pollFirst());
        System.out.println(set.pollFirst());
        System.out.println(set.pollFirst());


    }

    private static void findCeil(TreeSet<Integer> set, int i) {
        System.out.println(set.ceiling(i));
    }

    private static void findFloor(TreeSet<Integer> set, int i) {
        System.out.println(set.floor(i));
    }

    private static void findHigher(TreeSet<Integer> set, int i) {
        System.out.println(set.higher(i));
    }

    private static void findLower(TreeSet<Integer> set, int i) {
        System.out.println(set.lower(i));
    }

}
