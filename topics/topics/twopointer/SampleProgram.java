package twopointer;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.stream.Collectors;

/*

Write a java program to find frequency of each element in an array or a list using stream API?


* */
public class SampleProgram {
    public static void main(String[] args) {
        List<String> stationeryList = Arrays.asList("Pen", "Eraser",
                "Note Book", "Pen", "Pencil", "Paper clip", "Stapler",
                "Note Book", "Pencil", "Paper clip");

        Map<String, Integer> frequencyMap = new HashMap<>();

        //way 1
        //stationeryList.stream().forEach(s -> frequencyMap.merge(s, 1, Integer::sum));

        //way2
//        Consumer<String> addToMap = (String s) -> {
//            frequencyMap.merge(s, 1, Integer::sum);
//        };
//        stationeryList.stream().forEach(s -> addToMap.accept(s));

        //way 3 group by
        Map<String, Long> collect = stationeryList.stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        System.out.println(collect);


    }
}
