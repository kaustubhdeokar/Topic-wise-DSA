package tree;

import java.util.ArrayList;
import java.util.List;

public class IncreasingBST {

    public TreeNode increasingBST(TreeNode root) {

        if (root == null) return null;

        List<Integer> nodes = collectNodes(root);

        TreeNode result = new TreeNode(-1);
        TreeNode resultPtr = result;
        for (int i : nodes) {

            resultPtr.right = new TreeNode(i);
            resultPtr = resultPtr.right;
        }
        return result.right;

    }

    public List<Integer> collectNodes(TreeNode root) {

        List<Integer> resultList = new ArrayList<>();

        if (root == null) return resultList;

        resultList.addAll(collectNodes(root.left));
        resultList.add(root.val);
        resultList.addAll(collectNodes(root.right));

        return resultList;
    }

    public static void main(String[] args) {

        IncreasingBST increasingBST = new IncreasingBST();
        TreeNode treeNode = new TreeNode();
        TreeNode head = treeNode.buildCompleteTree();
        TreeNode resultNode = increasingBST.increasingBST(head);

        while (resultNode.right != null) {
            System.out.println(resultNode.val);
            resultNode = resultNode.right;
        }

    }

}
