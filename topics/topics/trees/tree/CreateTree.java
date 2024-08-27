package trees.tree;

import trees.Traversal;
import trees.TreeNode;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class CreateTree {

    Scanner scan = new Scanner(new BufferedReader(new InputStreamReader(System.in)));

    public TreeNode createTree(TreeNode treeNode) {

        System.out.println("User input: Enter a number");
        int data = scan.nextInt();
        treeNode = new TreeNode(data);

        System.out.println("Current:" + treeNode.data);

        System.out.println("Add children to left child ? (y/n)");
        String choice = scan.next();
        if (choice.equals("y")) {
            treeNode.left = createTree(treeNode.left);
        }

        System.out.println("Current:" + treeNode.data);
        System.out.println("Expand right child ? (y/n)");
        choice = scan.next();
        if (choice.equals("y")) {
            treeNode.right = createTree(treeNode.right);
        }
        return treeNode;
    }

    public static void main(String[] args) {
        CreateTree createTree = new CreateTree();
        TreeNode treeNode = createTree.createTree(null);
        Traversal traversal = new Traversal();
        traversal.levelOrder(treeNode);
    }

}
