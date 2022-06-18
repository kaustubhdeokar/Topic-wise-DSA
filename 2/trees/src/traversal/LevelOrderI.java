package src.traversal;

import src.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class LevelOrderI {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> traversal = new ArrayList<>();

        //logn
        int height = findHeight(root);
        for (int i = 0; i < height; i++) {
            traversal.add(new ArrayList<Integer>());
        }
        //

        //n (n nodes)
        levelOrder(root, 0, traversal);
        //

        return traversal;

    }

    public void levelOrder(TreeNode root, int currLevel, List<List<Integer>> traversal) {
        if (root == null)
            return;
        traversal.get(currLevel).add(root.val);
        levelOrder(root.left, currLevel + 1, traversal);
        levelOrder(root.right, currLevel + 1, traversal);
    }


    public int findHeight(TreeNode root) {
        if (root == null)
            return 0;
        else
            return 1 + Integer.max(findHeight(root.left), findHeight(root.right));
    }
}
