package trees.binarytree;

import trees.TreeNode;
import trees.bst.BinarySearchTree;

import java.util.ArrayDeque;
import java.util.Deque;

public class ZigZagTraversal {

    public static void main(String[] args) {

        BinarySearchTree bst = new BinarySearchTree();
        TreeNode treeNode = bst.createSampleTree();
        ZigZagTraversal zigZagTraversal = new ZigZagTraversal();
        zigZagTraversal.zigzag(treeNode);


    }

    public void zigzag(TreeNode root) {

        if (root == null) return;
        Deque<TreeNode> q = new ArrayDeque<>();
        q.add(root);
        TreeNode curr;
        boolean reverse = false;
        while (!q.isEmpty()) {
            int size = q.size();
            if (!reverse) {
                for (int i = 0; i < size; i++) {
                    curr = q.removeFirst();
                    System.out.print(curr.val + " ");
                    if (curr.left != null) q.addLast(curr.left);
                    if (curr.right != null) q.addLast(curr.right);
                }
            } else {
                for (int i = 0; i < size; i++) {
                    curr = q.removeLast();
                    System.out.print(curr.val + " ");
                    if (curr.right != null) q.addFirst(curr.right);
                    if (curr.left != null) q.addFirst(curr.left);
                }
            }
            reverse = !reverse;
            System.out.println();
        }
    }


}
