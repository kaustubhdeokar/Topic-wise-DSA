package tree;

import java.util.ArrayDeque;

public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode() {
    }

    @Override
    public String toString() {
        return "val:" + val;
    }

    public TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    public void traverse(TreeNode root) {
        if (root == null)
            return;
        traverse(root.left);
        System.out.println(root.val);
        traverse(root.right);
    }

    public void levelOrder(TreeNode root) {

        ArrayDeque<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode curr = queue.pop();
                System.out.print(curr.val + " ");
                if (curr.left != null)
                    queue.add(curr.left);
                if (curr.right != null)
                    queue.add(curr.right);
            }
            System.out.println();
        }
    }

    public void printArr(int[] array) {
        if (array[0] < 0) return;
        System.out.println(array[0]);
        printArr(array);
    }

}
