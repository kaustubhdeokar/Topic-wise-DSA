package tree;

public class InorderSuccessorInBST {

    public TreeNode inorderSuccessor(TreeNode root, TreeNode target) {
        TreeNode successor = null;

        while (root != null) {
            if (root.val <= target.val) {
                root = root.right;
            } else {
                successor = root;
                root = root.left;
            }
        }
        return successor;
    }



}
