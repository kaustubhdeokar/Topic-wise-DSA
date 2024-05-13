package tree;

import java.util.Stack;

public class Tree {


    public void printInorder(TreeNode root, TreeNode[] prev, TreeNode[] wrongNodes) {

        if (root == null)
            return;
        printInorder(root.left, prev, wrongNodes);
        if (prev[0].val >= root.val) {
            if (wrongNodes[0] == null) wrongNodes[0] = prev[0];
            if (wrongNodes[0]!=null) wrongNodes[1] = root;
        }
        System.out.println(prev[0].val + " " + root.val);
        prev[0] = root;
        printInorder(root.right, prev, wrongNodes);
    }

    public void inorderIterative(TreeNode root) {

        Stack<TreeNode> stack = new Stack<>();
        TreeNode curr = root;
        while (!stack.isEmpty() || curr != null) {
            while (curr != null) {
                stack.push(curr);
                curr = curr.left;
            }
            while (!stack.isEmpty() && stack.peek().right == null) {
                System.out.print(stack.pop().val + " ");

            }
            if (!stack.isEmpty()) {
                TreeNode pop = stack.pop();
                System.out.print(pop.val + " ");
                curr = pop.right;
            }
        }

    }


    public TreeNode getTreeDataSet1() {
        TreeNode treeNode = new TreeNode(2);
        treeNode.left = new TreeNode(3);
        treeNode.right = new TreeNode(1);
//        treeNode.left.left = new TreeNode(3);
//        treeNode.left.right = new TreeNode(4);
//        treeNode.right.left = new TreeNode(6);
//        treeNode.right.right = new TreeNode(8);

        /*
               10
             /    \
            50    60
           /  \     \
          70   20   100
        */

        return treeNode;
    }

    public static void main(String[] args) {

        Tree tree = new Tree();
        TreeNode head = tree.getTreeDataSet1();
        TreeNode[] prev = {new TreeNode(Integer.MIN_VALUE)};
        TreeNode[] wrongNodes = {null, null};
        tree.printInorder(head, prev, wrongNodes);
        System.out.println(wrongNodes[0].val + " " + wrongNodes[1].val);
    }

}
