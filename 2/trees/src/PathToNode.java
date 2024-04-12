import java.util.ArrayList;

public class PathToNode {
    public ArrayList<Integer> printPathToNode(TreeNode treeNode, int target) {

        ArrayList<Integer> list = new ArrayList<>();
        findPathToNode(treeNode, list, target);
        return list;
    }

    private boolean findPathToNode(TreeNode treeNode, ArrayList<Integer> list, int target) {
        if (treeNode == null)
            return false;

        list.add(treeNode.val);
        if (treeNode.val == target)
            return true;

        boolean foundLeft = findPathToNode(treeNode.left, list, target);
        if (foundLeft)
            return true;

        boolean foundRight = findPathToNode(treeNode.right, list, target);
        if (foundRight)
            return true;

        list.remove(list.size() - 1);
        return false;
    }
}
