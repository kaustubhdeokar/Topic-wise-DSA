package trees.binarytree;

import linkedlist.LLNode;
import trees.TreeNode;

public class LinkedListToBst {

    public static void main(String[] args) {

        int[] arr = new int[]{1, 2, 3, 4, 5, 6, 7};
        LLNode llNode = new LLNode().createLLNodeList(arr);
        LinkedListToBst llbst = new LinkedListToBst();
        TreeNode bst = llbst.createBst(new LLNode[]{llNode}, new TreeNode(0), 0, arr.length - 1);
        new Traversal().levelOrder(bst);
    }

    private TreeNode createBst(LLNode[] llNode, TreeNode root, int start, int end) {
        if (start > end) return null;
        int mid = start + (end - start) / 2;
        root.left = createBst(llNode, root, start, mid - 1);
        root = new TreeNode(llNode[0].val);
        llNode[0] = llNode[0].next;
        root.right = createBst(llNode, root, mid + 1, end);
        return root;
    }

    private int countLength(LLNode llNode) {
        int count = 0;
        while (llNode != null) {
            count += 1;
            llNode = llNode.next;
        }
        return count;
    }

}
