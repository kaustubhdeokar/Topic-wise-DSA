package trees.binarytree;

import trees.TreeNode;

import java.util.HashMap;
import java.util.Map;

public class CousinsInTree {

    public static void main(String[] args) {
        CousinsInTree cousinsInTree = new CousinsInTree();
        TreeNode treeNode = cousinsInTree.createTree();

        Map<Integer, Integer> mapLevelToSum = new HashMap<>();
        cousinsInTree.calculateLevelOrderSum(treeNode, 0, mapLevelToSum);
        System.out.println(mapLevelToSum);

        cousinsInTree.replaceValueInTree(treeNode, null, mapLevelToSum, 0);
        treeNode.val = 0;
        Traversal traversal = new Traversal();
        System.out.println("--------");
        traversal.levelOrder(treeNode);
    }

    public void calculateLevelOrderSum(TreeNode node, int level, Map<Integer, Integer> map) {
        if (node != null) {
            map.merge(level, node.val, Integer::sum);
            calculateLevelOrderSum(node.left, level + 1, map);
            calculateLevelOrderSum(node.right, level + 1, map);
        }
    }


    public TreeNode replaceValueInTree(TreeNode root, TreeNode parent, Map<Integer, Integer> map, int level) {

        if (root == null) return null;
        replaceValueInTree(root.left, root, map, level + 1);
        replaceValueInTree(root.right, root, map, level + 1);

        if (parent != null) {
            int siblingSum = (root.left == null ? 0 : root.left.val) + (root.right == null ? 0 : root.right.val);

            if (root.left != null) {
                root.left.val = map.get(level + 1) - siblingSum;
            }
            if (root.right != null) {
                root.right.val = map.get(level + 1) - siblingSum;
            }
        } else {
            if (root.left != null) {
                root.left.val = 0;
            }
            if (root.right != null) {
                root.right.val = 0;
            }
        }

        return root;
    }

    public TreeNode createTree() {
        TreeNode treeNode = new TreeNode(5);

        treeNode.left = new TreeNode(4);
        treeNode.right = new TreeNode(9);

        treeNode.left.left = new TreeNode(1);
        treeNode.left.right = new TreeNode(10);

//        treeNode.right.left = new TreeNode(5);
        treeNode.right.right = new TreeNode(7);

        return treeNode;
    }

}
