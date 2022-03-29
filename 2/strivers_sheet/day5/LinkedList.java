class Node{
    int data;
    Node next;

    Node(int data){
        this.data=data;
        this.next = null;
    }
}


public class LinkedList{

    Node head;

    public Node insert(int data) {
        if (head == null) {
            head = new Node(data);
            return head;
        }
        Node temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = new Node(data);
        return head;
    }

    public Node reverseLL(Node head){

        Node newHead = null;

        while(head!=null){
            Node next = head.next;
            head.next = newHead;
            newHead = head;
            head = next;
        }
        return newHead;

    }

    public Node middleLL(Node head){
        Node fast = head;
        Node slow = head;

        while(fast!=null && fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    public void traverse(Node head) {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    public Node insertFirst(Node n1){
        if(head==null){
            return n1;
        }
        else{
            n1.next = head;
            head = n1;
        }
        return head;
    }

    public void mergeTwoLL(LinkedList list1, Node head){
    
        

    }


    public static void main(String[] main){
        LinkedList list = new LinkedList();
        list.insert(1);
        list.insert(3);
        list.insert(5);

        LinkedList list2 = new LinkedList();
        list2.insert(0);
        list2.insert(2);
        list2.insert(4);

        
    }

}