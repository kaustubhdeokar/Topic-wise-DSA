package tree;

import java.util.ArrayList;

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

    public void printInorderIterative(TreeNode treeNode) {
        InorderIterative inorderIterative = new InorderIterative();
        inorderIterative.inorder(treeNode);
    }

    public void printPreOrderIterative(TreeNode treeNode) {
        PreorderIterative preorderIterative = new PreorderIterative();
        preorderIterative.preorder(treeNode);
    }

    public void printPostorderIterative(TreeNode treeNode) {
        PostorderIterative postorderIterative = new PostorderIterative();
        postorderIterative.postorder(treeNode);
    }

    public void pathSum(TreeNode treeNode) {
        PathSum pathSum = new PathSum();
        System.out.println(pathSum.pathSumEqualToTarget(treeNode, 20));
    }

    public void pathSumII(TreeNode treeNode) {
        PathSumII pathSum = new PathSumII();
        System.out.println(pathSum.pathSum(treeNode, 20));
    }

    public void sizeOfTree(TreeNode treeNode) {
        SizeOfTree sizeOfTree = new SizeOfTree();
        System.out.println("Size of tree:" + sizeOfTree.size(treeNode));
    }

    public void findLeftView() {
        TreeNode treeNode = new TreeNode(5);
        treeNode.left = new TreeNode(4);
        treeNode.right = new TreeNode(6);
        treeNode.right.right = new TreeNode(7);
        treeNode.right.right.right = new TreeNode(8);

        /*
         5
        / \
       4   6
            \
             7
              \
               8
        * */
        LeftView leftView = new LeftView();
        int[] leftViewArr = leftView.leftView(treeNode);
        for (Integer i : leftViewArr) {
            System.out.print(i + " ");
        }
    }

    public void pathToNode() {
        TreeNode treeNode = getTreeDataSet1();

        PathToNode path = new PathToNode();
        ArrayList<Integer> pathList = path.printPathToNode(treeNode, 30);
        for (Integer i : pathList) {
            System.out.print(i + " ");
        }
    }

    public void pathToNodePlusDistances(){
        TreeNode treeNode = getTreeDataSet1();
        BurnATree burnATree = new BurnATree();
        burnATree.burnTree(treeNode,90);
    }

    private TreeNode getTreeDataSet1() {
        TreeNode treeNode = new TreeNode(10);
        treeNode.left = new TreeNode(50);
        treeNode.right = new TreeNode(60);
        treeNode.left.left = new TreeNode(70);
        treeNode.left.left.left = new TreeNode(40);
        treeNode.left.right = new TreeNode(20);
        treeNode.left.right.left = new TreeNode(90);
        treeNode.left.right.right = new TreeNode(80);
        treeNode.left.right.left.left = new TreeNode(30);

        /*

              10
              / \
             50  60
            /  \
           70  20
          /    / \
         40   90  80
             /
            30

        * */

        return treeNode;
    }

    public void lca() {
        TreeNode treeNode = getTreeDataSet1();
        LCA lca = new LCA();
        System.out.println("lca by path sum:" + lca.findLCAPathSum(treeNode, 30, 80));

        System.out.println("lca recursively:" + lca.findLCA(treeNode, 70, 60));
    }


    public void maximumElement(TreeNode treeNode) {
        MaximumInABinaryTree maximumInABinaryTree = new MaximumInABinaryTree();
        System.out.println("Max element:" + maximumInABinaryTree.maximumElement(treeNode));
    }

    public static void main(String[] args) {

        Tree tree = new Tree();
        tree.pathToNodePlusDistances();
    }

    private static TreeNode createTree(Tree tree) {
        TreeNode root = new TreeNode(6);
        tree.insertIntoBST(root, 5);
        tree.insertIntoBST(root, 8);
        tree.insertIntoBST(root, 11);
        tree.insertIntoBST(root, 7);
        tree.insertIntoBST(root, 4);
        tree.insertIntoBST(root, 3);
        tree.insertIntoBST(root, 13);
        tree.insertIntoBST(root, 2);
        return root;
    }

}
