import java.util.ArrayList;

//same technique is used when performing range update queries in O(1).

public class MaximumAppearingElem {
    
    public static void main(String[] args) {
        
            int[] start = {1,2,4};
            int[] end = {4,5,7};

            calculateMaxOccuringNumberInRanges(start, end);
    		
    }

    public static int[] calculateMaxOccuringNumberInRanges(int[] start, int[] end){

        ArrayList<Integer> list = new ArrayList<>();
        for(int i=0;i<start.length;i++){
            if(list.size()<=end[i]){
                for(int j=list.size();j<=(end[i]+1);j++){
                    list.add(0);
                }
            }
            list.set(start[i],1);
            list.set(end[i]+1,-1);
            System.out.println(list);;
        }
        int counter = 0;
        for(int i=0;i<list.size();i++){
            if(list.get(i)>0) counter+=1;
            if(list.get(i)<0) counter-=1;
            list.set(i, counter);
        }

        System.out.println(list);

        return new int[]{1};
    }

}
