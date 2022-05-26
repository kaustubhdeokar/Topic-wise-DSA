package base;

import base.Node;

public class Tree {

    public Node head;

    public Node insert(Node head, int val) {
        if (head == null) {
            head = new Node(val);
            return head;
        } else if (head.val < val) {
            head.right = insert(head.right, val);
        } else {
            head.left = insert(head.left, val);
        }
        return head;
    }

    public void traverseInOrder(Node head) {
        if (head == null)
            return;
        traverseInOrder(head.left);
        System.out.println(head.val);
        traverseInOrder(head.right);
    }

}
