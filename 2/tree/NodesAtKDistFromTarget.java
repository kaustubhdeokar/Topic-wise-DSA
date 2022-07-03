package tree;

import java.util.ArrayList;

public class NodesAtKDistFromTarget {


    class MapNodeToDist {
        int dist;
        TreeNode node;

        MapNodeToDist(int dist, TreeNode node) {
            this.dist = dist;
            this.node = node;
        }
    }

    public ArrayList<Integer> getNodesAtDistK(TreeNode treeNode, TreeNode target, int k) {
        ArrayList<MapNodeToDist> pathList = new ArrayList<>();
        ArrayList<Integer> nodes = new ArrayList<>();
        findPathToNode(treeNode, target, k, pathList, nodes);
        return nodes;
    }

    public TreeNode findPathToNode(TreeNode root, TreeNode target, int k, ArrayList<MapNodeToDist> pathList, ArrayList<Integer> nodeList) {
        if (root == null)
            return null;
        if (root == target) {
            pathList.add(new MapNodeToDist(0, root));
            if(k==0)
                nodeList.add(root.val);
            addNodesAtLevel(k - 1, root.left, nodeList);
            addNodesAtLevel(k - 1, root.right, nodeList);
            return root;
        }

        TreeNode left = findPathToNode(root.left, target, k, pathList, nodeList);
        if (left != null) {
            MapNodeToDist top = pathList.get(pathList.size() - 1);
            int currDist = top.dist + 1;
            if(currDist==k)
                nodeList.add(root.val);
            pathList.add(new MapNodeToDist(currDist, root));
            addNodesAtLevel(k - currDist - 1, root.right, nodeList);
            return left;
        }

        TreeNode right = findPathToNode(root.right, target, k, pathList, nodeList);
        if (right != null) {
            MapNodeToDist top = pathList.get(pathList.size() - 1);
            int currDist = top.dist + 1;
            if(currDist==k)
                nodeList.add(root.val);
            pathList.add(new MapNodeToDist(currDist, root));
            addNodesAtLevel(k - currDist - 1, root.left, nodeList);
            return right;
        }
        return null;
    }

    public void addNodesAtLevel(int k, TreeNode root, ArrayList<Integer> list) {
        if (root == null || k < 0)
            return;
        if (k == 0)
            list.add(root.val);
        addNodesAtLevel(k - 1, root.left, list);
        addNodesAtLevel(k - 1, root.right, list);
    }
}
