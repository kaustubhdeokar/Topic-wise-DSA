
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

public class ZigZagTraversal {

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> traversal = new ArrayList<>();

        // logn
        int height = findHeight(root);
        for (int i = 0; i < height; i++) {
            traversal.add(new ArrayList<Integer>());
        }
        //

        // n (n nodes)
        zigzagOrder(root, 0, traversal);
        //

        return traversal;

    }

    public void zigzagOrder(TreeNode root, int currLevel, List<List<Integer>> traversal) {
        if (root == null)
            return;

        if ((currLevel & 1) != 0) {
            traversal.get(currLevel).add(0, root.val);
        } else {
            traversal.get(currLevel).add(root.val);
        }
        zigzagOrder(root.left, currLevel + 1, traversal);
        zigzagOrder(root.right, currLevel + 1, traversal);
    }

    public int findHeight(TreeNode root) {
        if (root == null)
            return 0;
        else
            return 1 + Integer.max(findHeight(root.left), findHeight(root.right));
    }

  
}