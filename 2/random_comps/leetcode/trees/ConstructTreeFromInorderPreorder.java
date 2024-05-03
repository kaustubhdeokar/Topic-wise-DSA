package trees;

public class ConstructTreeFromInorderPreorder {

    public TreeNode constructFromPreOrderInorder(int[] preorderArr, int[] inorderArr, int start, int end, int[] preIndex) {
        if (start > end) {
            return null;
        }
        TreeNode node = new TreeNode(preorderArr[preIndex[0]++]);

        //find node in inorder.
        int i;
        for (i = start; i <= end; i++) {
            if (inorderArr[i] == node.value) {
                break;
            }
        }

        node.left = constructFromPreOrderInorder(preorderArr, inorderArr, start, i - 1, preIndex);
        node.right = constructFromPreOrderInorder(preorderArr, inorderArr, i + 1, end, preIndex);

        return node;
    }

    public static void main(String[] args) {

        ConstructTreeFromInorderPreorder construct = new ConstructTreeFromInorderPreorder();
        int[] pre = {3, 9, 20, 15, 7};
        int[] in = {9, 3, 15, 20, 7};
        TreeNode treeNode = construct.constructFromPreOrderInorder(pre, in, 0, pre.length - 1, new int[]{0});
        InorderTraversal.recursive(treeNode);

    }

}
