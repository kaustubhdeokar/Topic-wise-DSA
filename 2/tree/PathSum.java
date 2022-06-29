package tree;

import java.util.ArrayList;
import java.util.Stack;

public class PathSum {
    public boolean pathSumEqualToTarget(TreeNode root, int targetSum) {
        Stack<Integer> stack = new Stack<>();
        boolean ans = traverse(root, 0, targetSum, stack);
        ArrayList<Integer> inner = new ArrayList<>();
        stack.iterator().forEachRemaining(inner::add);
        return ans;
    }

    private boolean traverse(TreeNode root, int sum, int targetSum, Stack<Integer> stack) {
        if (root == null)
            return false;
        stack.add(root.val);
        sum += root.val;
        if (isLeafNode(root)) {
            if (sum == targetSum)
                return true;
        }
        boolean b1 = traverse(root.left, sum, targetSum, stack);
        boolean b2 = traverse(root.right, sum, targetSum, stack);
        if (b1 || b2) {
            return true;
        }
        sum -= root.val;
        stack.pop();
        return false;
    }

    public boolean isLeafNode(TreeNode node) {
        return node.left == null && node.right == null;
    }
}
