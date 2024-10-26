package trees.bst;

import trees.TreeNode;

public class BinarySearchTree {
    public TreeNode insert(TreeNode root, int val) {
        if (root == null) {
            root = new TreeNode(val);
        } else if (root.val >= val) {
            root.left = insert(root.left, val);
        } else {
            root.right = insert(root.right, val);
        }
        return root;
    }
        /*
                6
               / \
              5   9
             /   / \
            4   7   11
           /     \    \
          3       8   13
         /
        2

       */

    public TreeNode createSampleTree() {

        TreeNode root = new TreeNode(6);
        root.left = new TreeNode(5);
        root.right = new TreeNode(9);

        root.left.left = new TreeNode(4);
        root.left.left.left = new TreeNode(3);
        root.left.left.left.left = new TreeNode(2);

        root.right.left = new TreeNode(7);
        root.right.right = new TreeNode(11);

        root.right.left.right = new TreeNode(8);
        root.right.right.right = new TreeNode(13);

        return root;
    }

}
