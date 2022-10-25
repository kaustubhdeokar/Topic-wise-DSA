package tree;

import java.util.*;

public class ConstructFromInorderPreorder {

    public static TreeNode buildTree(int inorder[], int preorder[], int n) {

        TreeNode root = new TreeNode(preorder[0]); //0
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            map.put(inorder[i], i);
        }
        //         0 1 2 3 4 5
        // inorder 3 1 4 0 5 2


        //preorder 0 1 3 4 2 5

        int start = 0;
        int end = n - 1;
        int[] nextRootIndex = {1};
        //0,2
        root.left = constructTree(inorder, preorder, map, nextRootIndex, start, map.get(root.val) - 1);
        //4,5
        root.right = constructTree(inorder, preorder, map, nextRootIndex, map.get(root.val) + 1, end);

        return root;
    }

    public static TreeNode constructTree(int[] inorder, int[] preorder, HashMap<Integer, Integer> map, int[] nextRootIndex, int start, int end) {
        //0,2
        //0,0
        if (start <= end) {
            int nextRoot = preorder[nextRootIndex[0]++]; //1
            TreeNode root = new TreeNode(nextRoot);

            root.left = constructTree(inorder, preorder, map, nextRootIndex, start, map.get(nextRoot) - 1);
            root.right = constructTree(inorder, preorder, map, nextRootIndex, map.get(nextRoot) + 1, end);

            return root;
        }
        return null;
    }


    public static void main(String[] args) {

        ConstructFromInorderPreorder construct = new ConstructFromInorderPreorder();
        int[] inorder = {3, 1, 4, 0, 5, 2};
        int[] preorder = {0, 1, 3, 4, 2, 5};
        TreeNode treeNode = construct.buildTree(inorder, preorder, inorder.length);
        treeNode.traverse(treeNode);

    }

}
