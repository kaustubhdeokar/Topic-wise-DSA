package tree;

import java.util.ArrayList;
import java.util.*;

public class BoundaryTraversal {

    public ArrayList<Integer> boundaryTraversal(TreeNode tree) {

        ArrayList<Integer> list = new ArrayList<>();
        if (tree == null) {
            return list;
        }

        ArrayList<ArrayList<Integer>> listByLevel = new ArrayList<>();
        traverseLevelOrder(tree, listByLevel, 1);
        return list;
    }

    public void traverseLevelOrder(TreeNode tree, ArrayList<ArrayList<Integer>> list, int level) {

        //traverse by level,
        //for each level, a list ->   {firstnode_,_lastnode}
        //if first node is empty fill it.
        //after which always replace the last node in the list.

        ArrayDeque<TreeNode> q = new ArrayDeque<>();
        q.add(tree);

        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                TreeNode curr = q.pop();
                addToList(curr, list, level);
                if (curr.left != null) q.add(curr.left);
                if (curr.right != null) q.add(curr.right);
                System.out.println("level:" + level + " list:" + list);
            }
            level += 1;
        }
    }

    public void addToList(TreeNode curr, ArrayList<ArrayList<Integer>> list, int level) {
        ArrayList<Integer> innerList = new ArrayList<>();
        if (list.size() < level) {
            list.add(innerList);
        }
        if (list.get(level - 1).size() < 2) {
            list.get(level - 1).add(curr.val);
        } else {
            list.get(level - 1).set(1, curr.val);
        }

    }

    public static void main(String[] args) {

        BoundaryTraversal boundaryTraversal = new BoundaryTraversal();
        TreeNode node = boundaryTraversal.formNode();
//        TreeNode node = boundaryTraversal.formNodeByString();
        ArrayList<Integer> list = boundaryTraversal.boundaryTraversal(node);

        for (Integer i : list) {
            System.out.print(i + " ");
        }

    }

    private TreeNode formNodeByString() {
        StringToTree stringToTree = new StringToTree();
        String tree = "7 2 1 -1001 -1001 4 3 -1001 -1001 5 -1001 -1001 9 8 -1001 -1001 10 -1001 -1001";
        return stringToTree.deserialize(tree);
    }

    public TreeNode formNode() {
                    /*
                     7
                  /    \
                 2      9
                / \    / \
                1   4  8   10
                   / \
                   3  5
                */
        TreeNode root = new TreeNode(7);
        root.left = new TreeNode(2);
        root.right = new TreeNode(9);

        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(4);

        root.right.left = new TreeNode(8);
        root.right.right = new TreeNode(10);

        root.left.right.left = new TreeNode(3);
        root.left.right.right = new TreeNode(5);

        return root;

    }

}
