

import java.util.ArrayList;
public class LCA {
    public Integer findLCAPathSum(TreeNode treeNode, int one, int two) {

        PathToNode pathToNode = new PathToNode();
        ArrayList<Integer> pathOne = pathToNode.printPathToNode(treeNode, one);
        ArrayList<Integer> pathTwo = pathToNode.printPathToNode(treeNode, two);

        System.out.println(pathOne);
        System.out.println(pathTwo);

        int p1 = 0;
        int p2 = 0;

        while (p1 <= pathOne.size() && p2 <= pathTwo.size()) {
            System.out.println(pathOne.get(p1) + ":" + pathTwo.get(p2));
            if (!pathOne.get(p1).equals(pathTwo.get(p2)))
                break;
            p1 += 1;
            p2 += 1;
        }

        return pathOne.get(Integer.max(0, p1 - 1));
    }

    public Integer findLCA(TreeNode treeNode, int val1, int val2) {

        TreeNode lca = lca(treeNode, val1, val2);
        return lca.val;

    }

    private TreeNode lca(TreeNode treeNode, int val1, int val2) {
        if (treeNode == null)
            return null;
        if (treeNode.val == val1 || treeNode.val == val2)
            return treeNode;

        TreeNode lcaLeft = lca(treeNode.left, val1, val2);
        TreeNode lcaRight = lca(treeNode.right, val1, val2);

        if (lcaLeft != null && lcaRight != null) {
            return treeNode;
        }
        if (lcaLeft != null)
            return lcaLeft;
        else
            return lcaRight;
    }
}
