package trees.tree;

import trees.TreeNode;
import trees.bst.BinarySearchTree;

public class KthLargest {
    public static void main(String[] args) {

        KthLargest kthLargest = new KthLargest();
        Serialize serialize = new Serialize();
        Integer[] arr = {7, 5, 9, 4, 6, 8, 10};
        TreeNode root = serialize.createTree(null, arr);
        int[] ans = {4, -1};
        kthLargest.kthLargest(root, ans);
        System.out.println(ans[1]);
    }

    public void kthLargest(TreeNode tree, int[] ans) {
        if(ans[1]!=-1) return;
        if (tree == null) return;
        kthLargest(tree.left, ans);
        ans[0]-=1;
        if(ans[0]==0) ans[1] = tree.val;
        kthLargest(tree.right, ans);
    }
}
