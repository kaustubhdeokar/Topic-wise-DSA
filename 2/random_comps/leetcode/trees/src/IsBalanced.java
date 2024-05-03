package trees.src;

class IsBalanced {
    public boolean isBalanced(TreeNode root) {
        if (root == null || (root.left == null && root.right == null))
            return true;
        boolean[] isBalanced = {true};
        checkForBalanced(root, isBalanced);
        return isBalanced[0];
    }

    public int checkForBalanced(TreeNode root, boolean[] isBalanced) {
        if (root == null)
            return 0;
        int leftH = checkForBalanced(root.left, isBalanced);
        int rightH = checkForBalanced(root.right, isBalanced);
        if (Math.abs(leftH - rightH) > 1)
            isBalanced[0] = false;
        return 1 + Math.max(leftH, rightH);
    }
}
