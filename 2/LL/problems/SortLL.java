package linkedlist;

public class SortLL {


    public Node mergeSort(Node head) {

        if (head ==null || head.next == null)
            return head;

        Node mid = middleNode(head);
        Node left = createList(head, mid);
        Node right = createList(mid);
        left = mergeSort(left);
        right = mergeSort(right);

        return mergeWithNewList(left, right);
    }

    private Node createList(Node head, Node middleNode) {
        Node newNode = new Node(0);
        Node tail = newNode;
        while (head != middleNode) {
            tail.next = head;
            head = head.next;
            tail = tail.next;
        }
        tail.next = null;
        return newNode.next;
    }

    private Node createList(Node mid) {
        Node newNode = new Node(0);
        Node tail = newNode;
        while (mid != null) {
            tail.next = mid;
            mid = mid.next;
            tail = tail.next;
        }
        return newNode.next;
    }


    public Node middleNode(Node head) {
        Node fast = head;
        Node slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }

    public Node mergeWithNewList(Node head1, Node head2) {

        Node newHead = new Node(0);
        Node tail = newHead;

        while (head1 != null && head2 != null) {
            if (head1.data <= head2.data) {
                tail.next = head1;
                head1 = head1.next;
            } else {
                tail.next = head2;
                head2 = head2.next;
            }
            tail = tail.next;
        }
        if (head1 == null)
            tail.next = head2;
        else
            tail.next = head1;

        return newHead.next;
    }

    public static void main(String[] args) {

        LinkedList l1 = new LinkedList();
        l1.insert(6);
        l1.insert(5);
        l1.insert(4);
        l1.insert(1);
        l1.insert(2);
        l1.insert(3);

        SortLL sortLL = new SortLL();
        Node newHead = sortLL.mergeSort(l1.head);

        while (newHead != null) {
            System.out.println(newHead.data);
            newHead = newHead.next;
        }



    }

}

