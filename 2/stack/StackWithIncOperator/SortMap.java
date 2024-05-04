package stack.StackWithIncOperator;

import java.util.*;

public class SortMap {

    static class MapAccToBalance{
        String acc;
        int balance;

        public MapAccToBalance(String acc, int balance) {
            this.acc = acc;
            this.balance = balance;
        }
    }
    public static void main(String[] args) {

        List<MapAccToBalance> list = new ArrayList<>();
        list.add(new MapAccToBalance("accA",2));
        list.add(new MapAccToBalance("accB",2));
        Comparator<MapAccToBalance> c = (c1, c2) -> {
            if(c1.balance == c2.balance){
                return c1.acc.compareTo(c2.acc);
            }
            return Integer.compare(c1.balance, c2.balance);
        };
        Collections.sort(list,c);

    }
}
