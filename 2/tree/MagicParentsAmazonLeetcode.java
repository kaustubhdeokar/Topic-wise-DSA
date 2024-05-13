package tree;

/**
 * Given a binary tree, count the total number of magic parents, where a node which is not NULL and has
 * both left and right children and the sum of the nodes in the left subtree is
 * odd and that of right subtree is even (or sum of nodes in the left subtree as even and right subtree as odd)
 */
public class MagicParentsAmazonLeetcode {

    static int[] parent = {0};

    public static int magicParents(TreeNode node) {

        if (node == null) return 0;

        int leftSum = magicParents(node.left);
        int rightSum = magicParents(node.right);

        if (node.left != null && node.right != null) {
            if (leftSum % 2 != 0 && rightSum % 2 == 0) {
                parent[0] += 1;
            } else if (leftSum % 2 == 0 && rightSum % 2 != 0) {
                parent[0] += 1;
            }
        }

        return leftSum + rightSum + node.val;

    }

    public static void main(String[] args) {

        TreeNode treeNode = new TreeNode();
        TreeNode head = constructChildSumTree();
        magicParents(head);

        System.out.println(parent[0]);

    }

    private static TreeNode constructChildSumTree() {
        TreeNode head = new TreeNode(1);
        head.left = new TreeNode(2);
        head.right = new TreeNode(3);
        head.right.left = new TreeNode(5);
        return head;
    }
}
