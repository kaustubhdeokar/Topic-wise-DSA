package LL.problems;

import java.util.*;

import traversal.Node;



public class LL {

    Node head;

    public void append(int data) {

        Node newNode = new Node(data);

        if (head == null) {
            head = newNode;
            return;
        }

        Node temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = newNode;

    }

    public void printList() {

        Node current = head;
        while (current != null) {
            System.out.println(current.data);
            current = current.next;
        }

    }


    public void prepend(int data) {

        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            return;
        }

        newNode.next = head;
        head = newNode;
    }

    public void delete(int value) {

        if (head == null) return;
        if (head.data == value) {
            head = head.next;
            return;
        }
        Node temp = head;
        while (temp.next != null) {
            if (temp.next.data == value) {
                temp.next = temp.next.next;
                return;
            }
            temp = temp.next;
        }

    }

    private void reversePrint(Node head) {
        if (head == null) {
            return;
        }
        reversePrint(head.next);
        System.out.println(head.data);
    }


    private void inPlaceReverse() {


        Node curr = head;
        Node onePosAhead = head.next;
        Node twoPosAhead = head.next.next;

        curr.next = null;

        while (onePosAhead != null) {
            onePosAhead.next = curr; //reversed curr element.
            curr = onePosAhead;
            onePosAhead = twoPosAhead;
            if (twoPosAhead == null) break;
            twoPosAhead = twoPosAhead.next;
        }

        head = curr;

    }

    public void removeDuplicates() {
        Node curr = head;
        Map<Integer, Integer> mapNumToOccurence = new LinkedHashMap<>();
        while (curr != null) {
            Integer numberOccurrence = mapNumToOccurence.get(curr.data);
            mapNumToOccurence.put(curr.data, numberOccurrence == null ? 1 : numberOccurrence + 1);
            curr = curr.next;
        }

        LL newHead = new LL();

        mapNumToOccurence.entrySet().forEach(entry -> newHead.append(entry.getKey()));

        head = newHead.head;

//        if (head == null) {
//            return;
//        }
//
//        if (mapNumToOccurence.get(head.data) > 1) {
//            mapNumToOccurence.put(head.data, mapNumToOccurence.get(head.data) - 1);
//            head = head.next;
//        }
//
//        while (head != null && head.next != null) {
//            if (mapNumToOccurence.get(head.data) > 1) {
//                mapNumToOccurence.put(head.data, mapNumToOccurence.get(head.data) - 1);
//                head.next = head.next.next;
//            }
//            else{
//
//                head = head.next;
//            }
//        }

        return;
    }

    public Node mergeList(LL ll, LL ll2) {
        Node head1 = ll.head;
        Node head2 = ll2.head;

        LL newList = new LL();
        if (head1 == null) {
            return head2;
        }
        if (head2 == null) {
            return head1;
        }
        while (head1 != null && head2 != null) {
            if (head1.data < head2.data) {
                newList.append(head1.data);
                head1 = head1.next;
            } else {
                newList.append(head2.data);
                head2 = head2.next;
            }
        }
        while (head1 != null) {
            newList.append(head1.data);
            head1 = head1.next;
        }
        while (head2 != null) {
            newList.append(head2.data);
            head2 = head2.next;
        }
        return newList.head;


    }


    public static void main(String[] args) {

        LL ll = new LL();
        ll.append(1);
        ll.append(3);
        ll.append(5);
        LL ll2 = new LL();
        ll2.append(2);
        ll2.append(4);


        ll.inPlaceReverse();
        mergeLists(ll, ll2);


    }

    private static void mergeLists(LL ll, LL ll2) {
        Node node = ll.mergeList(ll, ll2);
        while (node != null) {
            System.out.println(node.data);
            node = node.next;
        }
    }

}

