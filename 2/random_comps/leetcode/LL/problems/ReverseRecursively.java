package LL.problems;

import traversal.Node;

public class ReverseRecursively {

    public Node reverseRecursively(Node head) {
        return reverseRecursively(head, null);
    }

    private Node reverseRecursively(Node head, Node prev) {

        if (head == null)
            return prev;

        Node nextNode = head.next;
        head.next = prev;
        return reverseRecursively(nextNode, head);

    }

    public void print(Node head) {
        while (head != null) {
            System.out.println(head.data);
            head = head.next;
        }
    }

    public static void main(String[] args) {
        ReverseRecursively l1 = new ReverseRecursively();
        Node one = new Node(1);
        one.next = new Node(3);
        one.next.next = new Node(5);

        ReverseRecursively reverseRecursively = new ReverseRecursively();
        Node node = l1.reverseRecursively(one);
        reverseRecursively.print(node);

    }
}
