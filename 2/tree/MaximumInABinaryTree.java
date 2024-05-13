package tree;

import java.util.Stack;

public class MaximumInABinaryTree {

    public int maximumElement(TreeNode treeNode) {

        int max = Integer.MIN_VALUE;
        Stack<TreeNode> stack = new Stack<>();
        while (treeNode != null || !stack.isEmpty()) {
            while (treeNode != null) {
                stack.push(treeNode);
                treeNode = treeNode.left;
            }
            TreeNode top = stack.pop();
            max = Integer.max(top.val,max);
            if(top.right!=null)
                treeNode = top.right;
        }

        return max;
    }

}
