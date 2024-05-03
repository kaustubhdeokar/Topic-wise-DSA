package recursion;

public class StringRecursion {

    public static void main(String[] args) {

        StringRecursion recursion = new StringRecursion();
        ArrayList<String> subsets = recursion.iterativeSubSets("abc");
        for (String s : subsets) {
            System.out.print(s + " ");
        }
    }        
        

   public ArrayList<String> iterativeSubSets(String s){
        ArrayList<String> list = new ArrayList<>();
        list.add("");
        list.add(s.substring(0,1));

        for(int i=1;i<s.length();i++){
            int k = list.size();
            for(int j=0;j<k;j++){
                StringBuilder stringBuilder = new StringBuilder(list.get(j));
                stringBuilder.append(s.charAt(i));
                list.add(stringBuilder.toString());
            }
        }
        return list;
	}

}
