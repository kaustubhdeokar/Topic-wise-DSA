
public class ChildSumProperty {

    public static boolean magicParents(TreeNode node) {

        if (node == null)
            return true;

        if (node.left == null && node.right == null)
            return true;

        boolean left = magicParents(node.left);
        boolean right = magicParents(node.right);

        int childSum = 0;
        if (node.left != null) childSum += node.left.value;
        if (node.right != null) childSum += node.right.value;

        return left && right && childSum == node.value;

    }


    public static void main(String[] args) {

        TreeNode treeNode = new TreeNode();
        TreeNode head = treeNode.constructChildSumTree();
        System.out.println(magicParents(head));

    }


}
