package trees.src;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;


public class ConstructTreeFromInorderPreorder {

    public TreeNode buildTree(int[] inorder, int[] preorder, int len) {

        // iterate through the preorder array.
        // pick an element
        // search that in inorder array.
        // left side - left subtree & right side - right subtree.
        int start = 0;
        int end = len - 1;
        int[] index = { 0 };
        return buildTree(inorder, preorder, index, start, end);

    }

    public TreeNode buildTree(int[] inorder, int[] preorder, int[] index, int start, int end) {

        while (start <= end) {
            int preorderElem = preorder[index[0]++];
            int idx = indexinInorderArr(preorderElem, inorder);
            TreeNode root = new TreeNode(preorderElem);
            root.left = buildTree(inorder, preorder, index, start, idx - 1);
            root.right = buildTree(inorder, preorder, index, idx + 1, end);
            return root;
        }
        return null;
    }

    public int indexinInorderArr(int elem, int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == elem) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {

        ConstructTreeFromInorderPreorder construct = new ConstructTreeFromInorderPreorder();
        int[] inorder = { 3, 1, 4, 0, 5, 2 };
        int[] preorder = { 0, 1, 3, 4, 2, 5 };
        TreeNode treeNode = construct.buildTree(inorder, preorder, inorder.length);
        treeNode.levelOrder(treeNode);

    }

}
