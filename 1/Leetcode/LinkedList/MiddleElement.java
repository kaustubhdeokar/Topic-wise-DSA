//code for Linked List

import java.util.LinkedList;

class MiddleElement {

    Node head;

    void appendNode(int data) {
        if (head == null) {
            head = new Node(data);
            return;
        }
        Node current = head;
        while (current.next != null) {
            current = current.next;
        }
        current.next = new Node(data);
    }


    void print() {
        while (head != null) {
            System.out.println(head.data);
            head = head.next;
        }
    }

    int binaryToInt(Node list) {
        StringBuilder ints = new StringBuilder();
        while (list != null) {
            ints.append(list.data);
            list = list.next;
        }
        ints.reverse();
        String number = ints.toString();
        long value = 0;
        for (int i = 0; i < number.length(); i++) {
            value += Math.pow(2, i) * Character.getNumericValue(number.charAt(i));
        }
        return (int) value;
    }

    public Node middleNode(Node head) {
        Node current = head;
        while (head != null && head.next != null) {
            current = current.next;
            head = head.next.next;
        }
        return current;
    }

    public static void main(String[] args) {
        MiddleElement list = new MiddleElement();
        list.appendNode(1);
        list.appendNode(0);
        list.appendNode(1);
    }


}
