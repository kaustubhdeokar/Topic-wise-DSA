import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {


        List<Integer> ls = new ArrayList<>();
        ls.add(2);
        ls.add(1);
        ls.add(5);
        ls.add(4);
        ls.sort(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1+o2;
            }
        });

        for(Integer l: ls){
            System.out.println(l);
        }

    }
}
