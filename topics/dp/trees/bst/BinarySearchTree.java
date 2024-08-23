package trees.bst;

import trees.TreeNode;

public class BinarySearchTree {
    public TreeNode insert(TreeNode root, int val) {
        if (root == null) {
            root = new TreeNode(val);
        } else if (root.data >= val) {
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

    public TreeNode createSampleBst() {
        BinarySearchTree bst = new BinarySearchTree();
        TreeNode root = null;
        root = bst.insert(root, 6);
        root = bst.insert(root, 5);
        root = bst.insert(root, 9);
        root = bst.insert(root, 11);
        root = bst.insert(root, 7);
        root = bst.insert(root, 8);
        root = bst.insert(root, 4);
        root = bst.insert(root, 3);
        root = bst.insert(root, 13);
        root = bst.insert(root, 2);
        return root;
    }

}
