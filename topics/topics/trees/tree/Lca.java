package trees.tree;

import trees.TreeNode;
import trees.bst.BinarySearchTree;

public class Lca {

    public static void main(String[] args) {
        BinarySearchTree binarySearchTree = new BinarySearchTree();
        TreeNode sampleTree = binarySearchTree.createSampleTree();
        Lca lca = new Lca();
        StringBuilder path = new StringBuilder();
        TreeNode lcaNode = lca.traverse(sampleTree, sampleTree.right.left.val, sampleTree.right.right.right.val, path);
        System.out.println(lcaNode.val);
    }

    public TreeNode traverse(TreeNode node, int leftVal, int rightVal, StringBuilder path) {

        if (node == null) return null;
        if (node.val == leftVal) {
            System.out.println(path.toString());
            return node;
        }
        if (node.val == rightVal) {
            System.out.println(path.toString());
            return node;
        }
        path.append("l");
        TreeNode leftAns = traverse(node.left, leftVal, rightVal, path);
        path.deleteCharAt(path.length() - 1);
        path.append("r");
        TreeNode rightAns = traverse(node.right, leftVal, rightVal, path);
        path.deleteCharAt(path.length() - 1);

        if (leftAns != null && rightAns != null) return node;
        if (leftAns != null) return leftAns;
        return rightAns;

    }

}
