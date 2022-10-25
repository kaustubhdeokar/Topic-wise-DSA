package tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class ZigzagOrder {

    class TreeNodeToLevel {
        TreeNode node;
        int level;

        TreeNodeToLevel(TreeNode node, int level) {
            this.node = node;
            this.level = level;
        }
    }

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {

        List<List<Integer>> traversal = new ArrayList<>();
        if (root == null) return traversal;

        int height = findHeight(root);
        for (int i = 0; i < height; i++) {
            traversal.add(new ArrayList<Integer>());
        }

        Stack<TreeNodeToLevel> stackOne = new Stack<>();
        Stack<TreeNodeToLevel> stackTwo = new Stack<>();
        stackOne.push(new TreeNodeToLevel(root, 0));

        while (!stackOne.isEmpty() || !stackTwo.isEmpty()) {
            TreeNodeToLevel top;

            while (!stackOne.isEmpty()) {

                top = stackOne.pop();
                TreeNode topNode = top.node;
                int topLevel = top.level;
                traversal.get(topLevel).add(topNode.val);

                if (topNode.left != null) {
                    stackTwo.push(new TreeNodeToLevel(topNode.left, topLevel + 1));
                }
                if (topNode.right != null) {
                    stackTwo.push(new TreeNodeToLevel(topNode.right, topLevel + 1));
                }
            }

            while (!stackTwo.isEmpty()) {

                top = stackTwo.pop();
                TreeNode topNode = top.node;
                int topLevel = top.level;
                traversal.get(topLevel).add(topNode.val);

                if (topNode.right != null) {
                    stackOne.push(new TreeNodeToLevel(topNode.right, topLevel + 1));
                }
                if (topNode.left != null) {
                    stackOne.push(new TreeNodeToLevel(topNode.left, topLevel + 1));
                }

            }
        }

        return traversal;

    }

    public int findHeight(TreeNode root) {
        if (root == null)
            return 0;
        else
            return 1 + Integer.max(findHeight(root.left), findHeight(root.right));
    }

    public static void main(String[] args) {

        ZigzagOrder order = new ZigzagOrder();
        List<List<Integer>> lists = order.zigzagLevelOrder(new TreeNode().buildCompleteTree());
        for (List<Integer> list : lists) {
            for (int i : list) {
                System.out.print(i + " ");
            }
        }

    }
}
