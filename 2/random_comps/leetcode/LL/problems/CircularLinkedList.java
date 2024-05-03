package LL.problems;

import traversal.Node;

public class CircularLinkedList {

    Node head;
    Node tail;

    public void insert(int data) {
        if (head == null) {
            head = new Node(data);
            tail = head;
            return;
        }
        Node newNode = new Node(data);
        tail.next = newNode;
        newNode.next = head;
        tail = newNode;
    }

    public void delete(int data) {

        //head null
        if (head == null)
            return;

        //to delete head.

        if (head.data == data) {
            tail.next = head.next;
            head = head.next;
            return;
        }

        //to delete tail.

        Node temp = head;
        while (temp.next.data != data) {
            temp = temp.next;
        }
        if (temp.next == tail) {
            tail = temp;
            System.out.println("tail is =" + tail.data);
        }
        temp.next = temp.next.next;

    }


    public void print() {
        Node temp = head;

        if (temp == null)
            return;
        do {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        while (temp != head);
        System.out.println();
    }


    public static void main(String[] args) {

        CircularLinkedList circularLinkedList = new CircularLinkedList();
        circularLinkedList.insert(1);
        circularLinkedList.insert(2);
        circularLinkedList.insert(3);
        circularLinkedList.print();
        circularLinkedList.insert(4);
        circularLinkedList.insert(5);
        circularLinkedList.print(); // 1 2 3 4 5

        //delete head -> 1
        circularLinkedList.delete(1);
        circularLinkedList.print(); //2 3 4 5
        circularLinkedList.delete(5);
        circularLinkedList.print(); //2 3 4(tail)

    }

}
