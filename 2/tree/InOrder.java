package tree;

import java.util.Stack;

public class InOrder {

    public void recursive(TreeNode tree){
        if(tree==null)
            return;
        System.out.print(tree.val+" ");
        recursive(tree.left);
        recursive(tree.right);
    }

    public void iterative(TreeNode node){
        if(node==null) return;

        Stack<TreeNode> stack = new Stack<>();
        stack.add(node);
        while(!stack.isEmpty()){
            TreeNode top = stack.pop();
            System.out.print(top.val+" ");
            if(top.right!=null) stack.push(top.right);
            if(top.left!=null) stack.push(top.left);
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
