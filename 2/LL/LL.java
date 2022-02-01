import java.util.*;

class Node {

    int data;
    Node next;

    Node(int data) {
        this.data = data;
    }

}

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

    public void reversePrint() {

        List<Integer> list = new ArrayList<>();
        Node llist = head;
        while (llist != null) {
            list.add(llist.data);
            llist = llist.next;
        }

        Collections.reverse(list);

        list.forEach(System.out::println);

    }


    private void inPlaceReverse() {


        Node curr = head;
        Node onePosAhead = head.next;
        Node twoPosAhead = head.next.next;

        while (onePosAhead != null) {
            onePosAhead.next = curr; //reversed curr element.
            curr = onePosAhead;
            onePosAhead = twoPosAhead;
            if (twoPosAhead == null) break;
            twoPosAhead = twoPosAhead.next;
        }

        Node temp = curr;
        while (temp != null) {
            System.out.println(temp.data);
        }


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


    public static void main(String[] args) {

        LL ll = new LL();
        ll.append(3);
        ll.append(3);
        ll.append(3);
        ll.append(4);
        ll.append(5);
        ll.append(5);
        ll.removeDuplicates();
        ll.printList();

    }

}

