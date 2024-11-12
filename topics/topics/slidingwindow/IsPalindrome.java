package slidingwindow;

public class IsPalindrome {
    public static void main(String[] args) {
            String s = "Was it a car or a cat I saw?";
            int l = 0;
            int r = s.length()-1;
            while(l<r){
                while(!Character.isAlphabetic(s.charAt(l))) l++;
                while(!Character.isAlphabetic(s.charAt(r))) r--;
                char left = s.charAt(l);
                if(Character.isUpperCase(s.charAt(l))){
                    left = Character.toLowerCase(s.charAt(l));
                }
                char right = s.charAt(r);
                if(Character.isUpperCase(s.charAt(r))){
                    right = Character.toLowerCase(s.charAt(r));
                }
                System.out.println(left+":"+right);
                l+=1;
                r-=1;
            }
    }
}
