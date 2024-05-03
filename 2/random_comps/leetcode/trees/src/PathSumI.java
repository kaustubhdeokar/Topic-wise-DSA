package trees.src;

//https://leetcode.com/problems/path-sum/description/
public class PathSumI {

    public boolean hasPathSum(TreeNode root, int targetSum) {
        int curr = 0;
        return hasPathSum(root, targetSum,curr);
    }

    public boolean hasPathSum(TreeNode root, int targetSum, int curr) {
        if(root == null) return false;

        curr += root.val;
        if(root.left==null && root.right==null){
            return curr==targetSum;
        }
        boolean b1 = hasPathSum(root.left, targetSum, curr);
        if(b1)return true;
        boolean b2 = hasPathSum(root.right, targetSum, curr);
        if(b2) return true;
        curr -= root.val;
        return false;
    }

    public static void main(String[] args) {
        
        TreeNode root = formNode();
        PathSumI pathSumI = new PathSumI();
        System.out.println(pathSumI.hasPathSum(root,28));
    }

    public static TreeNode formNode() {
        /*
                  5
                /   \
               4     8
              /     / \
             11    13  4
            / \         \
           7   2         1  
        */
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(4);
        root.right = new TreeNode(8);

        root.left.left = new TreeNode(11);

        root.right.left = new TreeNode(13);
        root.right.right = new TreeNode(4);

        root.left.left.left = new TreeNode(7);
        root.left.left.right = new TreeNode(2);

        root.right.right.right = new TreeNode(1);

        return root;

    }

}
