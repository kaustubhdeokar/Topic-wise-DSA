package tree;

import java.util.Stack;

public class PostOrder {
    public void iterative(TreeNode node) {

        Stack<TreeNode> stack = new Stack<>();
        stack.push(node);

        Stack<Integer> answer = new Stack<>();
        TreeNode top = stack.pop();
        answer.push(top.val);

        while (!stack.isEmpty() || top!=null) {

            while (top!=null){
                stack.push(top);
                top = top.right;
            }
            top = stack.pop();
            System.out.println(top.val);
            if(top.left!=null)
                top = top.left;
        }
    }

    public void recursive(TreeNode node) {
        if (node == null)
            return;

        recursive(node.left);
        recursive(node.right);
        System.out.print(node.val + " ");
    }

    public static void main(String[] args) {

        TreeNode treeNode = new TreeNode();

        PostOrder postOrder = new PostOrder();
//        postOrder.recursive(treeNode.buildTree());
//        System.out.println();

        postOrder.iterative(treeNode.buildTree());
        System.out.println();
    }

}
