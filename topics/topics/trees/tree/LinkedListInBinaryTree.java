package trees.tree;

import linkedlist.LLNode;
import trees.Traversal;
import trees.TreeNode;

//leetcode POD 7 sep.
public class LinkedListInBinaryTree {

    public boolean isSubPath(LLNode ll, TreeNode tree) {

        if (tree == null) {
            return false;
        }
        if (tree.data == ll.data) {
            return doesMatch(ll.next, tree.left) || doesMatch(ll.next, tree.right) || isSubPath(ll, tree.left) || isSubPath(ll, tree.right);
        } else {
            return isSubPath(ll, tree.left) || isSubPath(ll, tree.right);
        }

    }

    public boolean doesMatch(LLNode ll, TreeNode tree) {

        if (ll == null) {
            return true;
        }
        if (tree == null) {
            return false;
        }

        if (ll.data != tree.data) {
            return false;
        }

        return doesMatch(ll.next, tree.left) || doesMatch(ll.next, tree.right);

    }

    public static void main(String[] args) {

        LLNode llNode = new LLNode(4);
        llNode.next = new LLNode(2);
        llNode.next.next = new LLNode(8);

        Tree tree = new Tree();
        TreeNode head = tree.createTree(new Integer[]{1, 4, 4, null, 2, 2, null, 1, null, 6, 8, null, null, null, null, 1, 3});

        LinkedListInBinaryTree linkedListInBinaryTree = new LinkedListInBinaryTree();
        System.out.println(linkedListInBinaryTree.isSubPath(llNode, head));


    }

}
