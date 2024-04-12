

import java.util.ArrayList;

public class BalanceBST {
    public TreeNode balanceBST(TreeNode root) {
        int heightLeft = checkHeight(root.left);
        int heightRight = checkHeight(root.right);

        if (Math.abs(heightLeft - heightRight) < 1)
            return root;

        else {
            ArrayList<Integer> list = new ArrayList<>();
            traverse(root, list);
            TreeNode newRoot = null;
            newRoot = insertIntoTree(list, newRoot, 0, list.size() - 1);
            return newRoot;
        }
    }

    public TreeNode insertIntoTree(ArrayList<Integer> list, TreeNode root, int start, int end) {

        while (start <= end) {
            int mid = start + (end - start) / 2;
            int data = list.get(mid);
            root = insertIntoBST(root, data);
            root = insertIntoTree(list, root, start, mid - 1);
            root = insertIntoTree(list, root, mid + 1, end);
            return root;
        }
        return root;
    }

    public TreeNode insertIntoBST(TreeNode root, int data) {

        if (root == null)
            root = new TreeNode(data);
        else if (root.val > data)
            root.left = insertIntoBST(root.left, data);
        else
            root.right = insertIntoBST(root.right, data);
        return root;
    }

    public void traverse(TreeNode root, ArrayList<Integer> list) {
        if (root == null)
            return;
        traverse(root.left, list);
        list.add(root.val);
        traverse(root.right, list);
    }

    public int checkHeight(TreeNode node) {
        if (node == null)
            return 0;
        return Integer.max(checkHeight(node.left), checkHeight(node.right)) + 1;

    }
}
