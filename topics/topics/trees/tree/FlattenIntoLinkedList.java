package trees.tree;

import trees.TreeNode;
import trees.bst.BinarySearchTree;

public class FlattenIntoLinkedList {

    TreeNode prev = null;

    public void flatten(TreeNode root) {
        if (root == null) return;
        flatten(root.right);
        flatten(root.left);

        root.right = prev;
        root.left = null;
        prev = root;

    }

    public void flatten1(TreeNode root) {

        TreeNode curr = root;
        while(curr!=null){
            if(curr.left!=null){
                TreeNode tempLeft = curr.left;

                while(tempLeft.right!=null){
                    tempLeft = tempLeft.right;
                }
                tempLeft.right = curr.right;
                curr.right = curr.left;
                curr.left = null;
            }
            curr = curr.right;
        }
    }

    public static void main(String[] args) {

        TreeNode sampleTree = new BinarySearchTree().createSampleTree();
        FlattenIntoLinkedList flatten = new FlattenIntoLinkedList();
        flatten.flatten1(sampleTree);
        Traversal traversal = new Traversal();
        traversal.levelOrder(sampleTree);
    }

}
