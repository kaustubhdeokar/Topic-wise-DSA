package tree;

public class DeleteNode {

    public TreeNode deleteNode(TreeNode root, int key) {

        if (root == null)
            return root;

        TreeNode node = findNode(root, key);

        if (node == null) //case 0:not present
        {
            return root;
        }

        if (node.left == null && node.right == null) //case1: leaf node.
        {
            root = deleteLeafNode(root, node.val);
            return root;
        } else if (node.left == null) {
            node.val = node.right.val;
            node.right = node.right.right;
            return root;
        } else {
            deleteNodeWithKey(root, node, key);
            return root;
        }

    }

    public TreeNode findNode(TreeNode root, int key) {
        if (root == null) {
            return null;
        }

        if (root.val == key)
            return root;
        else if (root.val < key)
            return findNode(root.right, key);
        else
            return findNode(root.left, key);
    }

    public TreeNode deleteLeafNode(TreeNode root, int key) {
        if (root == null) {
            return null;
        }
        if (root.val == key) {
            return root;
        } else if (root.val < key) {
            if (root.right != null && root.right.val == key)
                root.right = null;
            return deleteLeafNode(root.right, key);
        } else {
            if (root.left != null && root.left.val == key)
                root.left = null;
            return deleteLeafNode(root.left, key);
        }
    }

    public void deleteNodeWithKey(TreeNode root, TreeNode node, int key) {
        TreeNode inorderSuccessor = findInOrderSuccessor(root, key);
        if (inorderSuccessor == null) {
            TreeNode preorderSuccessor = findPreOrderSuccessor(root, key);
            if (preorderSuccessor.left == null && preorderSuccessor.right == null) {
                deleteLeafNode(root, preorderSuccessor.val);
            } else {
                node.left = preorderSuccessor.left;
            }
            node.val = preorderSuccessor.val;
        } else {
            if (inorderSuccessor.left == null && inorderSuccessor.right == null) {
                deleteLeafNode(root, inorderSuccessor.val);
            } else {
                node.right = inorderSuccessor.right;
            }
            node.val = inorderSuccessor.val;
        }

    }

    private TreeNode findPreOrderSuccessor(TreeNode root, int key) {
        TreeNode successor = null;
        while (root != null) {
            if (root.val >= key) {
                root = root.left;
            } else {
                successor = root;
                root = root.right;
            }
        }
        return successor;
    }

    public TreeNode findInOrderSuccessor(TreeNode root, int key) {
        TreeNode successor = null;
        while (root != null) {
            if (root.val <= key) {
                root = root.right;
            } else {
                successor = root;
                root = root.left;
            }
        }
        return successor;
    }

}
