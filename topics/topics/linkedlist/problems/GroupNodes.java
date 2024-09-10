package linkedlist.problems;

import linkedlist.LLNode;
//725. Split Linked List in Parts
//daily problem sep 8.
public class GroupNodes {

    public LLNode[] splitListToParts(LLNode head, int k) {

        LLNode temp = head;
        int count = 0;
        while(temp!=null){
            count+=1;
            temp = temp.next;
        }

        int nodesPerGroup = count/k;
        int remainder = count%k;
        LLNode[] array = new LLNode[k];

        for(int group = 0; group < k; group ++)
        {
            LLNode groupHead = new LLNode(0);
            temp = groupHead;

            for(int node = 0; node< nodesPerGroup; node++)
            {
                if(head==null){
                    continue;
                }
                temp.next = new LLNode(head.val);
                temp = temp.next;
                head = head.next;
            }

            if(remainder>0){
                if(head==null){
                    continue;
                }
                temp.next = new LLNode(head.val);
                temp = temp.next;
                head = head.next;
                remainder-=1;
            }

            array[group] = groupHead.next;
        }

        return array;

    }
    
    public static void main(String[] args) {

        LLNode llNode = new LLNode();
        LLNode list = llNode.createLLNodeList(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10});

        GroupNodes groupNodes = new GroupNodes();
        LLNode[] llNodes = groupNodes.splitListToParts(list, 3);

        groupNodes.print(llNodes);

        list = llNode.createLLNodeList(new int[]{1, 2, 3});
        llNodes = groupNodes.splitListToParts(list, 5);
        groupNodes.print(llNodes);
    }

    private void print(LLNode[] llNodes) {
        for(LLNode llNode: llNodes){
            LLNode temp = llNode;
            while(temp!=null){
                System.out.print(temp.val +" ");
                temp = temp.next;
            }
            System.out.println();
        }
    }

}
