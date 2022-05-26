public class Tree {

    Node head;

    Node insert(Node head, int val) {
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

    void traverseInOrder(Node head) {
        if (head == null)
            return;
        traverseInOrder(head.left);
        System.out.println(head.val);
        traverseInOrder(head.right);
    }

}
