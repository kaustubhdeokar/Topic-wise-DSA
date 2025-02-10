package dp.strings;

public class RegularExpressionMatching {

    public static void main(String[] args) {

        RegularExpressionMatching regMatch = new RegularExpressionMatching();
        System.out.println(regMatch.isMatch("aab","c*a*b"));
    }

    public boolean isMatch(String s, String p) {
        return isMatch(s, 0, p, 0);
    }


    public boolean isMatch(String s, int sl, String p, int pl){

        if(sl==s.length() && pl==p.length()) return true;
        if(sl==s.length() || pl==p.length()) return false;

        if(p.charAt(pl)=='.'){
            if((pl+1)<p.length() && (p.charAt(pl+1)=='*')) return true;
            return isMatch(s, sl+1, p, pl+1);
        }
        else if(s.charAt(sl) == p.charAt(pl)){
            if((pl+1)<p.length() && p.charAt(pl+1)=='*'){
                while(sl<s.length() && s.charAt(sl)==p.charAt(pl)){
                    sl+=1;
                }
                return isMatch(s, sl, p, pl+2);
            }
            else return isMatch(s, sl+1, p, pl+1);
        }

        else{
            if((pl+1)<p.length() && p.charAt(pl+1)=='*'){
                return isMatch(s, sl, p, pl+2);
            }
            return false;
        }

    }

}
