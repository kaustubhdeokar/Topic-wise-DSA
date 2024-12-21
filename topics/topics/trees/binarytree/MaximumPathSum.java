package trees.binarytree;

import trees.TreeNode;
import trees.bst.BinarySearchTree;

public class MaximumPathSum {

    public static void main(String[] args) {

        TreeNode sampleTree = new BinarySearchTree().createCompleteBinaryTree();
        MaximumPathSum mps = new MaximumPathSum();
        int maxPathSum = mps.maxPathSum(sampleTree);
        System.out.println(maxPathSum);

    }

    public int maxPathSum(TreeNode root) {
        int[] maxSum = new int[]{-1001};
        maxPathSum(root, maxSum);
        return maxSum[0];
    }


    public int maxPathSum(TreeNode root, int[] maxSum) {
        //base cond.
        if (root == null) return 0;

        int leftSum = maxPathSum(root.left, maxSum);
        int rightSum = maxPathSum(root.right, maxSum);

        int maxSumTillHere = root.val;
        maxSumTillHere = Integer.max(maxSumTillHere, root.val+leftSum);
        maxSumTillHere = Integer.max(maxSumTillHere, root.val+rightSum);
        maxSumTillHere = Integer.max(maxSumTillHere, root.val+rightSum+leftSum);

        maxSum[0] = Integer.max(maxSum[0], maxSumTillHere);

        return Integer.max(root.val, Integer.max(root.val + leftSum, root.val + rightSum));
    }

}
