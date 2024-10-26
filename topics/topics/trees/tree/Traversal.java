package trees.tree;

import trees.TreeNode;
import trees.bst.BinarySearchTree;

import java.util.ArrayDeque;

public class Traversal {

    public void inorderRecursive(TreeNode treeNode) {
        if (treeNode == null) return;
        inorderRecursive(treeNode.left);
        System.out.println(treeNode.val + " ");
        inorderRecursive(treeNode.right);
    }

    public void levelOrder(TreeNode treeNode) {
        ArrayDeque<TreeNode> queue = new ArrayDeque<>();
        queue.add(treeNode);

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode curr = queue.remove();
                System.out.print(curr.val + " ");
                if (curr.left != null) queue.add(curr.left);
                if (curr.right != null) queue.add(curr.right);
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        BinarySearchTree binarySearchTree = new BinarySearchTree();
        TreeNode sampleBst = binarySearchTree.createSampleTree();
        Traversal traversal = new Traversal();
        traversal.levelOrder(sampleBst);
    }

}
