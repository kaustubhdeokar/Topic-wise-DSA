package string.problems;

public class MinIndex {
    public static void main(String[] args) {
        String sentence = "i love eating burger";
        String searchBox = "burg";
        String[] words = sentence.split(" ");
        int index = 1;
        for(String word: words){
            if(word.contains(searchBox)){
                System.out.println(index);
                break;
            }
            index+=1;
        }
        System.out.println(-1);



    }
}
