package linkedlist;

public class InsertRecursivelyLL {

    Node head;

    
    public void insertRecursively(int data){
        Node temp = head;
        head = insertRecursively(data,temp);
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

