package linkedlist;

public class DoublyLinkedList {

    Node head;

    public void insert(int data){
        if(head == null){
            head = new Node(data);
            return;
        }
        else{
            Node newNode = new Node(data);

            Node temp = head;
            while(temp.next!=null){
                temp = temp.next;
            }

            newNode.prev = temp;
            temp.next = newNode;
        }

    }

    public void insertFirst(int data){
        Node newNode = new Node(data);
        newNode.next = head;
        head.prev = newNode;
        head = newNode;

    }

    public void insertAtPos(int data, int pos){
        if(pos==0)
            insertFirst(data);
        else{
            Node newNode = new Node(data);
            Node temp = head;
            while(pos>1 && temp.next!=null){
                pos-=1;
                temp = temp.next;
            }
            if(pos==1){
                if(temp.next == null){
                    temp.next = newNode;
                    newNode.prev = temp;
                }
                else{
                    newNode.next = temp.next;
                    newNode.prev = temp;
                    temp.next.prev = newNode;
                    temp.next = newNode;
                }
            }
            else{
                System.out.println("beyond size.");
            }
        }
    }

    //deletion similar way

    public void printReverse(Node head){
        while(head!=null){
            System.out.print(head.data+" ");
            head = head.prev;
        }
        System.out.println();
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
        DoublyLinkedList l1 = new DoublyLinkedList();
        l1.insert(1);
        l1.insert(2);
        l1.insert(3);
        l1.insert(4);
        l1.print();//1 2 3 4
        l1.insertFirst(0);
        l1.print();//0 1 2 3 4

        l1.insertAtPos(5,5);
        l1.print();//0 1 2 3 4 5

        l1.insertAtPos(6,5);
        l1.print();//0 1 2 3 4 6 5
    }

    }

