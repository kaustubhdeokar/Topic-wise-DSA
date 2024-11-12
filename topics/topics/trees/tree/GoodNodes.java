package trees.tree;

import trees.TreeNode;
import java.util.Stack;

public class GoodNodes {
    public static void main(String[] args) {

        Integer[] arr = {3, 4, 1, 5, 6, 2, 9};
        TreeNode root = null;
        GoodNodes goodNodes = new GoodNodes();
        Serialize serialize = new Serialize();
        root = serialize.createTree(root, arr);
        Stack<Integer> stack = new Stack<>();
        goodNodes.traversal(root, new StringBuilder(), stack);

        Traversal traversal = new Traversal();
        traversal.levelOrder(root);
    }

    public void traversal(TreeNode root, StringBuilder path) {

        if (root == null) return;

        path.append(root.val);
        System.out.println("root:" + root.val + " path:" + path);
        traversal(root.left, path);
        traversal(root.right, path);
        path.deleteCharAt(path.length() - 1);

    }

    public void traversal(TreeNode root, StringBuilder path, Stack<Integer> stack) {

        if (root == null) return;

        path.append(root.val);
        if (stack.isEmpty() || stack.peek() <= root.val) stack.push(root.val);
        System.out.println("root:" + root.val + " ,highest until here:" + stack.peek());
        traversal(root.left, path, stack);
        traversal(root.right, path, stack);
        path.deleteCharAt(path.length() - 1);
        if (!stack.isEmpty() && root.val == stack.peek()) stack.pop();
    }


}
