package linkedlist;
import ListNode;

public class SortLL {


    public ListNode mergeSort(ListNode head) {

        if (head ==null || head.next == null)
            return head;

        ListNode mid = middleNode(head);
        ListNode left = createList(head, mid);
        ListNode right = createList(mid);
        left = mergeSort(left);
        right = mergeSort(right);

        return mergeWithNewList(left, right);
    }

    private ListNode createList(ListNode head, ListNode middleNode) {
        ListNode newNode = new ListNode(0);
        ListNode tail = newNode;
        while (head != middleNode) {
            tail.next = head;
            head = head.next;
            tail = tail.next;
        }
        tail.next = null;
        return newNode.next;
    }

    private ListNode createList(ListNode mid) {
        ListNode newNode = new ListNode(0);
        ListNode tail = newNode;
        while (mid != null) {
            tail.next = mid;
            mid = mid.next;
            tail = tail.next;
        }
        return newNode.next;
    }


    public ListNode middleNode(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }

    public ListNode mergeWithNewList(ListNode head1, ListNode head2) {

        ListNode newHead = new ListNode(0);
        ListNode tail = newHead;

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
        ListNode newHead = sortLL.mergeSort(l1.head);

        while (newHead != null) {
            System.out.println(newHead.data);
            newHead = newHead.next;
        }



    }

}

