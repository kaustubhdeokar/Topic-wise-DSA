package LL.problems;

public class ListNode {

    int val;
    ListNode next;

    ListNode head;

    public ListNode(int val) {
        this.val = val;
    }

    public ListNode() {

    }

    public void insert(int data) {
        if (head == null) {
            head = new ListNode(data);
            return;
        }
        ListNode temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = new ListNode(data);
    }
}
