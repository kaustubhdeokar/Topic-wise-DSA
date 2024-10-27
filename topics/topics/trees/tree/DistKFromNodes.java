package trees.tree;

import trees.TreeNode;
import trees.bst.BinarySearchTree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DistKFromNodes {

    public static void main(String[] args) {


        TreeNode tree = new BinarySearchTree().createCompleteBinaryTree();
        DistKFromNodes dist = new DistKFromNodes();
        Map<Integer, List<Integer>> map = new HashMap<>();
        int k = 2;
        int leftLevelOfTarget = dist.preorder(tree.left, tree.left, 1, k, map);
        int rightLevelOfTarget = dist.preorder(tree.right, tree.left, -1, k, map);

        int level = leftLevelOfTarget > 0 ? leftLevelOfTarget : rightLevelOfTarget;
        if (level == -1) {
            level = 0;
        }

        for (Map.Entry<Integer, List<Integer>> entry : map.entrySet()) {
            if (Math.abs(entry.getKey() - level) == k) {
                System.out.println(entry.getValue());
            }
        }
    }

    int preorder(TreeNode root, TreeNode target, int level, int k, Map<Integer, List<Integer>> map) {
        if (root == null) return -1;
        if (map.get(level) == null) map.put(level, new ArrayList<Integer>());
        map.get(level).add(root.val);
        int left = preorder(root.left, target, level > 0 ? level + 1 : level - 1, k, map);
        int right = preorder(root.right, target, level > 0 ? level + 1 : level - 1, k, map);

        if (root == target)
            return level;

        if (left != -1) return left;
        else return right;

    }


}
