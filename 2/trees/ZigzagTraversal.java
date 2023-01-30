package trees.traversal;

import trees.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

public class ZigzagTraversal {


    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {

        List<List<Integer>> traversal = new ArrayList<>();
        if (root == null) return traversal;

        ArrayDeque<TreeNode> q1 = new ArrayDeque<>();
        ArrayDeque<TreeNode> q2 = new ArrayDeque<>();
        q1.add(root);
        int count = 1;

        while (!q1.isEmpty() || !q2.isEmpty()) {

            List<Integer> currList = new ArrayList<>();
            TreeNode top;

            while (!q2.isEmpty() && count % 2 == 0) {

                top = q2.removeLast();
                //System.out.print(top.val+" ");
                currList.add(top.value);
                if (top.right != null) q1.addFirst(top.right);
                if (top.left != null) q1.addFirst(top.left);

            }

            while (!q1.isEmpty() && count % 2 == 1) {

                top = q1.remove();
                currList.add(top.value);
                //System.out.print(top.val+" ");
                if (top.left != null) q2.add(top.left);
                if (top.right != null) q2.add(top.right);

            }
            //System.out.println();
            traversal.add(currList);
            count += 1;
        }

        return traversal;

    }

    public static void main(String[] args) {

        TreeNode treeNode = new TreeNode();
        TreeNode tree = treeNode.buildCompleteTree();
        ZigzagTraversal zigzagTraversal = new ZigzagTraversal();
        List<List<Integer>> lists = zigzagTraversal.zigzagLevelOrder(tree);
        System.out.println(lists);

    }

}
