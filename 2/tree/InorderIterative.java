package tree;

import java.util.Stack;

public class InorderIterative {

    public void inorder(TreeNode treeNode) {

        Stack<TreeNode> stack = new Stack<>();
        stack.push(treeNode);
        while (!stack.isEmpty()) {
            TreeNode top = stack.pop();
            System.out.println(top.val);
            if (top.right != null) {
                stack.push(top.right);
            }
            if (top.left != null) {
                stack.push(top.left);
            }
        }
    }

}
