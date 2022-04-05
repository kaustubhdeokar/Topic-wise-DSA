https://www.hackerrank.com/challenges/insert-a-node-at-the-head-of-a-linked-list/submissions/code/256025756
    // Complete the insertNodeAtHead function below.

    /*
     * For your reference:
     *
     * SinglyLinkedListNode {
     *     int data;
     *     SinglyLinkedListNode next;
     * }
     *
     */
    static SinglyLinkedListNode insertNodeAtHead(SinglyLinkedListNode head, int data) {
        
    
        SinglyLinkedListNode newNode = new SinglyLinkedListNode(data);
        if(head == null){
            head = newNode;
        }
        else{
            newNode.next = head;
            head = newNode;
        }
        return head;
    }


