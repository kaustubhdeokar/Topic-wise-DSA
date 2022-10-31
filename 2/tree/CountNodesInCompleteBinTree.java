package tree;

public class CountNodesInCompleteBinTree {

    public int countNodes(TreeNode root) {
        
        if(root==null)
            return 0;

        int leftHeight = 0;
        
        TreeNode left = root;
        
        while(left!=null){
            left = left.left;
            leftHeight += 1;
        }

        TreeNode right = root;
        int rightHeight = 0;
        while(right!=null){
            right = right.right;
            rightHeight += 1;
        }

        if(leftHeight == rightHeight)
            return (int) Math.pow(2,leftHeight)-1;
        else
            return 1+countNodes(root.left)+countNodes(root.right);
    }

}
