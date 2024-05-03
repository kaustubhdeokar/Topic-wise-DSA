package LL.problems;

import traversal.Node;

public class LinkedList {

    Node head;

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

    public void insertFirst(int data) {
        if (head == null) {
            head = new Node(data);
            return;
        } else {
            Node newNode = new Node(data);
            newNode.next = head;
            head = newNode;
        }
    }

    public void insertAtPos(int data, int pos) {
        if (pos == 0)
            insertFirst(data);
        else {
            Node temp = head;
            while (pos > 1 && temp.next != null) {
                pos -= 1;
                temp = temp.next;
            }
            if (pos == 1 && temp.next != null) {
                //insert in middle.
                Node newNode = new Node(data);
                newNode.next = temp.next;
                temp.next = newNode;
            } else if (pos == 1 && temp.next == null) {
                temp.next = new Node(data);
            } else {
                System.out.println("size overflow.");
            }


        }
    }

    public void deleteFirst(Node head) {
        this.head = head.next;
    }


    public void deleteAtPos(Node head, int pos) {
        if (pos == 0)
            deleteFirst(head);
        else {
            Node temp = head;
            while (pos > 1 && temp.next != null) {
                pos -= 1;
                temp = temp.next;
            }
            if (temp.next != null) {
                temp.next = temp.next.next;
            }
        }

    }

    public void print() {
        Node temp = this.head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    public Node insertRecursively(int data, Node head){
        if(head == null)
        {
            head = new Node(data);
            return head;
        }
        head.next = insertRecursively(data,head.next);
        return head;
    }

    public void insertRecursivelyAtPos(int data,int pos){
        Node temp = head;
        head = insertRecursivelyAtPos(data,temp,pos);
    }

    public Node insertRecursivelyAtPos(int data, Node head,int pos){
        if(pos == 0)
        {
            Node newNode = new Node(data);
            newNode.next = head;
            return newNode;
        }
        head.next = insertRecursivelyAtPos(data,head.next,pos-1);
        return head;
    }

    public static void main(String[] args) {
        LinkedList l1 = new LinkedList();
        l1.insert(1);
        l1.insert(2);
        l1.print();
        l1.insertFirst(0);
        l1.insert(3);
        l1.print();

        l1.insertAtPos(4, 4); // 0 1 2 3 4
        l1.print();
        l1.insertAtPos(5, 4); // 0 1 2 3 5 4
        l1.print();
        l1.insertAtPos(-1, 0); // -1 0 1 2 3 5 4
        l1.print();

        l1.deleteFirst(l1.head);
        l1.print(); // 0 1 2 3 5 4

        l1.deleteAtPos(l1.head,1);
        l1.print(); // 0 2 3 5 4

        l1.deleteAtPos(l1.head,4);
        l1.print(); // 0 2 3 5
    }

}
