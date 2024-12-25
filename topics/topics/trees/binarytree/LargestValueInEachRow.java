package trees.binarytree;

import trees.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class LargestValueInEachRow {

    public List<Integer> largestValues(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        preorder(list, root, 0);
        return list;
    }

    public void preorder(List<Integer> list, TreeNode root, int level) {
        if (root == null) return;
        addToList(list, root, level);
        preorder(list, root.left, level + 1);
        preorder(list, root.right, level + 1);
    }

    public void addToList(List<Integer> list, TreeNode root, int level) {
        while (list.size() <= level) {
            list.add(Integer.MIN_VALUE);
        }
        list.set(level, Integer.max(root.val, list.get(level)));
    }

    public static void main(String[] args) {

        Integer[] arr = {3, 4, 1, 5, 6, 2, 9};
        TreeNode root = null;
        Serialize serialize = new Serialize();
        root = serialize.createTree(root, arr);

        LargestValueInEachRow largestValueInEachRow = new LargestValueInEachRow();
        List<Integer> list = largestValueInEachRow.largestValues(root);
        System.out.println(list);
    }

}
