package tree;

import java.util.*;
import tree.TreeNode;

public class Inorder {
    
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
        TreeNode root = new TreeNode(20);
        root.left = new TreeNode(10);
        root.right = new TreeNode(30);
        root.right.right = new TreeNode(40);
        root.right.right.right = new TreeNode(50);

        /*
         20
        /  \
       10  30
             \
             40
               \
                50
        */

        Inorder inorder = new Inorder();
        inorder.iterative(root);
        System.out.println();
        inorder.recursive(root);
        System.out.println();

    }

}
