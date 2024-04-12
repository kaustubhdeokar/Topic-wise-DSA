

import java.util.Arrays;

import tree.TreeNode;

public class LeftView {

    class NodeHeight {
        TreeNode treeNode;
        int height;

        NodeHeight(TreeNode treeNode, int height) {
            this.treeNode = treeNode;
            this.height = height;
        }
    }

    public int[] leftView(TreeNode treeNode) {
        if (treeNode == null)
            return null;
        int height = findHeight(treeNode);
        int[] leftViewArr = new int[height+1];
        Arrays.fill(leftViewArr, -1);
        populateLeftView(treeNode, leftViewArr, 0);
        return leftViewArr;
    }

    private void populateLeftView(TreeNode treeNode, int[] list, int currHeight) {
        if (treeNode == null)
            return;
        if (list[currHeight] == -1)
            list[currHeight] = treeNode.val;
        populateLeftView(treeNode.left, list, currHeight + 1);
        populateLeftView(treeNode.right, list, currHeight + 1);
    }

    private int findHeight(TreeNode treeNode) {
        if (treeNode == null)
            return -1;
        else
            return 1 + Integer.max(findHeight(treeNode.left), findHeight(treeNode.right));
    }
}
