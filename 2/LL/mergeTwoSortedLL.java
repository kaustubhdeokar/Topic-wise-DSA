

    // Complete the mergeLists function below.

    /*
     * For your reference:
     *
     * SinglyLinkedListNode {
     *     int data;
     *     SinglyLinkedListNode next;
     * }
     *
     */
    static SinglyLinkedListNode mergeLists(SinglyLinkedListNode head1, SinglyLinkedListNode head2) {
            
            SinglyLinkedList newList = new SinglyLinkedList();
            if(head1 == null){
                return head2;
            }
            if(head2 == null){
                return head1;
            }
            while(head1!=null && head2!=null){
                if(head1.data < head2.data){
                    newList.insertNode(head1.data);
                    head1 = head1.next;
                }
                else{
                    newList.insertNode(head2.data);
                    head2 = head2.next;
                }
            }
            while(head1!=null){
                newList.insertNode(head1.data);
                head1 = head1.next;
            }
            while(head2!=null){
                newList.insertNode(head2.data);
                head2 = head2.next;
            }
            return newList.head;

    }


