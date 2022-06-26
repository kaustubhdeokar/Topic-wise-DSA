import org.w3c.dom.Node;

import java.util.LinkedList;

public class InsertRecursivelyLL {

    Node head;


    public void insertRecursively(int data){
        Node temp = head;
        head = insertRecursively(data,temp);
    }





    public void print() {
        Node temp = this.head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
       
        LinkedList l2 = new LinkedList();
        l2.insertRecursively(1);
        l2.insertRecursively(2);
        l2.insertRecursively(3);
        l2.print();

        l2.insertRecursivelyAtPos(4,0); // 4 1 2 3
        l2.print();
        l2.insertRecursivelyAtPos(5,1); // 4 5 1 2 3
        l2.print();
        l2.insertRecursivelyAtPos(6,5); // 4 5 1 2 3
        l2.print();
    }

}

