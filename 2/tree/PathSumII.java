package tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class PathSumII {

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        Stack<Integer> stack = new Stack<>();
        List<List<Integer>> list = new ArrayList<>();
        traverse(root, 0, targetSum, stack,list);
        return list;
    }

    private boolean traverse(TreeNode root, int sum, int targetSum, Stack<Integer> stack, List<List<Integer>> list ) {
        if (root == null)
            return false;
        stack.add(root.val);
        sum += root.val;
        if (isLeafNode(root)) {
            if (sum == targetSum){
                ArrayList<Integer> inner = new ArrayList<>();
                stack.iterator().forEachRemaining(i->inner.add(i));
                list.add(inner);
                return true;
            }
        }
        boolean b1 = traverse(root.left, sum, targetSum, stack, list);
        boolean b2 = traverse(root.right, sum, targetSum, stack, list);
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
