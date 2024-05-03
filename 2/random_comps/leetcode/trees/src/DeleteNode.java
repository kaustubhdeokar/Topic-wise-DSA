package trees.src;

import tree.TreeNode;

public class DeleteNode {

    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null)
            return root;
        else if (root.val > key)
            root.left = deleteNode(root.left, key);
        else if (root.val < key)
            root.right = deleteNode(root.right, key);
        else {
            if (root.left == null)
                return root.right;
            else if (root.right == null)
                return root.left;
            else {
                TreeNode inorderSuccessor = findInorderSuccessor(root.right);
                //replace by inorder successor's value.
                root.val = inorderSuccessor.val;
                root.right = deleteNode(root.right, root.val);
            }
        }
        return root;
    }

    private TreeNode findInorderSuccessor(TreeNode root) {
        if (root.left == null) {
            return root;
        }
        return findInorderSuccessor(root.left);
    }

}
