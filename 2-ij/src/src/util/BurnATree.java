package tree;

import java.util.PriorityQueue;

public class BurnATree {

    class MapDistToNode {
        int distance;
        int node;

        public MapDistToNode(int distance, int node) {
            this.distance = distance;
            this.node = node;
        }

        @Override
        public String toString() {
            return "distance=" + distance +
                    ", node=" + node;
        }
    }

    public static void main(String[] args) {

        BurnATree nodesAtDistK = new BurnATree();
        TreeNode tree = nodesAtDistK.createTree();
        PriorityQueue<MapDistToNode> queue = new PriorityQueue<>((c1, c2) -> Integer.compare(c1.distance, c2.distance));
        nodesAtDistK.pathToTheNode(tree, tree.left.right.left, queue);
        while (!queue.isEmpty()) {
            System.out.println(queue.remove());
        }
    }


    private int pathToTheNode(TreeNode tree, TreeNode target, PriorityQueue<MapDistToNode> queue) {

        if (tree == null) return -1;

        if (tree == target) {
            System.out.println("Found:node");
            findMaxNodeFromNode(target, 0, queue);
            return 1; // start counting from target node.
        }

        int leftDistance = pathToTheNode(tree.left, target, queue);
        // that means the target node is found, and we are calculating the distance of the ancestors.
        System.out.println("curr:" + tree.val + "left:" + leftDistance);
        if (leftDistance >= 0) {
            leftDistance += 1;
            findMaxNodeFromNode(tree.right, leftDistance, queue); // to find nodes at distance k, for ancestors different siblings.
        }
        int rightDistance = -1;
        if (leftDistance < 0) {
            rightDistance = pathToTheNode(tree.right, target, queue);
            System.out.println("curr:" + tree.val + "right:" + rightDistance);
            if (rightDistance >= 0) {
                rightDistance += 1;
                findMaxNodeFromNode(tree.left, rightDistance, queue);
            }
        }

        return Integer.max(leftDistance, rightDistance);

    }

    private void findMaxNodeFromNode(TreeNode target, int dist, PriorityQueue<MapDistToNode> queue) {
        if (target == null) {
            return;
        }
        queue.add(new MapDistToNode(dist, target.val));
        if (queue.size() > 1) {
            MapDistToNode remove = queue.remove();
            System.out.println("removed:" + remove.node);
        }
        findMaxNodeFromNode(target.left, dist + 1, queue);
        findMaxNodeFromNode(target.right, dist + 1, queue);
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
