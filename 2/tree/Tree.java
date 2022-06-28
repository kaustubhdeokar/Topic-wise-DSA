package tree;

public class Tree {

    public TreeNode insertIntoBST(TreeNode root, int val) {
        if (root == null) {
            root = new TreeNode(val);
        } else if (root.val >= val) {
            root.left = insertIntoBST(root.left, val);
        } else {
            root.right = insertIntoBST(root.right, val);
        }
        return root;
    }




    public void printInorder(TreeNode root) {
        if (root == null)
            return;
        printInorder(root.left);
        System.out.println(root.val);
        printInorder(root.right);
    }

    public void deleteNodeHelper(TreeNode root, Tree tree) {
        DeleteNode deleteNode = new DeleteNode();
        TreeNode newRoot = deleteNode.deleteNode(root, 5);
        tree.printInorder(newRoot);

    }

    public void printInorderIterative(TreeNode treeNode){
        IterativePreorder iterativePreorder = new IterativePreorder();
        iterativePreorder.iterativePreorder(treeNode);
    }


    public static void main(String[] args) {

        Tree tree = new Tree();
        TreeNode root = createTree(tree);

//        tree.deleteNodeHelper(root, tree);
        tree.printInorderIterative(root);


    }

    private static TreeNode createTree(Tree tree) {
        TreeNode root = new TreeNode(5);
        tree.insertIntoBST(root, 3);
        tree.insertIntoBST(root, 6);
        tree.insertIntoBST(root, 2);
        tree.insertIntoBST(root, 4);
        tree.insertIntoBST(root, 7);
        return root;
    }

}
