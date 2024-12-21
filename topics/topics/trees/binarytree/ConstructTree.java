package trees.binarytree;

import trees.TreeNode;

public class ConstructTree {


    public TreeNode constructTree(int[] arr, int start, int end) {
        if (start > end) return null;
        int mid = start + (end - start) / 2;
        TreeNode node = new TreeNode(arr[mid]);
        node.left = constructTree(arr, start, mid - 1);
        node.right = constructTree(arr, mid + 1, end);
        return node;
    }

    public static void main(String[] args) {

        ConstructTree constructTree = new ConstructTree();
        int[] arr = {1, 2, 3, 4, 5, 6, 7};
        TreeNode treeNode = constructTree.constructTree(arr, 0, arr.length - 1);

        Traversal traversal = new Traversal();
        traversal.levelOrder(treeNode);
    }

}
