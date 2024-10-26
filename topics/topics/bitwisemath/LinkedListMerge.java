package bitwisemath;

public class LinkedListMerge {


    class LinkedList {
        int val;
        LinkedList next;

        LinkedList(int data) {
            this.val = data;
        }

        public LinkedList createLinkedList(Integer... args) {

            LinkedList list = new LinkedList(-1);
            LinkedList temp = list;
            for (int i : args) {
                temp.next = new LinkedList(i);
                temp = temp.next;
            }
            return list.next;
        }


        public LinkedList merge(LinkedList[] lists) { //3   //2   //0

            //result
            LinkedList result = new LinkedList(-1);
            LinkedList temp = result;

            int endReached = 0; // number of lists done traversing.

            while (endReached < lists.length) {

                int smallest = Integer.MAX_VALUE;
                int index = -1;

                for (int i = 0; i < lists.length; i++) {

                    if (lists[i] != null && lists[i].val < smallest) {
                        smallest = lists[i].val;
                        index = i;
                    }
                }

                temp.next = new LinkedList(lists[index].val);
                temp = temp.next;
                lists[index] = lists[index].next;
                if (lists[index] == null) {
                    endReached += 1;

                }

            }

            return result.next;

        }

        public void printLinkedList(LinkedList list){
            while(list!=null){
                System.out.print(list.val+" ");
                list = list.next;
            }
            System.out.println();
        }

    }


    public static void main(String[] args) {

        LinkedListMerge llm = new LinkedListMerge();
        llm.perform();




    }

    private void perform() {
        LinkedList master = new LinkedList(-1);
        LinkedList list1 = master.createLinkedList(1,2,3,4);
        LinkedList list2 = master.createLinkedList(2,4,6,8);
        LinkedList list3 = master.createLinkedList(0,9,10,11);
        master.printLinkedList(list1);
        master.printLinkedList(list2);
        master.printLinkedList(list3);

        System.out.println("merging");

        LinkedList[] lists = new LinkedList[]{list1, list2, list3};
        LinkedList result = master.merge(lists);
        master.printLinkedList(result);
    }

}
