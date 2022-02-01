  static int findMergeNode(SinglyLinkedListNode head1, SinglyLinkedListNode head2) {

        SinglyLinkedListNode temp1 = head1;
        SinglyLinkedListNode temp2;
        
        while(temp1!=null){
            temp2 = head2;
            while(temp2!=null){
                if(temp1==temp2 && temp1.next==temp2.next){
                    return temp1.data;
                }
                
                temp2 = temp2.next;
            }
            temp1 = temp1.next;
        }
        return 0;
        
    }
