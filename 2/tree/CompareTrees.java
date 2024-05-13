package tree;

import tree.TreeNode;

public class CompareTrees {

    public boolean compare(TreeNode root, TreeNode deserializedRoot) {
        if (root == null && deserializedRoot == null)
            return true;
        if (root == null || deserializedRoot == null)
            return false;

        if (root.val != deserializedRoot.val)
            return false;

        return compare(root.left, deserializedRoot.left) && compare(root.right, deserializedRoot.right);

    }

    public static void main(String[] args) {

        CompareTrees compareTrees = new CompareTrees();
        TreeNode treeNode1 = compareTrees.formNode();
        TreeNode treeNode2 = compareTrees.formNodeByString();
        boolean compare = compareTrees.compare(treeNode1, treeNode2);
        System.out.println("Should be equal: " + compare);
    }

    private TreeNode formNodeByString() {
        StringToTree stringToTree = new StringToTree();
        String tree = "7 2 1 -1001 -1001 4 3 -1001 -1001 5 -1001 -1001 9 8 -1001 -1001 10 -1001 -1001";
        return stringToTree.deserialize(tree);
    }

    private TreeNode formNode() {
                    /*
                     7
                  /    \
                 2      9
                / \    / \
                1   4  8   10
                   / \
                   3  5
                */
        TreeNode root = new TreeNode(7);
        root.left = new TreeNode(2);
        root.right = new TreeNode(9);

        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(4);

        root.right.left = new TreeNode(8);
        root.right.right = new TreeNode(10);

        root.left.right.left = new TreeNode(3);
        root.left.right.right = new TreeNode(5);

        return root;

    }

}
