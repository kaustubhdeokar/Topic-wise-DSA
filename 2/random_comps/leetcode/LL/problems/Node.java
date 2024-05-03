package LL.problems;

public class Node {

    Node head;
    int data;
    Node next;

    Node(int data) {
        this.data = data;
    }

    public void insert(int data) {
        if (head == null) {
            head = new Node(data);
            return;
        }
        Node temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = new Node(data);
    }


}