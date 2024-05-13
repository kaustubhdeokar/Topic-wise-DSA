package tree;

import java.util.ArrayList;
import java.util.List;

public class PathToNode {

    public static void main(String[] args) {

        PathToNode pathToNode = new PathToNode();
        TreeNode tree = pathToNode.createTree();
        List<Integer> result = new ArrayList<>();
        boolean[] found = {false};
        pathToNode.findPathToNode(tree, tree.left.right.right.left, result, found);
        System.out.println(result);
    }

    private TreeNode findPathToNode(TreeNode tree, TreeNode target, List<Integer> result, boolean[] found) {
        if (tree == null || found[0]) return null;
        System.out.println("adding:" + tree.val);
        result.add(tree.val);
        if (tree == target) {
            found[0] = true;
            return target;
        }
        TreeNode left = findPathToNode(tree.left, target, result, found);
        TreeNode right = findPathToNode(tree.right, target, result, found);

        if (!found[0]) {
            System.out.println("removing:" + result.get(result.size() - 1));
            result.remove(result.size() - 1);
        }
        if (left != null) return left;
        return right;
    }


    public TreeNode createTree() {
        TreeNode node = new TreeNode(1);
        node.left = new TreeNode(2);
        node.right = new TreeNode(3);

        node.left.left = new TreeNode(4);
        node.left.right = new TreeNode(5);

        node.left.right.left = new TreeNode(6);
        node.left.right.right = new TreeNode(7);

        node.left.right.left.left = new TreeNode(9);

        node.left.right.right.left = new TreeNode(8);
        node.left.right.right.right = new TreeNode(10);

        node.left.right.left.left.left = new TreeNode(11);
        node.left.right.left.left.right = new TreeNode(12);

        return node;
    }
}
