package tree;

import java.util.*;

public class ChooseKWorkers {

    class WageToQuality {
        double wage;
        double quality;

        public WageToQuality(double wage, double quality) {
            this.wage = wage;
            this.quality = quality;
        }
    }

    public static void main(String[] args) {

        int[] wages = {70, 50, 30};
        int[] quality = {10, 20, 5};
        int k = 2;
        ChooseKWorkers ck = new ChooseKWorkers();
        ck.solve(wages, quality, k);


    }

    private void solve(int[] wages, int[] quality, int k) {
        Comparator<WageToQuality> comparator = Comparator.comparingDouble(c -> c.wage / c.quality);
        List<WageToQuality> list = new ArrayList<>();
        for (int i = 0; i < wages.length; i++) {
            list.add(new WageToQuality(wages[i], quality[i]));
        }
        list.sort(comparator);

        Comparator<Integer> comp1 = (c1,c2)->Integer.compare(c2,c1);
        PriorityQueue<Integer> m = new PriorityQueue<>(comp1);
        m.add(1);
        m.add(2);

        while(!m.isEmpty()){
            System.out.println(m.remove());
        }
    }

}
