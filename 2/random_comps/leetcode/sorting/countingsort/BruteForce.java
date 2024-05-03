package sorting.countingsort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class BruteForce {

    static class Pair{
        int num;
        int appearance;

        public Pair(int num) {
            this.num = num;
            this.appearance = 0;
        }
        public void incrementAppearance(){
            this.appearance+=1;
        }
    }

    public static void main(String[] args) {

        int[] arr1 = {2,3,1,3,2,4,6,7,9,2,19};
        int[] arr2 = {2,1,4,3,9,6};

        HashMap<Integer,Integer> mapNumToPriority = new HashMap<>();
        int priority = 0;
        for(int i:arr2){
            mapNumToPriority.put(i,priority++);
        }

        ArrayList<Integer> numsNotInArr2 = new ArrayList<>();
        HashMap<Integer, Pair> mapNumInOrder = new HashMap<>();

        for(int i:arr1){
            boolean keyExists = mapNumToPriority.containsKey(i);
            if(keyExists){
                //2->0
                int valInPriorityMap = mapNumToPriority.get(i);
                Pair pairInOrderMap = mapNumInOrder.get(valInPriorityMap);
                if(pairInOrderMap!=null){
                    //0->(2,1)
                    pairInOrderMap.incrementAppearance();
                    mapNumInOrder.put(valInPriorityMap,pairInOrderMap);
                }
                else{
                    //0->(2,0)
                    mapNumInOrder.put(valInPriorityMap,new Pair(i));
                }
            }
            else{
                numsNotInArr2.add(i);
            }
        }

        Arrays.sort(numsNotInArr2.toArray());

        for(Map.Entry<Integer, Pair> entry: mapNumInOrder.entrySet()){
            System.out.println(entry.getKey()+" "+entry.getValue().num+" "+entry.getValue().appearance);
        }

    }

}
