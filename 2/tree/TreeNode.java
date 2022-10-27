package tree;

public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }


    public TreeNode buildCompleteTree(){
        TreeNode root = new TreeNode(30);
        root.left = new TreeNode(20);
        root.right = new TreeNode(10);
        root.left.left = new TreeNode(5);
        root.left.right = new TreeNode(15);
        root.right.left = new TreeNode(5);
        root.right.right = new TreeNode(5);

        /*
           30
        /      \
       20       10
      /  \     /  \
     5   15   5    5 
               
        */
        return root;
    }

    public TreeNode buildTree2() {
        TreeNode root = new TreeNode(20);
        root.left = new TreeNode(10);
        root.left.left = new TreeNode(5);
        root.left.right = new TreeNode(15);
        
        root.right = new TreeNode(30);
        root.right.left = new TreeNode(25);
        root.right.right = new TreeNode(35);
        root.right.left.left = new TreeNode(45);
        root.right.left.right = new TreeNode(55);

        /*
          20
        /    \
       10     30
      / \     /  \
     5  15   25   35
            /  \
           45   55
        */
        return root;
    }

    public TreeNode buildTree(){
        TreeNode root = new TreeNode(20);
        root.left = new TreeNode(10);
        root.right = new TreeNode(30);
        root.right.right = new TreeNode(40);
        root.right.right.right = new TreeNode(50);

        /*
         20
        /  \
       10  30
             \
             40
               \
                50
        */
        return root;
    }

    public void traverse(TreeNode root) {
        if (root == null)
            return;
        traverse(root.left);
        System.out.println(root.val);
        traverse(root.right);
    }

}
