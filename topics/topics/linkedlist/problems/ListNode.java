package linkedlist.problems;

public class ListNode {

    int val;
    ListNode next;

    public ListNode(int data) {
        this.val = data;
    }

    public ListNode() {

    }

    public ListNode createList(int... nums) {
        ListNode head = new ListNode(-1);
        ListNode result = head;
        for (int n : nums) {
            head.next = new ListNode(n);
            head = head.next;
        }
        return result.next;
    }

    public void print(ListNode node) {
        while (node != null) {
            System.out.print(node.val + " ");
            node = node.next;
        }
        System.out.println();
    }

    public void print() {
        print(this);
    }
}
