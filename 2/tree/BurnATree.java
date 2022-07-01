package tree;

import java.util.ArrayList;

public class BurnATree {

    class MapNodeToDist {
        TreeNode node;
        int distance;

        public MapNodeToDist(TreeNode node, int distance) {
            this.node = node;
            this.distance = distance;
        }

        @Override
        public String toString() {
            return "node val=" + node.val + ", distance=" + distance;
        }
    }

    public void burnTree(TreeNode treeNode, int target) {
        ArrayList<MapNodeToDist> list = new ArrayList<>();
        int[] maxTimeToBurn = {-1};
        findPathToTreeNode(treeNode, target, list, maxTimeToBurn);
        System.out.println("max time to burn:" + maxTimeToBurn[0]);
        System.out.println(list);
    }

    public TreeNode findPathToTreeNode(TreeNode treeNode, int target, ArrayList<MapNodeToDist> list, int[] maxTimeToBurn) {

        if (treeNode == null)
            return null;

        if (treeNode.val == target) {
            list.add(new MapNodeToDist(treeNode, 0));
            maxTimeToBurn[0] = Integer.max(calculateMaxHeight(treeNode.left), calculateMaxHeight(treeNode.right));
            return treeNode;
        }

        TreeNode left = findPathToTreeNode(treeNode.left, target, list, maxTimeToBurn);
        if (left != null) {
            MapNodeToDist mapNodeToDist = list.get(list.size() - 1);
            if (treeNode.right != null) {
                int distToRight = calculateMaxHeight(treeNode.right);
                maxTimeToBurn[0] = Integer.max(maxTimeToBurn[0], distToRight + mapNodeToDist.distance + 1);
            }
            list.add(new MapNodeToDist(treeNode, mapNodeToDist.distance + 1));
            return left;
        }

        TreeNode right = findPathToTreeNode(treeNode.right, target, list, maxTimeToBurn);
        if (right != null) {
            MapNodeToDist mapNodeToDist = list.get(list.size() - 1);
            if (treeNode.left != null) {
                int distToLeft = calculateMaxHeight(treeNode.left);
                maxTimeToBurn[0] = Integer.max(maxTimeToBurn[0], distToLeft + mapNodeToDist.distance + 1);
            }
            list.add(new MapNodeToDist(treeNode, mapNodeToDist.distance + 1));
            return right;
        }

        return null;
    }

    public int calculateMaxHeight(TreeNode treeNode) {
        if (treeNode == null)
            return 0;
        return 1 + Integer.max(calculateMaxHeight(treeNode.left), calculateMaxHeight(treeNode.right));
    }

}
