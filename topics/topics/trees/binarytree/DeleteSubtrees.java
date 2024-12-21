package trees.binarytree;

import trees.TreeNode;

public class DeleteSubtrees {
    public static void main(String[] args) {
        DeleteSubtrees delete = new DeleteSubtrees();
        TreeNode root = delete.createTree();
        int[] queries = {3, 2, 4, 8};
        int[] ints = delete.treeQueries(root, queries);
    }

    // Array to store the maximum height of the tree after removing each node
    static final int[] maxHeightAfterRemoval = new int[100001];

    int currentMaxHeight = 0;

    public int[] treeQueries(TreeNode root, int[] queries) {
        traverseLeftToRight(root, 0);
        currentMaxHeight = 0; // Reset for the second traversal
        traverseRightToLeft(root, 0);

        // Process queries and build the result array
        int queryCount = queries.length;
        int[] queryResults = new int[queryCount];
        for (int i = 0; i < queryCount; i++) {
            queryResults[i] = maxHeightAfterRemoval[queries[i]];
        }

        return queryResults;
    }

    private void traverseLeftToRight(TreeNode node, int currentHeight) {
        if (node == null) return;
        maxHeightAfterRemoval[node.val] = currentMaxHeight;
        currentMaxHeight = Math.max(currentMaxHeight, currentHeight);
        traverseLeftToRight(node.left, currentHeight + 1);
        traverseLeftToRight(node.right, currentHeight + 1);
    }

    private void traverseRightToLeft(TreeNode node, int currentHeight) {
        if (node == null) return;
        maxHeightAfterRemoval[node.val] = Math.max(maxHeightAfterRemoval[node.val], currentMaxHeight);
        currentMaxHeight = Math.max(currentHeight, currentMaxHeight);
        traverseRightToLeft(node.right, currentHeight + 1);
        traverseRightToLeft(node.left, currentHeight + 1);
    }

    private TreeNode createTree() {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(8);
        root.right = new TreeNode(9);

        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(1);

        root.left.left.left = new TreeNode(4);
        root.left.left.right = new TreeNode(6);

        root.right.left = new TreeNode(3);
        root.right.right = new TreeNode(7);

        return root;
    }


}
