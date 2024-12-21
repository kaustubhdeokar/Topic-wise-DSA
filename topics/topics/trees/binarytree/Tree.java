package trees.binarytree;

import trees.TreeNode;

import java.util.ArrayDeque;

public class Tree {

    public TreeNode pathSumSampleTree() {
        /*
            -2
           /  \
          null -3
        */
        TreeNode root = new TreeNode(-2);
        root.left = null;
        root.right = new TreeNode(-3);
        return root;
    }

    public TreeNode pathSumSampleTree2() {
        TreeNode root = new TreeNode(0);
        root.left = new TreeNode(1);
        root.right = new TreeNode(1);
        return root;
    }

    public TreeNode createTree(Integer[] arr) {
        TreeNode head = null;
        if (arr.length == 0 || (arr.length == 1 && arr[0] == null)) {
            return head;
        }

        head = new TreeNode(arr[0]);
        ArrayDeque<TreeNode> queue = new ArrayDeque<>();
        queue.add(head);

        int counter = 1;

        while (!queue.isEmpty() && counter < arr.length) {
            TreeNode top = queue.remove();
            if (arr[counter] != null) {
                TreeNode left = new TreeNode(arr[counter++]);
                top.left = left;
                queue.add(left);
            } else {
                counter += 1;
            }

            if (arr[counter] != null) {
                TreeNode right = new TreeNode(arr[counter++]);
                top.right = right;
                queue.add(right);
            } else {
                counter += 1;
            }
        }

        return head;
    }

}
