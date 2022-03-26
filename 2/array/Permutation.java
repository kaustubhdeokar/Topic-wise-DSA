import java.util.List;
import java.util.ArrayList;


public class Permutation {

    public void permute(int index,String str,List<String> answer){

        if(index == str.length()){
            answer.add(str);
            return;
        }
        for(int i=index;i<str.length();i++){
            str = swap(i,index,str);
            permute(index+1,str,answer);
            str = swap(index,i,str);
        }
    }

    public String swap(int i,int j,String str){
        char[] ch = str.toCharArray();
        char temp = ch[i];
        ch[i] = ch[j];
        ch[j] = temp;
        return new String(ch);
    }

    public static void main(String[] args) {

        Permutation permutation = new Permutation();
        List<String> answer = new ArrayList<>();
        permutation.permute(0,"12",answer);
        for(String s:answer){
            System.out.print(s+" ");
        }

    }


}
