package tree;

import java.util.Stack;

public class PreOrder {
    public void iterative(TreeNode node) {

        Stack<TreeNode> stack = new Stack<>();

        while (!stack.isEmpty() || node != null) {

            while (node != null) {
                stack.push(node);
                node = node.left;
            }

            TreeNode pop = stack.pop();

            System.out.println(pop.val);

            if (pop.right != null)
                node = pop.right;
        }

    }

    public void recursive(TreeNode treeNode) {

        if (treeNode == null)
            return;

        System.out.println(treeNode.val);
        recursive(treeNode.left);
        recursive(treeNode.right);
    }

    public static void main(String[] args) {

        TreeNode root = new TreeNode();

        PreOrder preOrder = new PreOrder();
        preOrder.iterative(root.buildTree());
        System.out.println();
        preOrder.recursive(root.buildTree());

    }

}
