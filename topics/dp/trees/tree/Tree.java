package trees.tree;

import trees.TreeNode;

public class Tree {

    public TreeNode pathSumSampleTree() {
        /*
            -2
           /  \
          null -3
        */
        TreeNode root = new TreeNode(-2);
        root.left = null;
        root.right = new TreeNode(-3);
        return root;
    }

    public TreeNode pathSumSampleTree2(){
        TreeNode root = new TreeNode(0);
        root.left = new TreeNode(1);
        root.right = new TreeNode(1);
        return root;
    }
}
