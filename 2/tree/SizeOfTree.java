package tree;

public class SizeOfTree {
    public int size(TreeNode treeNode) {
        return calculateSize(treeNode);
    }

    private int calculateSize(TreeNode treeNode) {
        if (treeNode == null)
            return 0;
        return 1 + calculateSize(treeNode.left) + calculateSize(treeNode.right);
    }
}
