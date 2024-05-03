package trees.src;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import tree.TreeNode;

public class PathSumII {

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<Integer> innerList = new ArrayList<>();
        List<List<Integer>> list = new ArrayList<>();
        traverse(root, 0, targetSum, innerList, list);
        return list;
    }

    private void traverse(TreeNode root, int sum, int targetSum, List<Integer> list, List<List<Integer>> result) {
        if (root == null)
            return;

        list.add(root.val);
        sum += root.val;

        if (isLeafNode(root)) {
            if (sum == targetSum) {
                result.add(new ArrayList(list));
            }
        }
        traverse(root.left, sum, targetSum, list, result);
        traverse(root.right, sum, targetSum, list, result);

        sum -= root.val;
        list.remove(list.size() - 1);
    }

    public boolean isLeafNode(TreeNode node) {
        return node.left == null && node.right == null;
    }

}
