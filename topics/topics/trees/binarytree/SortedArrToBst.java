package trees.binarytree;

import trees.TreeNode;

public class SortedArrToBst {

    public static void main(String[] args) {

        int[] arr = new int[]{0, 1, 2, 3, 4, 5, 6};
        SortedArrToBst sortedArrToBst = new SortedArrToBst();
        TreeNode bst = sortedArrToBst.createBst(arr, new TreeNode(0), 0, arr.length - 1);
        new Traversal().levelOrder(bst);
    }

    private TreeNode createBst(int[] arr, TreeNode root, int start, int end) {
        if (start > end) return null;
        int mid = start + (end - start) / 2;
        root = new TreeNode(arr[mid]);
        root.left = createBst(arr, root, start, mid - 1);
        root.right = createBst(arr, root, mid + 1, end);
        return root;
    }


}
