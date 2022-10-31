package tree;

import java.util.Stack;

public class InOrder {

    public void recursive(TreeNode tree){
        if(tree==null)
            return;
        recursive(tree.left);
        System.out.print(tree.val+" ");
        recursive(tree.right);
    }

    public void iterative(TreeNode node) {
        if (node == null) return;

        Stack<TreeNode> stack = new Stack<>();
        TreeNode top = node;
        while (!stack.isEmpty() || top != null) {
            while (top != null) {
                stack.push(top);
                top = top.left;
            }
            top = stack.pop();
            System.out.println(top.val);
            top = top.right;
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode();

        InOrder inOrder = new InOrder();
        inOrder.iterative(root.buildTree());
        System.out.println();
        inOrder.recursive(root.buildTree());

    }



}
