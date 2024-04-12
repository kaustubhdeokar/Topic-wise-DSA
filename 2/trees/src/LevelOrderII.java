package src.traversal;

import src.TreeNode;

import java.util.ArrayList;
import java.util.List;
//https://leetcode.com/problems/binary-tree-level-order-traversal-ii/
//article : https://leetcode.com/problems/binary-tree-level-order-traversal-ii/discuss/2166674/100-faster-93.45-memory-efficiency.

public class LevelOrderII {

    //this is not really level order, we are using a pre order traversal to fill in the list which
    //is in level order format.

    public List<List<Integer>> levelOrderBottom(TreeNode root) {

        List<List<Integer>> traversal = new ArrayList<>();

        //logn
        int height = findHeight(root);
        for (int i = 0; i < height; i++) {
            traversal.add(new ArrayList<Integer>());
        }
        //

        //n (n nodes)
        levelOrder(root, 0, traversal, height - 1);
        //

        return traversal;
    }

    public void levelOrder(TreeNode root, int currLevel, List<List<Integer>> traversal, int height) {
        if (root == null)
            return;
        traversal.get(height - currLevel).add(root.val);
        levelOrder(root.left, currLevel + 1, traversal, height);
        levelOrder(root.right, currLevel + 1, traversal, height);
    }


    public int findHeight(TreeNode root) {
        if (root == null)
            return 0;
        else
            return 1 + Integer.max(findHeight(root.left), findHeight(root.right));
    }
}
