package tree;

import java.util.ArrayList;
import java.util.HashSet;

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
        TreeNode newRoot = deleteNode.deleteNode(root, 60);
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

    public void pathToNodePlusDistances() {
        TreeNode treeNode = getTreeDataSet1();
        BurnATree burnATree = new BurnATree();
        burnATree.burnTree(treeNode, 90);
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

    public void serialise() {
        SerializeDeserialize serializeDeserialize = new SerializeDeserialize();
        TreeNode root = null;
        String serializedTree = serializeDeserialize.serialize(root);
        TreeNode deserializedRoot = serializeDeserialize.deserialize(serializedTree);
        CompareTrees compareTrees = new CompareTrees();
        System.out.println("both trees are same:" + compareTrees.compare(root, deserializedRoot));
    }

    public void allNodesDistanceK() {
        NodesAtKDistFromTarget nodes = new NodesAtKDistFromTarget();
        TreeNode root = getTreeDataSet4();
        int dist = 1;
        ArrayList<Integer> nodesAtDistK = nodes.getNodesAtDistK(root, root.left.right, dist);
        for (Integer i : nodesAtDistK) {
            System.out.print(i + " ");
        }

        HashSet<Integer> set = new HashSet<>();

        System.out.println();
    }

    public static void main(String[] args) {

        Tree tree = new Tree();
        tree.deleteNodeHelper(getTreeDataSet1(), tree);

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

    private static TreeNode getTreeDataSet1() {
        TreeNode treeNode = new TreeNode(10);
        treeNode.left = new TreeNode(50);
        treeNode.right = new TreeNode(60);
        treeNode.right.right = new TreeNode(100);
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
            /  \   \
           70  20   100
          /    / \
         40   90  80
             /
            30

        * */

        return treeNode;
    }

    public static TreeNode getTreeDataSet2() {
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(20);
        root.right = new TreeNode(30);
        root.right.left = new TreeNode(40);

        /*
         10
        /  \
       20  30
           /
          40
        */
        return root;
    }

    public static TreeNode getTreeDataSet3() {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(5);
        root.left.left = new TreeNode(6);
        root.left.right = new TreeNode(2);
        root.left.right.left = new TreeNode(7);
        root.left.right.right = new TreeNode(4);

        root.right = new TreeNode(1);
        root.right.left = new TreeNode(0);
        root.right.right = new TreeNode(8);

        return root;
        //https://leetcode.com/problems/all-nodes-distance-k-in-binary-tree/
    }

    public static TreeNode getTreeDataSet4() {
        TreeNode root = new TreeNode(0);
        root.left = new TreeNode(1);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(2);
        return root;

        /*
             0
            /
           1
          / \
         3  2

        * */
    }

}
