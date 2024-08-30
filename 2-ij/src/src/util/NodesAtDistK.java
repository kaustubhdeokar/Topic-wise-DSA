package tree;

import java.util.ArrayList;
import java.util.List;

public class NodesAtDistK {

    public static void main(String[] args) {

        NodesAtDistK nodesAtDistK = new NodesAtDistK();
        TreeNode tree = nodesAtDistK.createTree();
        List<Integer> list = new ArrayList<>();

        nodesAtDistK.findNodesAtDistK(tree, tree.left.right.left, 4, list);


        System.out.println("list:" + list);
    }


    private int findNodesAtDistK(TreeNode tree, TreeNode target, int k, List<Integer> list) {

        if (tree == null) return -1;

        if (tree == target) {
            findChildrenAtDistK(target, k, list);
            return 0; // start counting from target node.
        }

        int leftDistance = findNodesAtDistK(tree.left, target, k, list);
        // that means the target node is found, and we are calculating the distance of the ancestors.
        System.out.println("curr:" + tree.val + "left:" + leftDistance);
        if (leftDistance >= 0) {
            leftDistance += 1;
            if (leftDistance < k) {
                findChildrenAtDistK(tree.right, k - leftDistance - 1, list); // to find nodes at distance k, for ancestors different siblings.
            }
        }

        int rightDistance = findNodesAtDistK(tree.right, target, k, list);
        System.out.println("curr:" + tree.val + "right:" + rightDistance);
        if (rightDistance >= 0) {
            rightDistance += 1;
            if (rightDistance < k) {
                findChildrenAtDistK(tree.left, k - leftDistance - 1, list);
            }
        }

        int distance = Integer.max(leftDistance, rightDistance);
        if (distance == k) {
            list.add(tree.val);
        }
        return distance;

    }

    private void findChildrenAtDistK(TreeNode target, int k, List<Integer> list) {
        if (target == null) {
            return;
        }
        if (k == 0) {
            list.add(target.val);
            return;
        }
        findChildrenAtDistK(target.left, k - 1, list);
        findChildrenAtDistK(target.right, k - 1, list);
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
