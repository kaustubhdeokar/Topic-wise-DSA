package tree;

public class Traversal {

    public void inorderRecursive(TreeNode node) {
        if (node == null) return;

        inorderRecursive(node.left);
        System.out.println(node.val + " ");
        inorderRecursive(node.right);
    }

}
