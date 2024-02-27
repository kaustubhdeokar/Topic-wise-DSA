package traversal;


import base.Node;

import java.util.ArrayList;

public class BoundaryTraversal {

    /*
          7
        /   \
       2      9
      / \    / \
     1   4  8   10
        / \
       3   5
    */

    public ArrayList<Integer> boundaryTraversal(Node tree) {

        ArrayList<Integer> list = new ArrayList<>();
        if (tree == null)
            return list;

        list.add(tree.val);

        if (tree.left == null && tree.right == null)
            return list;

        int level = 1;        

        if (tree.left != null) {
            traversePreOrderWithLevel(tree.left, list);
        }

        traverseTreeForLeafNodesInOrder(tree, list);

        if (tree.right != null) {
            traversePostOrderWithLevel(tree.right, list);
        }

        return list;
    }

    private void traverseTreeForLeafNodesInOrder(Node root, ArrayList<Integer> list) {
        if (root == null)
            return;
        if (root.left == null && root.right == null)
            list.add(root.val);

        traversePreOrderWithLevel(root.left, list);
        traversePreOrderWithLevel(root.right, list);
    }

    private void traversePreOrderWithLevel(Node root, ArrayList<Integer> list) {
        if (root == null)
            return;
        if (root.left == null && root.right == null)
            return;

        System.out.println(root.val);
        list.add(root.val);

        if (root.left != null)
            traversePreOrderWithLevel(root.left, list);
        else
            traversePreOrderWithLevel(root.right, list);

    }


    private void traversePostOrderWithLevel(Node root, ArrayList<Integer> list) {
        if (root == null)
            return;
        if (root.left == null && root.right == null)
            return;

        if (root.right != null) {
            traversePostOrderWithLevel(root.right, list);
        } else {
            traversePostOrderWithLevel(root.left, list);
        }
        System.out.println(root.val);
    }

}
