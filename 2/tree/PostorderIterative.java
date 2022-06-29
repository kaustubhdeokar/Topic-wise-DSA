package tree;

import java.util.Stack;

public class PostorderIterative {
    public void postorder(TreeNode node) {
        Stack<TreeNode> stack = new Stack<>();
        stack.push(node);
        while (!stack.isEmpty()) {
            TreeNode top = stack.pop();

        }
    }
}
