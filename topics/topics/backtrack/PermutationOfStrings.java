package backtrack;

public class PermutationOfStrings {

    public static void main(String[] args) {

        String s = "abc";
        PermutationOfStrings permute = new PermutationOfStrings();
        permute.permute(new StringBuilder(s), 0);
    }

    private void permute(StringBuilder s, int idx){
        if(idx==s.length()){
            System.out.println(s);
            return;
        }
        for (int i=idx;i<s.length();i++){
            System.out.println("i:"+i+" idx:"+idx);
            swap(s, i, idx);
            permute(s, idx+1);
            swap(s, i, idx);
        }
    }


    void swap(StringBuilder s, int i, int j) {

        char temp = s.charAt(i);
        s.setCharAt(i, s.charAt(j));
        s.setCharAt(j, temp);
    }

}
