package trees.binarytree;

import trees.TreeNode;

import java.util.ArrayDeque;

public class Serialize {

    public TreeNode createTree(TreeNode root, Integer[] arr) {
        ArrayDeque<TreeNode> q = new ArrayDeque<>();
        if (root == null) {
            root = new TreeNode(arr[0]);
            q.push(root);
        }
        int i = 1;
        while (i < arr.length) {
            TreeNode top = q.remove();
            if (arr[i] == null) {
                i += 1;
            } else {
                top.left = new TreeNode(arr[i++]);
            }
            if (arr[i] == null) {
                i += 1;
            } else {
                top.right = new TreeNode(arr[i++]);
            }
            if (top.left != null) q.add(top.left);
            if (top.right != null) q.add(top.right);
        }
        return root;
    }
}
